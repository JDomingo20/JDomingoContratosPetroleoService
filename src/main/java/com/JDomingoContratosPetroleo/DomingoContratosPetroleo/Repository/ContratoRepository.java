package com.JDomingoContratosPetroleo.DomingoContratosPetroleo.Repository;

import com.JDomingoContratosPetroleo.DomingoContratosPetroleo.JPA.Contrato;
import com.JDomingoContratosPetroleo.DomingoContratosPetroleo.JPA.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Integer> {

    Contrato findByIdContrato(int idContrato);

    List<Contrato> findByUsuario(Usuario usuario); 

}
