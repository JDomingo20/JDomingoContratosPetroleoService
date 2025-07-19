
package com.JDomingoContratosPetroleo.DomingoContratosPetroleo.Repository;

import com.JDomingoContratosPetroleo.DomingoContratosPetroleo.JPA.Tarifa;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarifaRepository extends JpaRepository<Tarifa, Integer>{
    
    List<Tarifa> findAllByOrderByIdTarifa();
    
}
