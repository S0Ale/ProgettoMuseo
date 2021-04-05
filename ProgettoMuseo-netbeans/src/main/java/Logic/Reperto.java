import java.sql.Date;
import java.util.ArrayList;

public class Reperto extends IdentifiedObj {
    private Mesh modelloMesh;
    private ArrayList<Foto> foto;
    private ArrayList<Classificazione> specie;
    private Audio descrizioneAudio;
    private Teca teca;
    private String periodo;
    private Date dataScoperta;
    private int idLuogoScoperta;
    private ArrayList<Integer> idRicercatori;
    private float altezza;
    private float larghezza;
    private float profondità;

    public Reperto(int id, Mesh modelloMesh, ArrayList<Foto> foto, ArrayList<Classificazione> specie,
            Audio descrizioneAudio, Teca teca, String periodo, Date dataScoperta, int idLuogoScoperta,
            ArrayList<Integer> idRicercatori, float altezza, float larghezza, float profondità) {
        super(id);
        this.modelloMesh = modelloMesh;
        this.foto = foto;
        this.specie = specie;
        this.descrizioneAudio = descrizioneAudio;
        this.teca = teca;
        this.periodo = periodo;
        this.dataScoperta = dataScoperta;
        this.idLuogoScoperta = idLuogoScoperta;
        this.idRicercatori = idRicercatori;
        this.altezza = altezza;
        this.larghezza = larghezza;
        this.profondità = profondità;
    }

    public Mesh getModelloMesh() {
        return this.modelloMesh;
    }

    public void setModelloMesh(Mesh modelloMesh) {
        this.modelloMesh = modelloMesh;
    }

    public ArrayList<Foto> getFoto() {
        return this.foto;
    }

    public void setFoto(ArrayList<Foto> foto) {
        this.foto = foto;
    }

    public ArrayList<Classificazione> getSpecie() {
        return this.specie;
    }

    public void setSpecie(ArrayList<Classificazione> specie) {
        this.specie = specie;
    }

    public Audio getDescrizioneAudio() {
        return this.descrizioneAudio;
    }

    public void setDescrizioneAudio(Audio descrizioneAudio) {
        this.descrizioneAudio = descrizioneAudio;
    }

    public Teca getTeca() {
        return this.teca;
    }

    public void setTeca(Teca teca) {
        this.teca = teca;
    }

    public String getPeriodo() {
        return this.periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Date getDataScoperta() {
        return this.dataScoperta;
    }

    public void setDataScoperta(Date dataScoperta) {
        this.dataScoperta = dataScoperta;
    }

    public int getIdLuogoScoperta() {
        return this.idLuogoScoperta;
    }

    public void setIdLuogoScoperta(int idLuogoScoperta) {
        this.idLuogoScoperta = idLuogoScoperta;
    }

    public ArrayList<Integer> getIdRicercatori() {
        return this.idRicercatori;
    }

    public void setIdRicercatori(ArrayList<Integer> idRicercatori) {
        this.idRicercatori = idRicercatori;
    }

    public float getAltezza() {
        return this.altezza;
    }

    public void setAltezza(float altezza) {
        this.altezza = altezza;
    }

    public float getLarghezza() {
        return this.larghezza;
    }

    public void setLarghezza(float larghezza) {
        this.larghezza = larghezza;
    }

    public float getProfondità() {
        return this.profondità;
    }

    public void setProfondità(float profondità) {
        this.profondità = profondità;
    }

}
