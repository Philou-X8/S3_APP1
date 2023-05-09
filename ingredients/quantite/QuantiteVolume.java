package ingredients.quantite;

public class QuantiteVolume  implements Quantite {
    private double quantite;
    public QuantiteVolume(){
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
        return String.valueOf(quantite) + " L";
    }
}
