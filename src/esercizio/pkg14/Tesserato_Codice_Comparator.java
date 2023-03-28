package esercizio.pkg14;

import java.util.Comparator;

public class Tesserato_Codice_Comparator implements Comparator<Tesserato>{

    @Override
    public int compare(Tesserato o1, Tesserato o2) {
        return o1.getCodiceTessera().compareTo(o2.getCodiceTessera());
    }
    
}
