package com.JDomingoContratosPetroleo.DomingoContratosPetroleo.Repository;

import com.JDomingoContratosPetroleo.DomingoContratosPetroleo.JPA.Transaccion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion, Integer>{
    
    List<Transaccion> findAllByOrderByIdTransaccion();
}
