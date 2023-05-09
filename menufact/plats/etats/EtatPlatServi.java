package menufact.plats.etats;

import menufact.Chef;

public class EtatPlatServi implements EtatPlat
{
    private Chef contexte;

    public EtatPlatServi(Chef boss)
    {
        contexte = boss;
    }
    @Override
    public void recevoirCommande() {

    }

    @Override
    public void cuisiner() {

    }

    @Override
    public void servir() {

    }

    @Override
    public void setContext(Chef boss)
    {
        contexte = boss;
    }

    @Override
    public EtatPlat getState() {
        return this;
    }
    @Override
    public String toString() {
        return "Chef -> EtatPlatServi";
    }
}
