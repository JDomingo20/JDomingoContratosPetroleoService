
package com.JDomingoContratosPetroleo.DomingoContratosPetroleo.Repository;

import com.JDomingoContratosPetroleo.DomingoContratosPetroleo.JPA.Cantidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CantidadRepository extends JpaRepository<Cantidad, Long> {
    
}
