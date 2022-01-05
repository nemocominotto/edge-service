package fact.it.edgeservice.controller;

import fact.it.edgeservice.model.CyclingRoute;
import fact.it.edgeservice.model.FilledRouteReview;
import fact.it.edgeservice.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
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
}
