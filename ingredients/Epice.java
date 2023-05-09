package ingredients;

import ingredients.quantite.Quantite;
import ingredients.quantite.QuantiteMass;

public class Epice extends Ingredient{
    public Epice() {
        setTypeIngredient(TypeIngredient.EPICE);
    }
    @Override
    public Quantite getTypeQuantite(){
        return new QuantiteMass();
    }
}