package fact.it.edgeservice.model;

public class CyclingRoute {
    private int id;
    private String name;
    private String img_url;
    private String routeCode;
    private String postcode;

    public CyclingRoute() {
    }

    public CyclingRoute(String name, String img_url, String routeCode, String postcode) {
        this.name = name;
        this.img_url = img_url;
        this.routeCode = routeCode;
        this.postcode = postcode;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
