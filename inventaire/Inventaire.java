package inventaire;

import ingredients.Ingredient;
import ingredients.IngredientInventaire;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventaire {
    private static Inventaire instance;
    private HashMap<String, IngredientInventaire> entrepot;
    private Inventaire(){
        entrepot = new HashMap<>();
    }
    public static Inventaire getInstance(){
        if (instance == null){
            instance = new Inventaire();
        }
        return instance;
    }
    public boolean ingredientExist(Ingredient ingredient){
        return entrepot.containsKey(ingredient.getNom());
    }
    public boolean hasIngredient(Ingredient ingredient){
        if(this.ingredientExist(ingredient)){
            return entrepot.get(ingredient.getNom()).getQuantite() > 0.0;
        }
        else return false;
    }
    public void addIngredient(Ingredient ingredient, double addQty){
        double qty;
        if(this.hasIngredient(ingredient)){
            qty = addQty + entrepot.get(ingredient.getNom()).getQuantite();
        } else {
            qty = addQty;
        }
        entrepot.put(ingredient.getNom(), new IngredientInventaire(ingredient, qty));
    }
    public void addIngredient(Ingredient ingredient){
        addIngredient(ingredient, 1.0);
    }
    public void addIngredient(IngredientInventaire ingredient){
        addIngredient(ingredient.getIngredient(), ingredient.getQuantite());
    }
    public IngredientInventaire getIngredient(String nom){
        return entrepot.get(nom);
    }
    public IngredientInventaire removeIngredient(String nom){
        return entrepot.remove(nom);
    }

}
