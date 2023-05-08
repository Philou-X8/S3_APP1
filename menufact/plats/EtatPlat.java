package menufact.plats;
import menufact.Chef;

public interface EtatPlat
{
    void recevoirCommande();
    void cuisiner();
    void servir();
    void setContext(Chef boss);
    EtatPlat getState();
    public String toString();
}
