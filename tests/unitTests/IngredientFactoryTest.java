package tests.unitTests;

import ingredients.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientFactoryTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void createIngredient() {
        Ingredient ing;

        ing = new Viande();
        ing.setNom("Viande 1");
        ing.setDescription("viande 1 desc");
        assertEquals(
                ing.toString(),
                IngredientFactory.createIngredient("Viande 1", "viande 1 desc", TypeIngredient.VIANDE).toString()
                );

        ing = new Fruit();
        ing.setNom("Fruit 1");
        ing.setDescription("fruit 1 desc");
        assertEquals(
                ing.toString(),
                IngredientFactory.createIngredient("Fruit 1", "fruit 1 desc", TypeIngredient.FRUIT).toString()
        );

        ing = new Legume();
        ing.setNom("Legume 1");
        ing.setDescription("Legume 1 desc");
        assertEquals(
                ing.toString(),
                IngredientFactory.createIngredient("Legume 1", "Legume 1 desc", TypeIngredient.LEGUME).toString()
        );

        ing = new Laitier();
        ing.setNom("Lait 1");
        ing.setDescription("Lait 1 desc");
        assertEquals(
                ing.toString(),
                IngredientFactory.createIngredient("Lait 1", "Lait 1 desc", TypeIngredient.LAITIER).toString()
        );

        ing = new Epice();
        ing.setNom("Epice 1");
        ing.setDescription("Epice 1 desc");
        assertEquals(
                ing.toString(),
                IngredientFactory.createIngredient("Epice 1", "Epice 1 desc", TypeIngredient.EPICE).toString()
        );
    }
}