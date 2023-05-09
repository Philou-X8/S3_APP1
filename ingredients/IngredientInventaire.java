package ingredients;

import ingredients.exceptions.IngredientException;
import ingredients.quantite.Quantite;

public class IngredientInventaire {

    private Ingredient ingredient;
    private Quantite quantite;

    public IngredientInventaire(Ingredient ingredient, double quantite) {
        this.ingredient = ingredient;
        this.quantite = ingredient.getTypeQuantite();
        this.quantite.setQuantite(quantite);
    }
    public Ingredient getIngredient() {
        return ingredient;
    }
    public double getQuantite() {
        return quantite.getQuantite();
    }
    public void setQuantite(int quantite) throws IngredientException{

        if (quantite < 0)
            throw new IngredientException("Il n'est pas possible d'avoir une quantité negative");
        else
            this.quantite.setQuantite(quantite);
    }

    @Override
    public String toString(){
        return ingredient + ", " + quantite;
    }
}
