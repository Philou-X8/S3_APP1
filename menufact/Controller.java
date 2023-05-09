package menufact;

import menufact.exceptions.MenuException;
import menufact.facture.Facture;
import menufact.facture.exceptions.FactureException;
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
    public void platCourantMenu(){
        System.out.println(menu.platCourant());
    }
    public void platSuivantMenu(){
        try{
            menu.positionSuivante();
        }catch (MenuException e){

        }
    }
    public void platPrecedentMenu(){
        try{
            menu.positionSuivante();
        }catch (MenuException e){

        }
    }
}
