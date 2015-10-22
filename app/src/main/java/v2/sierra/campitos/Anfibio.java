package v2.sierra.campitos;

/**
 * Created by campitos on 18/02/15.
 */
public class Anfibio {
    int id;
    String titulo;
    String sinopsis;

    public Anfibio() {
    }

    public Anfibio(String titulo, String sinopsis) {
        this.titulo = titulo;
        this.sinopsis = sinopsis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
}
