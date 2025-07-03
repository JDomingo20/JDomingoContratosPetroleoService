
package com.JDomingoContratosPetroleo.DomingoContratosPetroleo.JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DetalleTarifa {
    @Id
    @Column(name = "iddetalletarifa")
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int IdDetalleTarifa;
    
    @Column(name = "totaltarifa")
    private double TotalTarifa;

    public int getIdDetalleTarifa() {
        return IdDetalleTarifa;
    }

    public void setIdDetalleTarifa(int IdDetalleTarifa) {
        this.IdDetalleTarifa = IdDetalleTarifa;
    }

    public double getTotalTarifa() {
        return TotalTarifa;
    }

    public void setTotalTarifa(double TotalTarifa) {
        this.TotalTarifa = TotalTarifa;
    }    
    
}
