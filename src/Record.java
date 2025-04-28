public class Record {
    private int anno;
    private String regione;
    private double percentuale;

    public Record(int anno, String regione, double percentuale) {
        this.anno = anno;
        this.regione = regione;
        this.percentuale = percentuale;
    }

    public int getAnno() {
        return anno;
    }

    public String getRegione() {
        return regione;
    }

    public double getPercentuale() {
        return percentuale;
    }

    @Override
    public String toString() {
        return anno + ";" + regione + ";" + percentuale;
    }
}