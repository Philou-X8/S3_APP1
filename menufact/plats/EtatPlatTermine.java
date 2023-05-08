package menufact.plats;

import menufact.Chef;

public class EtatPlatTermine implements EtatPlat
{
    private Chef contexte;
    public EtatPlatTermine(Chef boss)
    {
        contexte = boss;
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
    public void servir()
    {
        contexte.changerEtat(new EtatPlatServi(contexte));
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
}
