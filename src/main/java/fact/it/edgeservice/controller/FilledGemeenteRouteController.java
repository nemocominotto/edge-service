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
public class FilledGemeenteRouteController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${cyclingrouteservice.baseurl}")
    private String cyclingRouteServiceBaseUrl;

    @Value("${gemeenteservice.baseurl}")
    private String gemeenteServiceBaseUrl;

    @GetMapping("/gemeente/route/{postcode}")
    public FilledGemeenteRoute getGemeenteAndRoutes(@PathVariable String postcode){
        Gemeente gemeente = restTemplate.getForObject("http://" + gemeenteServiceBaseUrl + "/gemeentes/postcode/{postcode}", Gemeente.class, postcode);
        ResponseEntity<List<CyclingRoute>> responseEntity = restTemplate.exchange("http://" + cyclingRouteServiceBaseUrl + "/cyclingRoutes/postcode/{postcode}", HttpMethod.GET, null, new ParameterizedTypeReference<List<CyclingRoute>>() {
        }, postcode);

        return new FilledGemeenteRoute(gemeente, responseEntity.getBody());
    }
}
