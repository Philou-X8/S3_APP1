package menufact.platsBuilder;

import ingredients.Ingredient;
import menufact.plats.PlatAuMenu;
import menufact.platsBuilder.PlatBuilder;

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
    public void constructSante(double k, double c, double g){

    }
    public void constructEnfant(double p){

    }
    public void constructIngrediant(String nom, String descrip, Ingredient ingredients, double qty){
        //TODO
    }
    abstract PlatAuMenu getPlat();

}
