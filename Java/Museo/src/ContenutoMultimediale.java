public abstract class ContenutoMultimediale extends IdentifiedObj{
    
    private String percorso;

    public ContenutoMultimediale(int id, String percorso) {
        super(id);
        this.percorso = percorso;
    }

    public String getPercorso() {
        return percorso;
    }

    public void setPercorso(String percorso) {
        this.percorso = percorso;
    }

}
