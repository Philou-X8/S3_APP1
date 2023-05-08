package menufact.platsBuilder;

import ingredients.Ingredient;
import ingredients.IngredientFactory;
import ingredients.TypeIngredient;
import menufact.plats.PlatAuMenu;

public class MenuDirector {
    private PlatBuilder builder;

    public MenuDirector(PlatBuilder platBuilder){
        builder = platBuilder;

    }
    public void reset(PlatBuilder platBuilder){
        builder = platBuilder;
    }

    public void constructInformation(int id, String descrip, double prix){
        builder.constructInformation(id, descrip, prix);
    }

    public void constructIngrediant(String nom, String description, TypeIngredient type, double qty){
        builder.constructIngredient(IngredientFactory.createIngredient(nom, description, type), qty);
    }
    public void constructEnfant(double propotion){
        builder.constructEnfant(propotion);
    }
    public void constructSante(double kcal, double chol, double gras){
        builder.constructSante(kcal, chol, gras);
    }
    public PlatAuMenu getResult(){
        return builder.getPlat();
    }

//+getResult() : PlatAuMenu

}
