package br.org.adfego.cadastro.model.repository;

import br.org.adfego.cadastro.model.entity.Identifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Repository
public interface IdentifierRepository extends JpaRepository<Identifier, Long> {

    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM Identifier WHERE identifier.id_identifier = ?1", nativeQuery = true)
    public Collection<Identifier> findIdentifiers(Long idIdentifier);

}
