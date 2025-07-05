package com.JDomingoContratosPetroleo.DomingoContratosPetroleo.JPA;

import java.util.ArrayList;
import java.util.List;

public class ResultadoLectura {

    private List<Zona> zonas;
    private List<Usuario> usuarios;
    private List<NodoRecepcion> nrecepciones;
    private List<NodoEntrega> nentregas;
    public ResultadoLectura() {
        this.zonas = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.nrecepciones = new ArrayList<>();
        this.nentregas = new ArrayList<>();
    }

    public List<Zona> getZonas() {
        return zonas;
    }

    public void setZonas(List<Zona> zonas) {
        this.zonas = zonas;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<NodoRecepcion> getNrecepciones() {
        return nrecepciones;
    }

    public void setNrecepciones(List<NodoRecepcion> nrecepciones) {
        this.nrecepciones = nrecepciones;
    }

    public List<NodoEntrega> getNentregas() {
        return nentregas;
    }

    public void setNentregas(List<NodoEntrega> nentregas) {
        this.nentregas = nentregas;
    }
    
}
