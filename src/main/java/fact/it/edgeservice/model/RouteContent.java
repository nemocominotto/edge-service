package fact.it.edgeservice.model;

public class RouteContent {
    private String auteur;
    private String content;
    private String routeCode;

    public RouteContent() {
    }

    public RouteContent(String auteur, String content, String routeCode) {
        this.auteur = auteur;
        this.content = content;
        this.routeCode = routeCode;
    }

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
