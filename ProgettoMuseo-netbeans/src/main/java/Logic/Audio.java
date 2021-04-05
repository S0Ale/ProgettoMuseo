package Logic;

public class Audio extends ContenutoMultimediale{
    private String descrizione;
    private float durata;

    public Audio(int id, String percorso, String descrizione, float durata) {
        super(id, percorso);
        this.descrizione = descrizione;
        this.durata = durata;
    }

    public String getDescrizione() {
        return descrizione;
    }
    public float getDurata() {
        return durata;
    }
    public void setDurata(float durata) {
        this.durata = durata;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    
}
