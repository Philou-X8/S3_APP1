package menufact.facture;

import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;

public class EtatFactureOuverte implements EtatFacture
{
    private Facture bill;

    public  EtatFactureOuverte(Facture montant)
    {
        bill = montant;
    }
    @Override
    public boolean isState(EtatFacture state)
    {
        if (state == this)
        {
            return true;
        }
        return false;
    }

    @Override
    public void ajoutePlat(PlatChoisi p) throws FactureException
    {
        bill.addPlat(p);
    }

    @Override
    public void ouvrir() throws FactureException
    {
        throw new FactureException("La facture à l'état ouverte ne peut pas être reouverte.");
    }

    @Override
    public void payer() throws FactureException
    {
        bill.setEtat(new EtatFacturePayer(bill));
    }

    @Override
    public void fermer() throws FactureException
    {
        bill.setEtat(new EtatFactureFermer(bill));
    }
    @Override
    public String toString() {
        return "EtatFactureOuvert";
    }
}
