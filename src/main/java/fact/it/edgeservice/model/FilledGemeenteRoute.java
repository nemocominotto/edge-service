package fact.it.edgeservice.model;

import java.util.ArrayList;
import java.util.List;

public class FilledGemeenteRoute {
    private String naam;
    private String postcode;
    private List<GemeenteRoute> routes;

    public FilledGemeenteRoute(Gemeente gemeente, List<CyclingRoute> cyclingRoutes){
        setNaam(gemeente.getNaam());
        setPostcode(gemeente.getPostcode());
        routes = new ArrayList<>();
        cyclingRoutes.forEach(route -> {
            routes.add(new GemeenteRoute(route.getName(), route.getImg_url()));
        });
        setRoutes(routes);
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public List<GemeenteRoute> getRoutes() {
        return routes;
    }

    public void setRoutes(List<GemeenteRoute> routes) {
        this.routes = routes;
    }
}
