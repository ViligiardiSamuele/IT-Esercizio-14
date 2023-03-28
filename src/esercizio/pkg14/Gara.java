package esercizio.pkg14;

import esercizio.exceptions.GaraException;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class Gara {
    private HashMap<Integer,Tesserato> partecipanti;
    private String Descrizione;
    private GregorianCalendar data;
    private int piazzamento;

    public Gara(HashMap<Integer, Tesserato> partecipanti, String Descrizione, GregorianCalendar data, int piazzamento) {
        this.partecipanti = partecipanti;
        this.Descrizione = Descrizione;
        this.data = data;
        this.piazzamento = piazzamento;
    }
    public Gara(String Descrizione, GregorianCalendar data, int piazzamento) {
        this.partecipanti = new HashMap<>();
        this.Descrizione = Descrizione;
        this.data = data;
        this.piazzamento = piazzamento;
    }
    public Gara(Gara g) {
        this.partecipanti = new HashMap<>(g.partecipanti);
        this.Descrizione = g.Descrizione;
        this.data = g.data;
        this.piazzamento = g.piazzamento;
    }

    public HashMap<Integer, Tesserato> getPartecipanti() {
        return partecipanti;
    }

    public String getDescrizione() {
        return Descrizione;
    }

    public GregorianCalendar getData() {
        return data;
    }

    public int getPiazzamento() {
        return piazzamento;
    }
    
    public boolean addPartecipante(int podio, Tesserato partecipante) throws GaraException{
        if(     partecipanti.containsKey(podio) &&
                partecipanti.containsValue(partecipante)
            ) throw new GaraException("Partecipante gia' presente!");
        partecipanti.putIfAbsent(podio, partecipante);
        return true;
    }
    
    public Tesserato getTesseratoByPosition(int pos) throws GaraException{
        if(partecipanti.get(pos) == null)
            throw new GaraException("Posizione nel podio inesistente!");
        return partecipanti.get(pos);
    }
    
    public Tesserato getPrimoPosto() throws GaraException{
        if(partecipanti.get(0) == null)
            throw new GaraException("Primo posto inesistente!");
        return partecipanti.get(0);
    }
}
