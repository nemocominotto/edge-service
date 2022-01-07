package fact.it.edgeservice.model;

import java.util.ArrayList;
import java.util.List;

public class FilledRouteGemeenteReview {
    private String naam;
    private String img;
    private String startGemeente;
    private String postcode;
    private List<RouteContent> routeReviews;

    public FilledRouteGemeenteReview(CyclingRoute cyclingRoute, Gemeente gemeente, List<Review> reviews){
        setNaam(cyclingRoute.getName());
        setImg(cyclingRoute.getImg_url());
        setStartGemeente(gemeente.getNaam());
        setPostcode(cyclingRoute.getPostcode());
        routeReviews = new ArrayList<>();
        reviews.forEach(review -> {
            routeReviews.add(new RouteContent(review.getAuteur(), review.getTitel(), review.getContent()));
        });
        setRouteReviews(routeReviews);
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getStartGemeente() {
        return startGemeente;
    }

    public void setStartGemeente(String startGemeente) {
        this.startGemeente = startGemeente;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public List<RouteContent> getRouteReviews() {
        return routeReviews;
    }

    public void setRouteReviews(List<RouteContent> routeReviews) {
        this.routeReviews = routeReviews;
    }
}
