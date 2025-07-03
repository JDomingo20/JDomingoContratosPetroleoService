
package com.JDomingoContratosPetroleo.DomingoContratosPetroleo.JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class NodoComercial {
    
    @Id
    @Column(name = "idnodocomercial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdNodoComercial;
    
    @Column(name = "clave")
    private String Clave;
    
    @Column(name = "descripcion")
    private String Descripcion;

    public int getIdNodoComercial() {
        return IdNodoComercial;
    }

    public void setIdNodoComercial(int IdNodoComercial) {
        this.IdNodoComercial = IdNodoComercial;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
}
