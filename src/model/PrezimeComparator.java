package model;

import java.util.Comparator;

/**
 * Comparator, basically you just used String toCompare to cheat here a bit. 
 * But its accepted. Otherwise look this up a bit, things could maybe get complicated. Also 
 * hashCode and equals.
 * @author Slobodan
 *
 */
public class PrezimeComparator implements Comparator<Veterinar> {
    @Override
    public int compare(Veterinar vet1, Veterinar vet2) {
        int result = vet1.getPrezime().compareTo(vet2.getPrezime());
        if(result != 0) return result;
        return vet1.getIme().compareTo(vet2.getIme());
    }
}