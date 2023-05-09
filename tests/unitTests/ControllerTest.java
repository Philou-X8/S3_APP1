package tests.unitTests;

import ingredients.Ingredient;
import ingredients.IngredientFactory;
import ingredients.TypeIngredient;
import menufact.Controller;
import menufact.Menu;
import menufact.facture.EtatFacture;
import menufact.facture.EtatFactureFermer;
import menufact.facture.EtatFacturePayer;
import menufact.facture.Facture;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatAuMenu;
import menufact.plats.Recette;
import menufact.platsBuilder.MenuDirector;
import menufact.platsBuilder.PlatBuilder;
import menufact.platsBuilder.PlatBuilderDefault;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void ouvrirFacture() throws FactureException {
        Facture lst = new Facture( "Facture de Jo");
        Menu menu = new Menu("Menu de test");
        Controller control =new Controller( lst,menu);
        control.fermerFacture();
        control.ouvrirFacture();
        assertEquals(new Facture( "Facture de Jo").toString(),lst.toString());
    }

    @Test
    void fermerFacture() throws FactureException {
        Facture lst = new Facture( "Facture de Jo");
        Menu menu = new Menu("Menu de test");
        Controller control =new Controller( lst,menu);
        control.fermerFacture();
        assertEquals(new EtatFactureFermer(lst).toString(),lst.getEtat().toString());
    }

    @Test
    void payerFacture() throws FactureException {
        Facture lst = new Facture( "Facture de Jo");
        Menu menu = new Menu("Menu de test");
        Controller control =new Controller( lst,menu);
        lst.payer();
        assertEquals(new EtatFacturePayer(lst).toString(),lst.getEtat().toString());
    }

    @Test
    void choisirPlat() throws FactureException {
        Facture lst = new Facture( "Facture de Jo");
        Menu menu = new Menu("Menu de test");
        Controller control =new Controller( lst,menu);
        MenuDirector menuDirector = new MenuDirector(new PlatBuilderDefault());
        menuDirector.constructInformation(1, "plat de test 1 (default)", 23.99);
        menuDirector.constructIngrediant("poulet", "c'est du poulet", TypeIngredient.VIANDE, 10.0);
        menuDirector.constructIngrediant("tomate", "rouge et juteux", TypeIngredient.FRUIT, 2.0);
        menuDirector.constructIngrediant("echalote", "petit anneaux vert", TypeIngredient.EPICE, 3.0);
        menuDirector.constructIngrediant("lait", "verre de lait", TypeIngredient.LAITIER, 0.3);
        menu.ajoute(menuDirector.getResult());
        control.choisirPlat();
        Recette recette = new Recette();
        recette.ajouteIngredient(IngredientFactory.createIngredient("poulet", "c'est du poulet", TypeIngredient.VIANDE),10) ;
        recette.ajouteIngredient(IngredientFactory.createIngredient("tomate", "rouge et juteux", TypeIngredient.FRUIT),2.0);
        recette.ajouteIngredient(IngredientFactory.createIngredient("echalote", "petit anneaux vert", TypeIngredient.EPICE),3.0);
        recette.ajouteIngredient(IngredientFactory.createIngredient("lait", "verre de lait", TypeIngredient.LAITIER),0.3);
        assertEquals( new PlatAuMenu(1, "plat de test 1 (default)", 23.99,recette).toString(), menu.platCourant().toString());

    }

    @Test
    void platCourantMenu()
    {

    }

    @Test
    void platSuivantMenu() {
    }

    @Test
    void platPrecedentMenu() {
    }
}