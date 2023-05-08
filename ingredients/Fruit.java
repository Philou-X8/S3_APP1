package ingredients;

import ingredients.quantite.Quantite;
import ingredients.quantite.QuantiteMass;

public class Fruit extends Ingredient{
    public Fruit() {
        setTypeIngredient(TypeIngredient.FRUIT);
    }
    @Override
    public Quantite getTypeQuantite(){
        return new QuantiteMass();
    }

}
