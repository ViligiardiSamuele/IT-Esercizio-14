package esercizio.pkg14;

public class Agonista extends Tesserato{
    private int i = 1;

    public Agonista(String nome, String cognome, String CF, String codiceTessera, Corso corso) {
        super(nome, cognome, CF, codiceTessera, corso);
    }
    
    public Agonista(String nome, String cognome, String CF, Corso corso) {
        super(nome, cognome, CF, "", corso);
        generaCodiceTessera();
    }
    
    
    @Override
    public void generaCodiceTessera() {
        i++;
        codiceTessera = "P" + String.valueOf(i-1);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tipo: Agonista");
        sb.append(" - Nome: ").append(nome);
        sb.append(" - Cognome: ").append(cognome);
        sb.append(" - CF: ").append(CF);
        sb.append(" - Codice Tessera: ").append(codiceTessera);
        sb.append(" - Corso: ").append(corso);
        return sb.toString();
    }
    
}
