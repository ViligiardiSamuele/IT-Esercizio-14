package esercizio.pkg14;

public abstract class Tesserato implements Comparable<Tesserato>{
    protected String nome, cognome, CF, codiceTessera;
    protected Corso corso;

    public Tesserato(String nome, String cognome, String CF, String codiceTessera, Corso corso) {
        this.nome = nome;
        this.cognome = cognome;
        this.CF = CF;
        this.codiceTessera = codiceTessera;
        this.corso = corso;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getCF() {
        return CF;
    }

    public String getCodiceTessera() {
        return codiceTessera;
    }

    public Corso getCorso() {
        return corso;
    }
    
    public abstract void generaCodiceTessera();

    @Override
    public int compareTo(Tesserato t) {
        return this.getCF().compareToIgnoreCase(t.getCF());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" - Nome: ").append(nome);
        sb.append(" - Cognome: ").append(cognome);
        sb.append(" - CF: ").append(CF);
        sb.append(" - Codice Tessera: ").append(codiceTessera);
        sb.append(" - Corso: ").append(corso);
        return sb.toString();
    }
    
    
}