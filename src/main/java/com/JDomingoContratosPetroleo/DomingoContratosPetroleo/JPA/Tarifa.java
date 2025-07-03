package com.JDomingoContratosPetroleo.DomingoContratosPetroleo.JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;

@Entity
public class Tarifa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtarifa")
    private int IdTarifa;

    @Column(name = "tipo")
    private String Tipo;

    @JoinColumn(name = "iddetalletarifa")
    @OneToOne
    public DetalleTarifa detalleTarifa;

    @JoinColumn(name = "idtransaccion")
    @OneToMany
    public List<Transaccion> transaccion;

    public int getIdTarifa() {
        return IdTarifa;
    }

    public void setIdTarifa(int IdTarifa) {
        this.IdTarifa = IdTarifa;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public DetalleTarifa getDetalleTarifa() {
        return detalleTarifa;
    }

    public void setDetalleTarifa(DetalleTarifa detalleTarifa) {
        this.detalleTarifa = detalleTarifa;
    }

    public List<Transaccion> getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(List<Transaccion> transaccion) {
        this.transaccion = transaccion;
    }

}
