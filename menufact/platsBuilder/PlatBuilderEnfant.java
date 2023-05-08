package menufact.platsBuilder;

import menufact.plats.PlatAuMenu;
import menufact.plats.PlatEnfant;
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
        PlatAuMenu plat = new PlatEnfant(this.code, this.description, this.prix, this.ingredients, proportion);

        return plat;
    }
}