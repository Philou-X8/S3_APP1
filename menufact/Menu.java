package menufact;

import menufact.exceptions.MenuException;
import menufact.plats.PlatAuMenu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

public class Menu implements Iterator<String> {
    private String description;
    private int courant;
    private ArrayList<PlatAuMenu> plat = new ArrayList<PlatAuMenu>();

    public Menu(String description) {
        this.description = description;
    }

    void ajoute (PlatAuMenu p)
    {
        plat.add(p);
    }

    public void position(int i)
    {
        courant = i;
    }

    public PlatAuMenu platCourant()
    {
        return plat.get(courant);
    }

    public void positionSuivante() throws MenuException
    {
        if (hasNext())
            next();
        else
            throw new MenuException("On depasse le nombre maximale de plats.");
    }

    public void positionPrecedente() throws MenuException
    {
        if (courant-1 < 0)
            throw new MenuException("On depasse le nombre minimale de plats");
        else
            courant--;
    }


    @Override
    public String toString() {
        return "menufact.Menu{" +
                "description='" + description + '\'' +
                ", courant=" + courant +
                ", plat=" + "\n" + plat +
                '}';
    }

    @Override
    public boolean hasNext() {
        if (courant+1 >= plat.size())
            return false;
        else
            return true;
    }

    @Override
    public String next() {
        courant++;
        return null;
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }

    @Override
    public void forEachRemaining(Consumer<? super String> action) {
        Iterator.super.forEachRemaining(action);
    }

}
