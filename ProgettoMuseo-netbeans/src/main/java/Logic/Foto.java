package Logic;

import java.sql.Date;

public class Foto extends ContenutoMultimediale{

    private Date data;
    private String descrizione;

    public Foto(int id, String percorso, Date data, String descrizione) {
        super(id, percorso);
        this.setData(data);
        this.setDescrizione(descrizione);
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

}