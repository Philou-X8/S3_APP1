package menufact.plats;

public class PlatAuMenu {
    private int code;
    private String description;
    private double prix;
    private Recette ingredients;

    public PlatAuMenu(){

    }

    public PlatAuMenu(int code, String description, double prix, Recette recette) {
        this.code = code;
        this.description = description;
        this.prix = prix;
        this.ingredients = recette;
    }
    public PlatAuMenu(int code, String description, double prix) {
        this.code = code;
        this.description = description;
        this.prix = prix;
        this.ingredients = new Recette();
    }

    @Override
    public String toString() {
        return "menufact.plats.PlatAuMenu{" +
                "code=" + code +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                "}\n";
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
