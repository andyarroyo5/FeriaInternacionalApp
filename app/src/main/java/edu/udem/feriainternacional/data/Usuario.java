package edu.udem.feriainternacional.data;

import android.net.Uri;

/**
 * Created by laboratorio on 2/15/17.
 */



public class Usuario {

    private String id;
    private String nombre;
    private String correo;
    private Uri imgPerfil;
    private String carrera;
    private String twitter;
    private int puntos;


    public Usuario(String id, String nombre, String correo, Uri imgPerfil) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.imgPerfil = imgPerfil;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Uri getImgPerfil() {
        return imgPerfil;
    }

    public void setImgPerfil(Uri imgPerfil) {
        this.imgPerfil = imgPerfil;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
}
