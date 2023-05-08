package menufact.plats;

import menufact.Chef;

public class EtatPlatImpossible implements EtatPlat
{
    private Chef contexte;

    public EtatPlatImpossible()
    {

    }
    @Override
    public void recevoirCommande()
    {

    }

    @Override
    public void cuisiner()
    {

    }

    @Override
    public void servir() {

    }

    @Override
    public void setContext(Chef boss) {
        contexte = boss;

    }

    @Override
    public EtatPlat getState() {
        return this;
    }
}
