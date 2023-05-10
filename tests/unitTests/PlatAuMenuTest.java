package tests.unitTests;

import ingredients.IngredientFactory;
import ingredients.TypeIngredient;
import menufact.plats.PlatAuMenu;
import menufact.plats.Recette;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlatAuMenuTest {
    Recette recette;
    PlatAuMenu platAuMenu;
    @BeforeEach
    void setUp() {
        recette = new Recette();
        recette.ajouteIngredient(IngredientFactory.createIngredient("poulet", "c'est du poulet", TypeIngredient.VIANDE),10) ;
        recette.ajouteIngredient(IngredientFactory.createIngredient("tomate", "rouge et juteux", TypeIngredient.FRUIT),2.0);
        recette.ajouteIngredient(IngredientFactory.createIngredient("echalote", "petit anneaux vert", TypeIngredient.EPICE),3.0);
        recette.ajouteIngredient(IngredientFactory.createIngredient("lait", "verre de lait", TypeIngredient.LAITIER),0.3);
        platAuMenu = new PlatAuMenu(1,"Plat",12,recette);
    }

    @Test
    void getCode() {
        assertEquals(1,platAuMenu.getCode());
    }

    @Test
    void setCode() {
        platAuMenu.setCode(5);
        assertEquals(5,platAuMenu.getCode());
    }

    @Test
    void getDescription()
    {
        assertEquals("Plat",platAuMenu.getDescription());
    }

    @Test
    void setDescription()
    {
        platAuMenu.setDescription("setDescription");
        assertEquals("setDescription",platAuMenu.getDescription());
    }

    @Test
    void getPrix() {
        assertEquals(12,platAuMenu.getPrix());
    }

    @Test
    void setPrix()
    {
        platAuMenu.setPrix(50);
        assertEquals(50,platAuMenu.getPrix());
    }
}