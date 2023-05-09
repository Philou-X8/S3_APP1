package tests;

import ingredients.TypeIngredient;
import menufact.Chef;
import menufact.Client;
import menufact.Controller;
import menufact.Menu;
import menufact.facture.Facture;
import menufact.facture.exceptions.FactureException;
import menufact.platsBuilder.MenuDirector;
import menufact.platsBuilder.PlatBuilderDefault;
import menufact.platsBuilder.PlatBuilderEnfant;
import menufact.platsBuilder.PlatBuilderSante;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SenarioTest {

    private Facture facture;
    private Menu menu;
    private Client client;
    private Chef chef;
    private MenuDirector menuDirector;
    private Controller controller;
    @BeforeEach
    void setUp() {
        client = new Client(123, "Mr. Client test", "123 456 789");
        chef = new Chef();
        facture = new Facture("Facture de test");
        menu = new Menu("Menu de test");
        controller = new Controller(facture, menu);

        //peupler menu
        menuDirector = new MenuDirector(new PlatBuilderDefault());
        menuDirector.constructInformation(1, "plat de test 1 (default)", 23.99);
        menuDirector.constructIngrediant("poulet", "c'est du poulet", TypeIngredient.VIANDE, 10.0);
        menuDirector.constructIngrediant("tomate", "rouge et juteux", TypeIngredient.FRUIT, 2.0);
        menuDirector.constructIngrediant("echalote", "petit anneaux vert", TypeIngredient.EPICE, 3.0);
        menuDirector.constructIngrediant("lait", "verre de lait", TypeIngredient.LAITIER, 0.3);
        menu.ajoute(menuDirector.getResult());
        assertEquals(
                "menufact.plats.PlatAuMenu{code=1, description='plat de test 1 (default)', prix=23.99, recette=Recette : [Type VIANDE: poulet (c'est du poulet), 10.0 kg, Type FRUIT: tomate (rouge et juteux), 2.0 kg, Type EPICE: echalote (petit anneaux vert), 3.0 kg, Type LAITIER: lait (verre de lait), 0.3 L]}\n",
                menuDirector.getResult().toString()
        );

        menuDirector.reset(new PlatBuilderSante());
        menuDirector.constructInformation(2, "plat de test 2 (sante)", 15.99);
        menuDirector.constructSante(500, 600, 700);
        menuDirector.constructIngrediant("salad", "cruchy et vert", TypeIngredient.LEGUME, 10.0);
        menuDirector.constructIngrediant("tomate", "rouge et juteux", TypeIngredient.FRUIT, 2.0);
        menuDirector.constructIngrediant("croutton", "du pain sec c'est un epice", TypeIngredient.EPICE, 3.0);
        menuDirector.constructIngrediant("eau", "verre d'eau comme produit laittier", TypeIngredient.LAITIER, 0.3);
        menu.ajoute(menuDirector.getResult());
        assertEquals(
                "menufact.plats.PlatSante{kcal=500.0, chol=600.0, gras=700.0} menufact.plats.PlatAuMenu{code=2, description='plat de test 2 (sante)', prix=15.99, recette=Recette : [Type LEGUME: salad (cruchy et vert), 10.0 kg, Type FRUIT: tomate (rouge et juteux), 2.0 kg, Type EPICE: croutton (du pain sec c'est un epice), 3.0 kg, Type LAITIER: eau (verre d'eau comme produit laittier), 0.3 L]}\n",
                menuDirector.getResult().toString()
        );

        menuDirector.reset(new PlatBuilderEnfant());
        menuDirector.constructInformation(3, "plat de test 3 (enfant)", 16.99);
        menuDirector.constructEnfant(0.8);
        menuDirector.constructIngrediant("croquette", "miam", TypeIngredient.VIANDE, 10.0);
        menuDirector.constructIngrediant("ketchup", "sauce de type ketchup", TypeIngredient.FRUIT, 2.0);
        menuDirector.constructIngrediant("lait", "verre de lait", TypeIngredient.LAITIER, 0.3);
        menu.ajoute(menuDirector.getResult());
        assertEquals(
                "PlatEnfant{proportion=0.8} menufact.plats.PlatAuMenu{code=3, description='plat de test 3 (enfant)', prix=16.99, recette=Recette : [Type VIANDE: croquette (miam), 10.0 kg, Type FRUIT: ketchup (sauce de type ketchup), 2.0 kg, Type LAITIER: lait (verre de lait), 0.3 L]}\n",
                menuDirector.getResult().toString()
        );

        //System.out.println(menu.toString());
        try {
            facture.payer();
        }catch (FactureException e){
            System.out.println(e.toString());
        }

    }

    @Test
    void remplirMenu(){

    }
    @Test
    void ouvrirFacture() {
        try {
            facture.ouvrir();
        }catch (FactureException e){
            System.out.println(e.toString());
        }
    }

    @Test
    void choisirPlat() {
        try{
            controller.choisirPlat();
            controller.platSuivantMenu();
            controller.platSuivantMenu();
            controller.choisirPlat();
            controller.choisirPlat();
        }catch (FactureException e){
            System.out.println(e.toString());
        }
    }
    @Test
    void fermerFacture() {
        try {
            facture.fermer();
        }catch (FactureException e){
            System.out.println(e.toString());
        }
    }

    @Test
    void payerFacture() {
        try {
            facture.payer();
        }catch (FactureException e){
            System.out.println(e.toString());
        }
    }


    @Test
    void platCourantMenu() {
    }

    @Test
    void platSuivantMenu() {
    }

    @Test
    void platPrecedentMenu() {
    }
}