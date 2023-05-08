package ingredients;

import ingredients.quantite.Quantite;
import ingredients.quantite.QuantiteMass;
import ingredients.quantite.QuantiteVolume;

public class Ingredient {
    private String nom;
    private String description;
    private TypeIngredient typeIngredient;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypeIngredient getTypeIngredient() {
        return typeIngredient;
    }

    public void setTypeIngredient(TypeIngredient typeIngredient) {
        this.typeIngredient = typeIngredient;
    }

    public Quantite getTypeQuantite(){
        return new QuantiteMass();
    }
}
