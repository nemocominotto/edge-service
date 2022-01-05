package fact.it.edgeservice.model;

import java.util.ArrayList;
import java.util.List;

public class FilledRouteReview {
    private String routeName;
    private String imageUrl;
    private String routeCode;
    private List<RouteContent> routeReviews;

    public FilledRouteReview(CyclingRoute cyclingRoute, List<Review> reviews){
        setRouteName(cyclingRoute.getName());
        setImageUrl(cyclingRoute.getImg_url());
        setRouteCode(cyclingRoute.getRouteCode());
        routeReviews = new ArrayList<>();
        reviews.forEach(review -> {
            routeReviews.add(new RouteContent(review.getAuteur(), review.getContent(), review.getRouteId()));
        });
        setRouteReviews(routeReviews);
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

    public List<RouteContent> getRouteReviews() {
        return routeReviews;
    }

    public void setRouteReviews(List<RouteContent> routeReviews) {
        this.routeReviews = routeReviews;
    }
}
