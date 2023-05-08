package tests.unitTests;

import ingredients.*;
import inventaire.Inventaire;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventaireTest {

    @Test
    void ingredientExist() {
        Ingredient ingTest = IngredientFactory.createIngredient("Viande1", "abcd1111", TypeIngredient.VIANDE);
        assertTrue(Inventaire.getInstance().ingredientExist(ingTest));
        ingTest.setNom("Viande2");
        assertFalse(Inventaire.getInstance().ingredientExist(ingTest));
    }

    @Test
    void hasIngredient() {
        Ingredient ingTest = IngredientFactory.createIngredient("Viande3", "abcd1111", TypeIngredient.VIANDE);
        assertFalse(Inventaire.getInstance().hasIngredient(ingTest));
    }

    @Test
    void addIngredient() {
        Ingredient ingTest = new Fruit();
        Inventaire.getInstance().addIngredient(ingTest);
        assertTrue(Inventaire.getInstance().ingredientExist(ingTest));
    }

    @Test
    void testAddIngredient() {
        Ingredient ingTest = IngredientFactory.createIngredient("Viande5", "abcd1111", TypeIngredient.VIANDE);
        Inventaire.getInstance().addIngredient(ingTest, -10);
        assertFalse(Inventaire.getInstance().hasIngredient(ingTest));
    }

    @Test
    void testAddIngredient1() {
    }

    @Test
    void getIngredient() {
        Ingredient ingTest = IngredientFactory.createIngredient("Saudice 12", "soooossig", TypeIngredient.VIANDE);
        Inventaire.getInstance().addIngredient(ingTest);
        assertEquals(Inventaire.getInstance().getIngredient("Saudice 12").getIngredient().getDescription(), "soooossig");

    }

    @Test
    void removeIngredient() {

        Ingredient ingTest = IngredientFactory.createIngredient("Saudice 12", "soooossig", TypeIngredient.VIANDE);
        Inventaire.getInstance().addIngredient(ingTest);
        assertEquals(Inventaire.getInstance().getIngredient("Saudice 12").getIngredient().getDescription(), "soooossig");

        assertEquals(Inventaire.getInstance().removeIngredient("Saudice 12").getIngredient().getDescription(), "soooossig");
        assertNull(Inventaire.getInstance().getIngredient("Saudice 12"));
    }
}