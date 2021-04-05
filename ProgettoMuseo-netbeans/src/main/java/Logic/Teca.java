public class Teca extends IdentifiedObj{
    private float altezza;
    private float larghezza;
    private float profondità;

    public Teca(int id, float altezza, float larghezza, float profondità){
        super(id);
        this.altezza = altezza;
        this.larghezza = larghezza;
        this.profondità = profondità;
    };

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
