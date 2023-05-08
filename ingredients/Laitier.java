package ingredients;

import ingredients.quantite.Quantite;
import ingredients.quantite.QuantiteMass;
import ingredients.quantite.QuantiteVolume;

public class Laitier extends Ingredient{
    public Laitier() {
        setTypeIngredient(TypeIngredient.LAITIER);
    }
    @Override
    public Quantite getTypeQuantite(){
        return new QuantiteVolume();
    }
}