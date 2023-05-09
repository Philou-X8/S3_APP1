package menufact.plats.etats;

import menufact.Chef;

public class EtatPlatCommande implements EtatPlat
{
    private Chef contexte;

    public EtatPlatCommande(Chef boss)
    {
        contexte =boss;
    }
    @Override
    public void recevoirCommande()
    {
        contexte.changerEtat(new EtatPlatPreparation(contexte));
    }

    @Override
    public void cuisiner()
    {

    }

    @Override
    public void servir()
    {

    }

    @Override
    public void setContext(Chef boss)
    {
        contexte = boss;
    }

    @Override
    public EtatPlat getState()
    {
        return this;
    }

    @Override
    public String toString() {
        return "Chef -> EtatPlatCommander";
    }
}
