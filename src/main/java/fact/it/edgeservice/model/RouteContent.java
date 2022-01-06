package fact.it.edgeservice.model;

public class RouteContent {
    private String auteur;
    private String titel;
    private String content;

    public RouteContent() {
    }

    public RouteContent(String auteur, String titel, String content) {
        this.auteur = auteur;
        this.titel = titel;
        this.content = content;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
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
