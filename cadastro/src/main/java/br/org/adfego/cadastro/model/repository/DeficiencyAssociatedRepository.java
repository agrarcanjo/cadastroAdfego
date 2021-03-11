package br.org.adfego.cadastro.model.repository;

import br.org.adfego.cadastro.model.entity.DeficiencyAssociated;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Repository
public interface DeficiencyAssociatedRepository extends JpaRepository<DeficiencyAssociated, Long> {

    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM DeficiencyAssociated WHERE deficiencyAssociated.id_identifier = ?1", nativeQuery = true)
    public Collection<DeficiencyAssociated> findDeficiencyAssociated(Long idAssociated);

}
