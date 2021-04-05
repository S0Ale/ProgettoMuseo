package Logic;

public class Mesh extends ContenutoMultimediale{
    private int idNuvolaDiPunti;

    public Mesh(int id, String percorso, int idNuvolaDiPunti) {
        super(id, percorso);
        this.setIdNuvolaDiPunti(idNuvolaDiPunti);
    }

    public int getIdNuvolaDiPunti() {
        return idNuvolaDiPunti;
    }

    public void setIdNuvolaDiPunti(int idNuvolaDiPunti) {
        this.idNuvolaDiPunti = idNuvolaDiPunti;
    }


}
