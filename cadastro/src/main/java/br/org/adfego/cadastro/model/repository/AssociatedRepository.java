package br.org.adfego.cadastro.model.repository;

import br.org.adfego.cadastro.model.entity.Associated;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

public interface AssociatedRepository extends JpaRepository<Associated, Long> {
	
	boolean existsByEmail(String email);
	
	Optional<Associated> findByEmail(String email);

	@Transactional(readOnly = true)
	public Collection<Associated> findAllByOrderByName();

	@Transactional(readOnly = true)
	public Collection<Associated> findByName(String nome);
}
