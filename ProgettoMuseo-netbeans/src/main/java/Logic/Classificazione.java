package Logic;

import java.util.HashMap;

public class Classificazione {
    private HashMap<String, String> albero;
    private float probabilità;

    public Classificazione(HashMap<String, String> albero, float probabilità) {
        this.albero = albero;
        this.probabilità = probabilità;
    }

    public HashMap<String, String> getAlbero() {
        return albero;
    }

    public float getProbabilità() {
        return probabilità;
    }

    public void setProbabilità(float probabilità) {
        this.probabilità = probabilità;
    }

    public void setAlbero(HashMap<String, String> albero) {
        this.albero = albero;
    }

}
