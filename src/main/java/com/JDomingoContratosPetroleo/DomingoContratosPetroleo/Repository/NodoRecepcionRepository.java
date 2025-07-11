
package com.JDomingoContratosPetroleo.DomingoContratosPetroleo.Repository;

import com.JDomingoContratosPetroleo.DomingoContratosPetroleo.JPA.NodoRecepcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NodoRecepcionRepository extends JpaRepository<NodoRecepcion, Long>{
    
}
