package menufact;

import menufact.plats.etats.EtatPlat;
import menufact.plats.etats.EtatPlatCommande;
import menufact.plats.PlatChoisi;

public class Chef
{
    private EtatPlat etatPlat;
    private PlatChoisi platActuel;

    public Chef()
    {
        ///to do : verifier ingredient
        etatPlat = new EtatPlatCommande(this);
    }
    public void cusiner()
    {
        etatPlat.cuisiner();
    }
    public void changerEtat(EtatPlat state)
    {
        etatPlat = state;
    }
    public void recevoirCommande(PlatChoisi choix)
    {
        platActuel = choix;
    }
    private boolean verifierIngrediant(PlatChoisi verif)
    {
        return false;
    }

}
