package edu.udem.feriainternacional.data;

/**
 * Created by andrea on 18/02/17.
 */

public class Tema {

    private long id;
    private String nombre;
    private int color;


    public Tema() { }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
