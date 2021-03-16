package br.org.adfego.cadastro.model.repository;

import br.org.adfego.cadastro.model.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {

    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM Phone WHERE phone.id_identifier = ?1", nativeQuery = true)
    public Collection<Phone> findPhones(Long idPhone);

    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM Phone WHERE phone.id_identifier = ?1 and phone.phone_type = ?2", nativeQuery = true)
    public Collection<Phone> findPhonesType(Long idPhone, Integer type);

}
