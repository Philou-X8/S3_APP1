package tests.unitTests;

import ingredients.IngredientFactory;
import ingredients.TypeIngredient;
import menufact.Chef;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.plats.Recette;
import menufact.plats.etats.EtatPlatCommande;
import menufact.plats.etats.EtatPlatPreparation;
import menufact.plats.etats.EtatPlatTermine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChefTest {

    @Test
    void cusiner()
    {
        Chef chef = new Chef();
        chef.changerEtat(new EtatPlatPreparation(chef));
        assertEquals(new EtatPlatPreparation(chef).toString(),chef.getEtatPlat().toString());
    }

    @Test
    void changerEtat()
    {
        Chef chef = new Chef();
        chef.changerEtat(new EtatPlatTermine(chef));
        assertEquals(new EtatPlatTermine(chef).toString(),chef.getEtatPlat().toString());
    }

    @Test
    void recevoirCommande()
    {
        Chef chef = new Chef();
        Recette recette = new Recette();
        recette.ajouteIngredient(IngredientFactory.createIngredient("poulet", "c'est du poulet", TypeIngredient.VIANDE),10) ;
        recette.ajouteIngredient(IngredientFactory.createIngredient("tomate", "rouge et juteux", TypeIngredient.FRUIT),2.0);
        recette.ajouteIngredient(IngredientFactory.createIngredient("echalote", "petit anneaux vert", TypeIngredient.EPICE),3.0);
        recette.ajouteIngredient(IngredientFactory.createIngredient("lait", "verre de lait", TypeIngredient.LAITIER),0.3);
        PlatAuMenu platAuMenu = new PlatAuMenu(1,"Plat",12,recette);
        PlatChoisi platChoisi = new PlatChoisi(platAuMenu,1);
        chef.recevoirCommande(platChoisi);

        assertEquals(platChoisi.toString(),chef.getPlatActuel().toString());
    }

    @Test
    void testToString() {
    }
}