package menufact.platsBuilder;

import menufact.plats.PlatAuMenu;
import menufact.plats.PlatSante;
import menufact.platsBuilder.PlatBuilder;

public class PlatBuilderEnfant extends PlatBuilder {
    private double proportion;
    public PlatBuilderEnfant(){
        super(); // call parent constructor
        proportion = 1;
    }
    @Override
    public void constructEnfant(double p){
        proportion = p;
    }
    public PlatAuMenu getPlat(){
        PlatAuMenu plat = new PlatSante(this.code, this.description, this.prix, this.recette, proportion);

        return plat;
    }
}