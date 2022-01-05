package fact.it.edgeservice.model;

import java.util.ArrayList;
import java.util.List;

public class FilledRouteReview {
    private String routeName;
    private String imageUrl;
    private String routeCode;
    private List<RouteContent> routeContents;

    public FilledRouteReview(CyclingRoute cyclingRoute, List<Review> reviews){
        setRouteName(cyclingRoute.getName());
        setImageUrl(cyclingRoute.getImg_url());
        setRouteCode(cyclingRoute.getRouteCode());
        routeContents = new ArrayList<>();
        reviews.forEach(review -> {
            routeContents.add(new RouteContent(review.getAuteur(), review.getContent(), review.getRouteId()));
        });
        setRouteContents(routeContents);
    }

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<RouteContent> getRouteContents() {
        return routeContents;
    }

    public void setRouteContents(List<RouteContent> routeContents) {
        this.routeContents = routeContents;
    }
}
