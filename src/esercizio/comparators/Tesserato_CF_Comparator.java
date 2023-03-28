package esercizio.comparators;

import esercizio.pkg14.Tesserato;
import java.util.Comparator;

public class Tesserato_CF_Comparator implements Comparator<Tesserato>{

    @Override
    public int compare(Tesserato o1, Tesserato o2) {
        return o1.getCF().compareToIgnoreCase(o2.getCF());
    }
}