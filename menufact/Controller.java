package menufact;

import menufact.exceptions.MenuException;
import menufact.facture.Facture;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisiFactory;

public class Controller {
    private Facture facture;
    private Menu menu;
    private PlatChoisiFactory platCreation;
    public Controller(Facture f, Menu m){
        facture = f;
        menu = m;
        platCreation = new PlatChoisiFactory();
    }
    public void ouvrirFacture(){
        try{
            facture.ouvrir();
        }catch (FactureException e){

        }
    }
    public void fermerFacture(){
        try{
            facture.fermer();
        }catch (FactureException e){

        }
    }
    public void payerFacture(){
        try{
            facture.payer();
        }catch (FactureException e){

        }
    }
    public void choisirPlat() throws FactureException
    {
        try{
            facture.ajoutePlat(platCreation.ajoutPlat(menu.platCourant()));
        }catch (FactureException e){
            throw e;
        }
    }
    public PlatAuMenu platCourantMenu(){
        System.out.println(menu.platCourant());
                return menu.platCourant();
    }
    public PlatAuMenu platSuivantMenu(){
        try{
            menu.positionSuivante();
        }catch (MenuException e){

        }
        return menu.platCourant();
    }
    public void platPrecedentMenu(){
        try{
            menu.positionPrecedente();
        }catch (MenuException e){

        }
    }
}
