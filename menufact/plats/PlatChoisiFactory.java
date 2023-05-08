package menufact.plats;

import menufact.Menu;

import java.util.ArrayList;

public class PlatChoisiFactory {
    private ArrayList<PlatChoisi> listePlatChoisi;
    private Menu contexteMenu;
    public PlatChoisiFactory(ArrayList<PlatChoisi> parentList, Menu parentMenu){
        listePlatChoisi = parentList;
        contexteMenu = parentMenu;
    }
    public PlatChoisi ajoutPlat(PlatAuMenu plat){
        for(PlatChoisi platChoisi : listePlatChoisi){ // vérifier que le plat n'est pas déjà dans la liste
            if(plat.getCode() == platChoisi.getPlat().getCode()){
                platChoisi.setQuantite(platChoisi.getQuantite() + 1);
                return platChoisi;
            }
        }
        PlatChoisi ajout = new PlatChoisi(plat, 1);
        listePlatChoisi.add(ajout);
        return ajout;
    }
}
