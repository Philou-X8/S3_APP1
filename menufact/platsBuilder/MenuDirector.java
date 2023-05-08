package menufact.platsBuilder;

import ingredients.Ingredient;
import menufact.platsBuilder.PlatBuilder;

public class MenuDirector {
    private PlatBuilder builder;

    public MenuDirector(PlatBuilder platBuilder){
        builder = platBuilder;

    }
    public void reset(PlatBuilder platBuilder){
        builder = platBuilder;
    }

    public void constructInformation(int id, String descrip, double prix){

    }

    public void constructIngrediant(String nom, String descrip, Ingredient ingredient, int qty){

    }
    public void constructEnfant(double propotion){

    }
    public void constructSante(double kcal, double chol, double gras){

    }
    public void getResult(){
        return ;
    }

//+getResult() : PlatAuMenu

}
