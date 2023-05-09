package menufact.facture;

import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;

public class EtatFacturePayer implements EtatFacture
{
    private Facture bill;

    public EtatFacturePayer(Facture montant)
    {
        bill =montant;
    }
    @Override
    public boolean isState(EtatFacture state) {
        if (state == this)
        {
            return true;
        }
        return false;
    }

    @Override
    public void ajoutePlat(PlatChoisi p) throws FactureException
    {
        throw new FactureException("La facture à l'état payer ne peut pas ajouter des plat.");
    }

    @Override
    public void ouvrir() throws FactureException
    {
        throw new FactureException("Une facture payé ne peut pas être reouverte.");
    }

    @Override
    public void payer() throws FactureException {
        throw new FactureException("La facture à l'état payer ne peux pas être payé à nouveau ");
    }

    @Override
    public void fermer() throws FactureException
    {
        throw new FactureException("La facture à l'état payer ne peux pas être fermer ");
    }
    @Override
    public String toString() {
        return "EtatFacturePayer";
    }
}
