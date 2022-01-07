package fact.it.edgeservice.controller;

import fact.it.edgeservice.model.CyclingRoute;
import fact.it.edgeservice.model.FilledCyclingRoute;
import fact.it.edgeservice.model.FilledRouteReview;
import fact.it.edgeservice.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class FilledRouteReviewController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${reviewservice.baseurl}")
    private String reviewServiceBaseUrl;

    @Value("${cyclingrouteservice.baseurl}")
    private String cyclingRouteServiceBaseUrl;

    @GetMapping("/route/{routeCode}")
    public FilledRouteReview getRouteAndReviews(@PathVariable String routeCode){
        CyclingRoute cyclingRoute = restTemplate.getForObject("http://" + cyclingRouteServiceBaseUrl + "/cyclingRoutes/code/{routeCode}", CyclingRoute.class, routeCode);
        ResponseEntity<List<Review>> responseEntity = restTemplate.exchange("http://" + reviewServiceBaseUrl + "/reviews/code/{routeCode}", HttpMethod.GET, null, new ParameterizedTypeReference<List<Review>>() {
        }, routeCode);

        return new FilledRouteReview(cyclingRoute, responseEntity.getBody());
    }

    @GetMapping("/review/route/{routeCode}/auteur/{auteur}")
    public FilledRouteReview getReviewsAndRoute(@PathVariable String routeCode, @PathVariable String auteur){
        CyclingRoute cyclingRoute = restTemplate.getForObject("http://" + cyclingRouteServiceBaseUrl + "/cyclingRoutes/code/{routeCode}", CyclingRoute.class, routeCode);
        ResponseEntity<List<Review>> responseEntity = restTemplate.exchange("http://" + reviewServiceBaseUrl + "/reviews/auteurs/{auteur}/routeCode/{routeCode}", HttpMethod.GET, null, new ParameterizedTypeReference<List<Review>>() {
        }, auteur, routeCode);

        return new FilledRouteReview(cyclingRoute, responseEntity.getBody());
    }

    @PostMapping("/add/route")
    public CyclingRoute addCyclingRoute(@RequestBody CyclingRoute newCyclingroute){
        CyclingRoute cyclingRoute = restTemplate.postForObject("http://" + cyclingRouteServiceBaseUrl + "/cyclingRoutes/add",
                new CyclingRoute(newCyclingroute.getName(), newCyclingroute.getImg_url(), newCyclingroute.getRouteCode(), newCyclingroute.getPostcode()), CyclingRoute.class);

        return cyclingRoute;
    }

    @PutMapping("update/route")
    public CyclingRoute updateCyclingRoute(@RequestBody CyclingRoute updateCyclingRoute){
        CyclingRoute cyclingRoute =
                restTemplate.getForObject("http://" + cyclingRouteServiceBaseUrl + "/cyclingRoutes/code/" + updateCyclingRoute.getRouteCode(), CyclingRoute.class);

        cyclingRoute.setName(updateCyclingRoute.getName());
        cyclingRoute.setImg_url(updateCyclingRoute.getImg_url());
        cyclingRoute.setPostcode(updateCyclingRoute.getPostcode());

        ResponseEntity<CyclingRoute> responseEntity =
                restTemplate.exchange("http://" + cyclingRouteServiceBaseUrl + "/cyclingRoutes/update", HttpMethod.PUT, new HttpEntity<>(cyclingRoute), CyclingRoute.class);

        CyclingRoute retrievedCyclingroute = responseEntity.getBody();

        return retrievedCyclingroute;
    }

    @DeleteMapping("/delete/route/{routeCode}")
    public ResponseEntity deleteRoute(@PathVariable String routeCode){
        restTemplate.delete("http://" + cyclingRouteServiceBaseUrl + "/cyclingRoutes/delete/" + routeCode);

        return ResponseEntity.ok().build();
    }
}
