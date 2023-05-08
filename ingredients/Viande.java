package ingredients;

import ingredients.quantite.Quantite;
import ingredients.quantite.QuantiteMass;

public class Viande extends Ingredient{
    public Viande() {
        setTypeIngredient(TypeIngredient.VIANDE);
    }
    @Override
    public Quantite getTypeQuantite(){
        return new QuantiteMass();
    }
}
