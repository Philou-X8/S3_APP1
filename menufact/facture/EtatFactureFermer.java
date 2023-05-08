package menufact.facture;

import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;

public class EtatFactureFermer implements EtatFacture
{
    private Facture bill;
    public EtatFactureFermer(Facture montant)
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
        throw new FactureException("La facture à l'état Fermer ne permet pas d'ajouter un plat ");
    }

    @Override
    public void ouvrir() throws FactureException
    {
        bill.setEtat(new EtatFactureOuverte(bill));
    }

    @Override
    public void payer() throws FactureException
    {
        bill.setEtat(new EtatFacturePayer(bill));
    }

    @Override
    public void fermer() throws FactureException
    {
        throw new FactureException("La facture à l'état Fermer ne peux pas être fermer à nouveau ");
    }
}
