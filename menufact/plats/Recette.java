package menufact.plats;

import ingredients.Ingredient;
import ingredients.IngredientInventaire;
import inventaire.Inventaire;

import java.util.ArrayList;

public class Recette {
    private ArrayList<IngredientInventaire> ingredients;
    public Recette(){
        ingredients = new ArrayList<>();
    }
    public void ajouteIngredient(Ingredient ingredient, double qty){
        ingredients.add(new IngredientInventaire(ingredient, qty));
    }
    public boolean verifierIngredientDispo(){
        for(IngredientInventaire i : ingredients){
            if( ! Inventaire.getInstance().hasIngredient(i.getIngredient())){
                return false;
            }
        }
        return true;
    }
}
