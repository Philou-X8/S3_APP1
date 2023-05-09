package tests.unitTests;

import ingredients.IngredientFactory;
import ingredients.TypeIngredient;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.plats.Recette;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlatChoisiTest {

    @Test
    void testToString() {
    }

    @Test
    void getQuantite()
    {
        Recette recette = new Recette();
        recette.ajouteIngredient(IngredientFactory.createIngredient("poulet", "c'est du poulet", TypeIngredient.VIANDE),10) ;
        recette.ajouteIngredient(IngredientFactory.createIngredient("tomate", "rouge et juteux", TypeIngredient.FRUIT),2.0);
        recette.ajouteIngredient(IngredientFactory.createIngredient("echalote", "petit anneaux vert", TypeIngredient.EPICE),3.0);
        recette.ajouteIngredient(IngredientFactory.createIngredient("lait", "verre de lait", TypeIngredient.LAITIER),0.3);
        PlatAuMenu platAuMenu = new PlatAuMenu(1,"Plat",12,recette);
        PlatChoisi platChoisi = new PlatChoisi(platAuMenu,1);

        assertEquals(1,platChoisi.getQuantite());
    }

    @Test
    void setQuantite()
    {
        Recette recette = new Recette();
        recette.ajouteIngredient(IngredientFactory.createIngredient("poulet", "c'est du poulet", TypeIngredient.VIANDE),10) ;
        recette.ajouteIngredient(IngredientFactory.createIngredient("tomate", "rouge et juteux", TypeIngredient.FRUIT),2.0);
        recette.ajouteIngredient(IngredientFactory.createIngredient("echalote", "petit anneaux vert", TypeIngredient.EPICE),3.0);
        recette.ajouteIngredient(IngredientFactory.createIngredient("lait", "verre de lait", TypeIngredient.LAITIER),0.3);
        PlatAuMenu platAuMenu = new PlatAuMenu(1,"Plat",12,recette);
        PlatChoisi platChoisi = new PlatChoisi(platAuMenu,1);
        platChoisi.setQuantite(12);
        assertEquals(12,platChoisi.getQuantite());
    }

    @Test
    void getPlat()
    {
        Recette recette = new Recette();
        recette.ajouteIngredient(IngredientFactory.createIngredient("poulet", "c'est du poulet", TypeIngredient.VIANDE),10) ;
        recette.ajouteIngredient(IngredientFactory.createIngredient("tomate", "rouge et juteux", TypeIngredient.FRUIT),2.0);
        recette.ajouteIngredient(IngredientFactory.createIngredient("echalote", "petit anneaux vert", TypeIngredient.EPICE),3.0);
        recette.ajouteIngredient(IngredientFactory.createIngredient("lait", "verre de lait", TypeIngredient.LAITIER),0.3);
        PlatAuMenu platAuMenu = new PlatAuMenu(1,"Plat",12,recette);
        PlatChoisi platChoisi = new PlatChoisi(platAuMenu,1);
        String jj = platChoisi.getPlat().toString();

        assertEquals("menufact.plats.PlatAuMenu{code=1, description='Plat', prix=12.0, recette=Recette : [Type VIANDE: poulet (c'est du poulet), 10.0 kg, Type FRUIT: tomate (rouge et juteux), 2.0 kg, Type EPICE: echalote (petit anneaux vert), 3.0 kg, Type LAITIER: lait (verre de lait), 0.3 L]}\n"
                ,platChoisi.getPlat().toString());
    }

}