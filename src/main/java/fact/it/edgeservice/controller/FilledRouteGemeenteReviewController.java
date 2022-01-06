package fact.it.edgeservice.controller;

import fact.it.edgeservice.model.*;
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
public class FilledRouteGemeenteReviewController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${cyclingrouteservice.baseurl}")
    private String cyclingRouteServiceBaseUrl;

    @Value("${gemeenteservice.baseurl}")
    private String gemeenteServiceBaseUrl;

    @Value("${reviewservice.baseurl}")
    private String reviewServiceBaseUrl;

    @GetMapping("/route/gemeente/{postcode}/reviews/{routeCode}")
    public FilledRouteGemeenteReview getRouteAndGemeenteAndReviews(@PathVariable String postcode, @PathVariable String routeCode){
        CyclingRoute cyclingRoute = restTemplate.getForObject("http://" + cyclingRouteServiceBaseUrl + "/cyclingRoutes/code/{routeCode}", CyclingRoute.class, routeCode);
        Gemeente gemeente = restTemplate.getForObject("http://" + gemeenteServiceBaseUrl + "/gemeentes/postcode/{postcode}", Gemeente.class, postcode);
        ResponseEntity<List<Review>> responseEntity = restTemplate.exchange("http://" + reviewServiceBaseUrl + "/reviews/code/{routeCode}", HttpMethod.GET, null, new ParameterizedTypeReference<List<Review>>() {
        }, routeCode);

        return new FilledRouteGemeenteReview(cyclingRoute, gemeente, responseEntity.getBody());
    }
}
