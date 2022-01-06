package fact.it.edgeservice.model;

public class GemeenteRoute {
    private String naam;
    private String img;

    public GemeenteRoute(String naam, String img) {
        this.naam = naam;
        this.img = img;
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
}
