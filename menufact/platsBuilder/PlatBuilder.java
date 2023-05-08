package menufact.platsBuilder;

import ingredients.Ingredient;
import menufact.plats.PlatAuMenu;
import menufact.plats.Recette;

public abstract class PlatBuilder {
    protected int code;
    protected String description;
    protected double prix;
    protected Recette ingredients;
    public PlatBuilder(){
        code = 0;
        description = "No description";
        prix = 0.0;
        ingredients = new Recette();
    }
    public PlatBuilder(int code, String descrip, double prix){
        constructInformation(code, descrip, prix);
    }
    public void constructInformation(int code, String descrip, double prix){
        this.code = code;
        this.description = descrip;
        this.prix = prix;
    }
    public void constructIngredient(Ingredient ingredient, double qty){
        ingredients.ajouteIngredient(ingredient, qty);
    }
    public void constructSante(double k, double c, double g){

    }
    public void constructEnfant(double p){

    }
    abstract PlatAuMenu getPlat();

}
