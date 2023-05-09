package ingredients.quantite;

public class QuantiteMass implements Quantite {
    private double quantite;
    public QuantiteMass(){
        quantite = 0;
    }
    public double getQuantite(){
        return quantite;
    }
    public void setQuantite(double qty){
        quantite = qty;
    }
    @Override
    public String toString(){
        return String.valueOf(quantite) + " kg";
    }
}
