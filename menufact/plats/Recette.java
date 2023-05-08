package menufact.plats;

import ingredients.Ingredient;
import ingredients.IngredientInventaire;

import java.util.ArrayList;

public class Recette {
    private ArrayList<IngredientInventaire> ingredients;
    public Recette(){
        ingredients = new ArrayList<>();
    }
    public void ajouteIngredient(Ingredient ingredient, double qty){
        //TODO: check if ingredient is already in Inventaire
        ingredients.add(new IngredientInventaire(ingredient, qty));
    }
}
