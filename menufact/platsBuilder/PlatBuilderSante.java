package menufact.platsBuilder;

import menufact.plats.PlatAuMenu;
import menufact.plats.PlatSante;
import menufact.platsBuilder.PlatBuilder;

public class PlatBuilderSante extends PlatBuilder {
    private double kcal;
    private double chol;
    private double gras;
    public PlatBuilderSante(){
        super(); // call parent constructor
        kcal = 0;
        chol = 0;
        gras = 0;
    }
    @Override
    public void constructSante(double k, double c, double g){
        kcal = k;
        chol = c;
        gras = g;
    }
    public PlatAuMenu getPlat(){
        PlatAuMenu plat = new PlatSante(this.code, this.description, this.prix, this.ingredients, kcal, chol, gras);

        return plat;
    }
}