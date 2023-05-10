package tests.unitTests;

import ingredients.Ingredient;
import ingredients.TypeIngredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ingredients.TypeIngredient.VIANDE;
import static org.junit.jupiter.api.Assertions.*;

class IngredientTest {
    Ingredient ingredient;
    @BeforeEach
    void setUp() {

        ingredient = new Ingredient();
        ingredient.setNom("Test");
        ingredient.setNom("Pomme");
        ingredient.setTypeIngredient(TypeIngredient.VIANDE);

    }

    @Test
    void getNom() {
        assertEquals("Test",ingredient.getNom());
    }

    @Test
    void setNom() {
        ingredient.setNom("New Nom");
        assertEquals("New Nom",ingredient.getNom());
    }

    @Test
    void getDescription() {
        assertEquals("Pomme",ingredient.getDescription());
    }

    @Test
    void setDescription() {
        ingredient.setNom("NewDescription");
        assertEquals("NewDescription",ingredient.getDescription());
    }

    @Test
    void getTypeIngredient()
    {
        assertEquals(TypeIngredient.VIANDE,ingredient.getTypeIngredient());
    }

    @Test
    void setTypeIngredient() {
        ingredient.setTypeIngredient(TypeIngredient.LEGUME);
        assertEquals(TypeIngredient.LEGUME,ingredient.getTypeIngredient());
    }

    @Test
    void getTypeQuantite()
    {
        assertEquals("0.0 kg",ingredient.getTypeQuantite().toString());
    }


}