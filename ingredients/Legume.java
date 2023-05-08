package ingredients;

import ingredients.quantite.Quantite;
import ingredients.quantite.QuantiteMass;

public class Legume extends Ingredient{
    public Legume() {
        setTypeIngredient(TypeIngredient.LEGUME);
    }
    @Override
    public Quantite getTypeQuantite(){
        return new QuantiteMass();
    }
}
