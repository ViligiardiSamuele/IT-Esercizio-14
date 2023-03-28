package esercizio.comparators;

import esercizio.pkg14.Tesserato;
import java.util.Comparator;

public class Tesserato_Codice_Comparator implements Comparator<Tesserato>{

    @Override
    public int compare(Tesserato o1, Tesserato o2) {
        return o1.getCodiceTessera().compareToIgnoreCase(o2.getCodiceTessera());
    }
}