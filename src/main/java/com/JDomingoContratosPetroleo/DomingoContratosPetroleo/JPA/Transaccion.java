
package com.JDomingoContratosPetroleo.DomingoContratosPetroleo.JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
public class Transaccion {
    
    @Id
    @Column(name = "idtransaccion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Idtransaccion;
    
    @Column(name = "fecharegistro")
    private Date FechaRegistro;
    
    @JoinColumn(name = "idcontrato")
    @OneToMany
    public List<Contrato> contrato;
    
    @JoinColumn(name = "idnodorecepcion")
    @OneToMany
    public List<NodoRecepcion> nodoRecepcion;
    
    @JoinColumn(name="idnodocomercial")
    @OneToMany
    public List<NodoEntrega> nodoComercial;
    
    @JoinColumn(name = "zonainyeccion")
    @OneToMany
    public List<Zona> zonaInyeccion;
    
    @JoinColumn(name = "zonaextraccion")
    @OneToMany
    public List<Zona> zonaExraccion;
    
    @Column(name = "gasexceso")
    private double GasExceso;
    
    @Column(name = "cargouso")
    private double CargoUso;
    
    @Column(name = "cargogasexceso")
    private double CargoGasExceso;
    
    @Column(name = "facturatotal")
    private double FacturaTotal;
    
    @JoinColumn(name="cantidad")
    @OneToMany
    public List<Cantidad> cantidad;

    public int getIdtransaccion() {
        return Idtransaccion;
    }

    public void setIdtransaccion(int Idtransaccion) {
        this.Idtransaccion = Idtransaccion;
    }

    public Date getFechaRegistro() {
        return FechaRegistro;
    }

    public void setFechaRegistro(Date FechaRegistro) {
        this.FechaRegistro = FechaRegistro;
    }

    public List<Contrato> getContrato() {
        return contrato;
    }

    public void setContrato(List<Contrato> contrato) {
        this.contrato = contrato;
    }

    public List<NodoRecepcion> getNodoRecepcion() {
        return nodoRecepcion;
    }

    public void setNodoRecepcion(List<NodoRecepcion> nodoRecepcion) {
        this.nodoRecepcion = nodoRecepcion;
    }

    public List<NodoEntrega> getNodoComercial() {
        return nodoComercial;
    }

    public void setNodoComercial(List<NodoEntrega> nodoComercial) {
        this.nodoComercial = nodoComercial;
    }

    public List<Zona> getZonaInyeccion() {
        return zonaInyeccion;
    }

    public void setZonaInyeccion(List<Zona> zonaInyeccion) {
        this.zonaInyeccion = zonaInyeccion;
    }

    public List<Zona> getZonaExraccion() {
        return zonaExraccion;
    }

    public void setZonaExraccion(List<Zona> zonaExraccion) {
        this.zonaExraccion = zonaExraccion;
    }

    public double getGasExceso() {
        return GasExceso;
    }

    public void setGasExceso(double GasExceso) {
        this.GasExceso = GasExceso;
    }

    public double getCargoUso() {
        return CargoUso;
    }

    public void setCargoUso(double CargoUso) {
        this.CargoUso = CargoUso;
    }

    public double getCargoGasExceso() {
        return CargoGasExceso;
    }

    public void setCargoGasExceso(double CargoGasExceso) {
        this.CargoGasExceso = CargoGasExceso;
    }

    public double getFacturaTotal() {
        return FacturaTotal;
    }

    public void setFacturaTotal(double FacturaTotal) {
        this.FacturaTotal = FacturaTotal;
    }

    public List<Cantidad> getCantidad() {
        return cantidad;
    }

    public void setCantidad(List<Cantidad> cantidad) {
        this.cantidad = cantidad;
    }
}
