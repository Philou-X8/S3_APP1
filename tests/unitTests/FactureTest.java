package tests.unitTests;

import ingredients.IngredientFactory;
import ingredients.TypeIngredient;
import menufact.Chef;
import menufact.Client;
import menufact.facture.EtatFactureFermer;
import menufact.facture.EtatFactureOuverte;
import menufact.facture.EtatFacturePayer;
import menufact.facture.Facture;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.plats.Recette;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactureTest {

    @Test
    void associerClient()
    {
        Client client = new Client(0,"BOB","1234");
        Facture bill = new Facture("Facture de BOB");
        bill.associerClient(client);
        assertEquals(new Client(0,"BOB","1234").toString(), bill.getClient().toString());
    }

    @Test
    void associerChef()
    {
        Chef chef = new Chef();
        Facture bill = new Facture("Facture de BOB");
        bill.associerChef(chef);

        assertEquals(new Chef().toString(), bill.getChef().toString());
    }

    @Test
    void sousTotal()
    {
        Facture bill = new Facture("Facture de BOB");
        Recette recette = new Recette();
        recette.ajouteIngredient(IngredientFactory.createIngredient("poulet", "c'est du poulet", TypeIngredient.VIANDE),10) ;
        recette.ajouteIngredient(IngredientFactory.createIngredient("tomate", "rouge et juteux", TypeIngredient.FRUIT),2.0);
        recette.ajouteIngredient(IngredientFactory.createIngredient("echalote", "petit anneaux vert", TypeIngredient.EPICE),3.0);
        recette.ajouteIngredient(IngredientFactory.createIngredient("lait", "verre de lait", TypeIngredient.LAITIER),0.3);
        PlatAuMenu platAuMenu = new PlatAuMenu(1,"Plat",12,recette);
        PlatChoisi platChoisi = new PlatChoisi(platAuMenu,1);
        bill.addPlat(platChoisi);

        assertEquals(12, bill.sousTotal());

    }

    @Test
    void total()
    {
        Facture bill = new Facture("Facture de BOB");
        Recette recette = new Recette();
        recette.ajouteIngredient(IngredientFactory.createIngredient("poulet", "c'est du poulet", TypeIngredient.VIANDE),10) ;
        recette.ajouteIngredient(IngredientFactory.createIngredient("tomate", "rouge et juteux", TypeIngredient.FRUIT),2.0);
        recette.ajouteIngredient(IngredientFactory.createIngredient("echalote", "petit anneaux vert", TypeIngredient.EPICE),3.0);
        recette.ajouteIngredient(IngredientFactory.createIngredient("lait", "verre de lait", TypeIngredient.LAITIER),0.3);
        PlatAuMenu platAuMenu = new PlatAuMenu(1,"Plat",12,recette);
        PlatChoisi platChoisi = new PlatChoisi(platAuMenu,1);
        bill.addPlat(platChoisi);
        assertEquals(13.797, bill.total());
    }

    @Test
    void setEtat()
    {
        Facture bill = new Facture("Facture de BOB");
        bill.setEtat(new EtatFactureFermer(bill));
        assertEquals("EtatFactureFermer",bill.getEtat().toString());
    }

    @Test
    void payer()
    {
        Facture bill = new Facture("Facture de BOB");
        bill.setEtat(new EtatFacturePayer(bill));
        assertEquals("EtatFacturePayer",bill.getEtat().toString());
    }

    @Test
    void fermer()
    {
        Facture bill = new Facture("Facture de BOB");
        bill.setEtat(new EtatFactureFermer(bill));
        assertEquals("EtatFactureFermer",bill.getEtat().toString());
    }

    @Test
    void ouvrir()
    {
        Facture bill = new Facture("Facture de BOB");
        bill.setEtat(new EtatFactureFermer(bill));
        bill.setEtat(new EtatFactureOuverte(bill));
        assertEquals("EtatFactureOuvert",bill.getEtat().toString());
    }

    @Test
    void getEtat()
    {
        Facture bill = new Facture("Facture de BOB");
        bill.setEtat(new EtatFactureFermer(bill));
        bill.setEtat(new EtatFactureOuverte(bill));
        bill.setEtat(new EtatFacturePayer(bill));
        assertEquals("EtatFacturePayer",bill.getEtat().toString());
    }

    @Test
    void addPlat()
    {
        Facture bill = new Facture("Facture de BOB");
        Recette recette = new Recette();
        recette.ajouteIngredient(IngredientFactory.createIngredient("poulet", "c'est du poulet", TypeIngredient.VIANDE),10) ;
        recette.ajouteIngredient(IngredientFactory.createIngredient("tomate", "rouge et juteux", TypeIngredient.FRUIT),2.0);
        recette.ajouteIngredient(IngredientFactory.createIngredient("echalote", "petit anneaux vert", TypeIngredient.EPICE),3.0);
        recette.ajouteIngredient(IngredientFactory.createIngredient("lait", "verre de lait", TypeIngredient.LAITIER),0.3);
        PlatAuMenu platAuMenu = new PlatAuMenu(1,"Plat",12,recette);
        PlatChoisi platChoisi = new PlatChoisi(platAuMenu,1);
        bill.addPlat(platChoisi);
        assertEquals("[menufact.plats.PlatChoisi{quantite=1, plat=menufact.plats.PlatAuMenu{code=1, description='Plat', prix=12.0, recette=Recette : [Type VIANDE: poulet (c'est du poulet), 10.0 kg, Type FRUIT: tomate (rouge et juteux), 2.0 kg, Type EPICE: echalote (petit anneaux vert), 3.0 kg, Type LAITIER: lait (verre de lait), 0.3 L]}\n" +
                "}]",bill.getAllPlatchoisit().toString());
    }


    @Test
    void genererFacture()
    {
        Client client = new Client(0,"BOB","1234");
        Facture bill = new Facture("Facture de BOB");
        Recette recette = new Recette();
        bill.associerClient(client);
        recette.ajouteIngredient(IngredientFactory.createIngredient("poulet", "c'est du poulet", TypeIngredient.VIANDE),10) ;
        recette.ajouteIngredient(IngredientFactory.createIngredient("tomate", "rouge et juteux", TypeIngredient.FRUIT),2.0);
        recette.ajouteIngredient(IngredientFactory.createIngredient("echalote", "petit anneaux vert", TypeIngredient.EPICE),3.0);
        recette.ajouteIngredient(IngredientFactory.createIngredient("lait", "verre de lait", TypeIngredient.LAITIER),0.3);
        PlatAuMenu platAuMenu = new PlatAuMenu(1,"Plat",12,recette);
        PlatChoisi platChoisi = new PlatChoisi(platAuMenu,1);
        bill.addPlat(platChoisi);
        String pp= bill.genererFacture().toString();

       /* assertEquals("Facture generee.\n" +
                "Date:Tue May 09 12:46:02 EDT 2023\n" +
                "Description: Facture de BOB\n" +
                "Client:BOB\n" +
                "Les plats commandes:\n" +
                "Seq   Plat         Prix   Quantite\n" +
                "1     Plat  12.0      1\n" +
                "          TPS:               0.6000000000000001\n" +
                "          TVQ:               1.197\n" +
                "          Le total est de:   13.797",pp.toString());*/
    }

}