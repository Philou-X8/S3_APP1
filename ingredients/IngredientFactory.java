package ingredients;

public class IngredientFactory {
    public IngredientFactory(){

    }
    public static Ingredient createIngredient(String nom, String description, TypeIngredient type){
        Ingredient ingredient;
        switch (type){
            case FRUIT -> {
                ingredient = new Fruit();
            }
            case LEGUME -> {
                ingredient = new Legume();
            }
            case VIANDE -> {
                ingredient = new Viande();
            }
            case LAITIER -> {
                ingredient = new Laitier();
            }
            case EPICE -> {
                ingredient = new Epice();
            }
            default -> ingredient = new Ingredient();
        }
        ingredient.setNom(nom);
        ingredient.setDescription(description);
        return ingredient;
    }
}
