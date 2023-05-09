package menufact.facture;

import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;

public interface EtatFacture
{
    public boolean isState(EtatFacture state);
    public void ajoutePlat(PlatChoisi p) throws FactureException;
    public void ouvrir() throws FactureException;
    public void payer() throws FactureException;
    public void fermer() throws FactureException;
    public String toString();

}
