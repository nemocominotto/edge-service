package fact.it.edgeservice.model;

public class FilledCyclingRoute {
    private String name;
    private String img_url;
    private String routeCode;
    private String postcode;

    public FilledCyclingRoute(CyclingRoute cyclingRoute){
        setName(cyclingRoute.getName());
        setImg_url(cyclingRoute.getImg_url());
        setRouteCode(cyclingRoute.getRouteCode());
        setPostcode(cyclingRoute.getPostcode());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
