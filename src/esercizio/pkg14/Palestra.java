package esercizio.pkg14;

import esercizio.comparators.Tesserato_Cognome_Comparator;
import esercizio.exceptions.GaraException;
import esercizio.exceptions.PalestraException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Palestra {
    private ArrayList<Tesserato> tesserati;
    private ArrayList<Gara> gare;

    public Palestra() {
        this.tesserati = new ArrayList<>();
        this.gare = new ArrayList<>();
    }
    
    public boolean addTesserato(Tesserato t) throws PalestraException{
        for(Tesserato tess : tesserati){
            if(t.compareTo(tess) == 0)
                throw new PalestraException("Tesserato gia' presente!");
        }
        return true;
    }
    
    public void stampaLista() throws PalestraException{
        if(tesserati.isEmpty()) throw new PalestraException("Nessun tesserato presente!");
        if(gare.isEmpty()) throw new PalestraException("Nessuna gara presente!");
        
        //hashmap per contare le vittorie di ogni tesserato
        HashMap<Tesserato, Integer> winTesserato = new HashMap<>();
        
        tesserati.forEach(t -> { //scorro tesserati
            gare.forEach(g -> { //scorro gare
                try{
                    if(g.getPrimoPosto() == t) //controllo primo posto
                        if(!winTesserato.containsKey(t)) //caso: prima vittoria
                            winTesserato.put(t,1);
                    winTesserato.replace(t, winTesserato.get(t) + 1);
                }catch(GaraException ge){
                    System.out.println(ge.getMessage());
                }
            });
        });
        
        tesserati.forEach(t -> {
            if(winTesserato.values().contains(t))
                if(t instanceof Amatoriale a){
                    System.out.println(a.toString());
                } else if(t instanceof Agonista a){
                    System.out.println(a.toString());
                }
        });
    }
    
    public void sortTesseratiCognome(){
        Collections.sort(tesserati, new Tesserato_Cognome_Comparator());
    }
    
    public void sortTesseratiCodice(){
        Collections.sort(tesserati, new Tesserato_Codice_Comparator());
    }
    
    public ArrayList<Agonista> allAgonisti(){
        ArrayList<Agonista> agonisti = new ArrayList<>();
        tesserati.forEach(t -> {if(t instanceof Agonista a) agonisti.add(a);});
        return agonisti;
    }
    
    public ArrayList<Agonista> allAginistiOrdinati(){
        //recupero i tesserati che hanno gareggiato con il rispettivo conteggio
        HashMap<Tesserato, Integer> gareTesserato = new HashMap<>();
        tesserati.forEach(t -> { //scorro tesserati
            gare.forEach(g -> { //scorro gare
                if (g.getPartecipanti().values().contains(t)) {
                    if(!gareTesserato.containsKey(t)) //caso: prima presenza
                        gareTesserato.put(t,1);
                }
                gareTesserato.replace(t, gareTesserato.get(t) + 1);
            });
        });
        //inverto la chiave con il valore
        HashMap<Integer, Tesserato> tesseratoGare = new HashMap<>();
        tesserati.forEach(t -> {
            gareTesserato.values().forEach(gt -> {
                if(gareTesserato.values().contains(t))
                    tesseratoGare.putIfAbsent(gareTesserato.get(t),t);
            });
        });
        //inizializzo un'array dove inserisco il tesserato comparando la sua presenza
        //come chiave nell'hashmap ed incrementandola fino a gare.size()
        ArrayList<Agonista> output = new ArrayList<>();
        tesserati.forEach(t -> {
            for(int i = 0; i < gare.size(); i++){
                if(gareTesserato.containsKey(i) && t instanceof Agonista a)
                    output.add((Agonista)(tesseratoGare.get(gareTesserato.get(i))));
            }
        });
        return output;
    }
    
    public ArrayList<Amatoriale> allAmatoriali(){
        ArrayList<Amatoriale> output = new ArrayList<>();
        tesserati.forEach(t -> {
            if(t instanceof Amatoriale a)
                output.add(a);
        });
        return output;
    }
}
