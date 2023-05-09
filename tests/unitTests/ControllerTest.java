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
import menufact.plats.PlatSante;
import menufact.plats.Recette;
import menufact.platsBuilder.MenuDirector;
import menufact.platsBuilder.PlatBuilder;
import menufact.platsBuilder.PlatBuilderDefault;
import menufact.platsBuilder.PlatBuilderSante;
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


        Recette recette = new Recette();
        recette.ajouteIngredient(IngredientFactory.createIngredient("poulet", "c'est du poulet", TypeIngredient.VIANDE),10) ;
        recette.ajouteIngredient(IngredientFactory.createIngredient("tomate", "rouge et juteux", TypeIngredient.FRUIT),2.0);
        recette.ajouteIngredient(IngredientFactory.createIngredient("echalote", "petit anneaux vert", TypeIngredient.EPICE),3.0);
        recette.ajouteIngredient(IngredientFactory.createIngredient("lait", "verre de lait", TypeIngredient.LAITIER),0.3);
        assertEquals( new PlatAuMenu(1, "plat de test 1 (default)", 23.99,recette).toString(), control.platCourantMenu().toString());

    }

    @Test
    void platCourantMenu()
    {
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


        Recette recette = new Recette();
        recette.ajouteIngredient(IngredientFactory.createIngredient("poulet", "c'est du poulet", TypeIngredient.VIANDE),10) ;
        recette.ajouteIngredient(IngredientFactory.createIngredient("tomate", "rouge et juteux", TypeIngredient.FRUIT),2.0);
        recette.ajouteIngredient(IngredientFactory.createIngredient("echalote", "petit anneaux vert", TypeIngredient.EPICE),3.0);
        recette.ajouteIngredient(IngredientFactory.createIngredient("lait", "verre de lait", TypeIngredient.LAITIER),0.3);
        assertEquals( new PlatAuMenu(1, "plat de test 1 (default)", 23.99,recette).toString(), control.platCourantMenu().toString());
    }

    @Test
    void platSuivantMenu()
    {
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


        menu.ajoute(menuDirector.getResult());
        menuDirector.reset(new PlatBuilderSante());
        menuDirector.constructInformation(2, "plat de test 2 (sante)", 15.99);
        menuDirector.constructSante(500, 600, 700);
        menuDirector.constructIngrediant("salad", "cruchy et vert", TypeIngredient.LEGUME, 10.0);
        menuDirector.constructIngrediant("tomate", "rouge et juteux", TypeIngredient.FRUIT, 2.0);
        menuDirector.constructIngrediant("croutton", "du pain sec c'est un epice", TypeIngredient.EPICE, 3.0);
        menuDirector.constructIngrediant("eau", "verre d'eau comme produit laittier", TypeIngredient.LAITIER, 0.3);
        menu.ajoute(menuDirector.getResult());
        control.platSuivantMenu();
        control.platSuivantMenu();

        Recette recette = new Recette();
        recette.ajouteIngredient(IngredientFactory.createIngredient("salad", "cruchy et vert", TypeIngredient.LEGUME),10) ;
        recette.ajouteIngredient(IngredientFactory.createIngredient("tomate", "rouge et juteux", TypeIngredient.FRUIT),2.0);
        recette.ajouteIngredient(IngredientFactory.createIngredient("croutton", "du pain sec c'est un epice", TypeIngredient.EPICE),3.0);
        recette.ajouteIngredient(IngredientFactory.createIngredient("eau", "verre d'eau comme produit laittier", TypeIngredient.LAITIER),0.3);
        assertEquals(new PlatSante(2, "plat de test 2 (sante)", 15.99,recette,500, 600, 700).toString(),control.platCourantMenu().toString());

    }

    @Test
    void platPrecedentMenu()
    {
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

        menuDirector.reset(new PlatBuilderSante());
        menuDirector.constructInformation(2, "plat de test 2 (sante)", 15.99);
        menuDirector.constructSante(500, 600, 700);
        menuDirector.constructIngrediant("salad", "cruchy et vert", TypeIngredient.LEGUME, 10.0);
        menuDirector.constructIngrediant("tomate", "rouge et juteux", TypeIngredient.FRUIT, 2.0);
        menuDirector.constructIngrediant("croutton", "du pain sec c'est un epice", TypeIngredient.EPICE, 3.0);
        menuDirector.constructIngrediant("eau", "verre d'eau comme produit laittier", TypeIngredient.LAITIER, 0.3);
        menu.ajoute(menuDirector.getResult());
        control.platSuivantMenu();
        control.platPrecedentMenu();

        Recette recette = new Recette();
        recette.ajouteIngredient(IngredientFactory.createIngredient("poulet", "c'est du poulet", TypeIngredient.VIANDE),10) ;
        recette.ajouteIngredient(IngredientFactory.createIngredient("tomate", "rouge et juteux", TypeIngredient.FRUIT),2.0);
        recette.ajouteIngredient(IngredientFactory.createIngredient("echalote", "petit anneaux vert", TypeIngredient.EPICE),3.0);
        recette.ajouteIngredient(IngredientFactory.createIngredient("lait", "verre de lait", TypeIngredient.LAITIER),0.3);
        assertEquals( new PlatAuMenu(1, "plat de test 1 (default)", 23.99,recette).toString(), control.platCourantMenu().toString());
    }
}