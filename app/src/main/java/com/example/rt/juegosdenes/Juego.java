package com.example.rt.juegosdenes;

public class Juego {
    private String nombre,desarrollador;
    private int anio,caratula,musica;

    public Juego(String nombre, String desarrollador, int anio, int caratula, int musica) {
        this.nombre = nombre;
        this.desarrollador = desarrollador;
        this.anio = anio;
        this.caratula = caratula;
        this.musica = musica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getCaratula() {
        return caratula;
    }

    public void setCaratula(int caratula) {
        this.caratula = caratula;
    }

    public int getMusica() {
        return musica;
    }

    public void setMusica(int musica) {
        this.musica = musica;
    }
}
