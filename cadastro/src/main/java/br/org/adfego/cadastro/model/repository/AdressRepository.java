package br.org.adfego.cadastro.model.repository;

import br.org.adfego.cadastro.model.entity.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressRepository extends JpaRepository<Adress, Long> {

}
