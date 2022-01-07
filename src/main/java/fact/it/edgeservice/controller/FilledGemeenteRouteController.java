package fact.it.edgeservice.controller;

import fact.it.edgeservice.model.*;
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

    @PostMapping("/add/gemeente")
    public FilledGemeenteRoute addGemeente(@RequestParam String name, @RequestParam String postcode){
        Gemeente gemeente =
                restTemplate.postForObject("http://" + gemeenteServiceBaseUrl + "/gemeente/add",
                        new Gemeente(postcode, name), Gemeente.class);

        ResponseEntity<List<CyclingRoute>> routes =
                restTemplate.exchange("http://" + cyclingRouteServiceBaseUrl + "/cyclingRoutes/postcode/" + postcode,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<CyclingRoute>>() {});

        return new FilledGemeenteRoute(gemeente, routes.getBody());
    }

    @PutMapping("/update/gemeente")
    public FilledGemeenteRoute updateGemeente(@RequestParam String name, @RequestParam String postcode){
        Gemeente gemeente =
                restTemplate.getForObject("http://" + gemeenteServiceBaseUrl + "/gemeentes/postcode/" + postcode,
                        Gemeente.class);

        gemeente.setNaam(name);

        ResponseEntity<Gemeente> updateGemeente =
                restTemplate.exchange("http://" + gemeenteServiceBaseUrl + "/gemeente/update", HttpMethod.PUT, new HttpEntity<>(gemeente), Gemeente.class);

        ResponseEntity<List<CyclingRoute>> routes =
                restTemplate.exchange("http://" + cyclingRouteServiceBaseUrl + "/cyclingRoutes/postcode/" + postcode,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<CyclingRoute>>() {});

        return new FilledGemeenteRoute(gemeente, routes.getBody());
    }

    @DeleteMapping("/delete/gemeente")
    public ResponseEntity deleteGemeente(@RequestParam String postcode){
        restTemplate.delete("http://" + gemeenteServiceBaseUrl + "/gemeente/delete/" + postcode);

        return ResponseEntity.ok().build();
    }
}
