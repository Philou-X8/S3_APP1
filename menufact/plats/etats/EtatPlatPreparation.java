package menufact.plats.etats;

import menufact.Chef;

public class EtatPlatPreparation implements EtatPlat
{
    private Chef contexte;

    public EtatPlatPreparation(Chef boss)
    {
        contexte = boss;
    }
    @Override
    public void recevoirCommande() {

    }

    @Override
    public void cuisiner()
    {
        contexte.changerEtat(new EtatPlatTermine(contexte));
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
}
