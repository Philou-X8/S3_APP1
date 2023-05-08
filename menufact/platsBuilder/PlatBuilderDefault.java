package menufact.platsBuilder;

import menufact.plats.PlatAuMenu;
import menufact.platsBuilder.PlatBuilder;

public class PlatBuilderDefault extends PlatBuilder {
    public PlatBuilderDefault(){
        super(); // call parent constructor
    }
    public PlatAuMenu getPlat(){
        PlatAuMenu plat = new PlatAuMenu(this.code, this.description, this.prix, this.ingredients);

        return plat;
    }
}
