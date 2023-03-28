package esercizio.pkg14;

public class Amatoriale extends Tesserato{
    private static int i = 1;

    public Amatoriale(String nome, String cognome, String CF, String codiceTessera, Corso corso) {
        super(nome, cognome, CF, codiceTessera, corso);
    }
    
    public Amatoriale(String nome, String cognome, String CF, Corso corso) {
        super(nome, cognome, CF, "", corso);
        generaCodiceTessera();
    }
    
    @Override public void generaCodiceTessera() {
        i++;
        codiceTessera = "A" + String.valueOf(i-1);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tipo: Amatoriale");
        sb.append(" - Nome: ").append(nome);
        sb.append(" - Cognome: ").append(cognome);
        sb.append(" - CF: ").append(CF);
        sb.append(" - Codice Tessera: ").append(codiceTessera);
        sb.append(" - Corso: ").append(corso);
        return sb.toString();
    }
}
