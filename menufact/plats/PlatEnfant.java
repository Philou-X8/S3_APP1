package menufact.plats;

public class PlatEnfant extends PlatAuMenu{
    private double proportion;

    public PlatEnfant() {
    }

    public PlatEnfant(int code, String description, double prix, Recette recette, double proportion) {
        super(code, description, prix, recette);
        this.proportion = proportion;
    }
    public PlatEnfant(int code, String description, double prix, double proportion) {
        super(code, description, prix, new Recette());
        this.proportion = proportion;
    }

    public double getProportion() {
        return proportion;
    }

    @Override
    public String toString() {
        return "PlatEnfant{" +
                "proportion=" + proportion +
                "} " + super.toString();
    }
}
