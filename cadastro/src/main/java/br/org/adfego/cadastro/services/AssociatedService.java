package br.org.adfego.cadastro.services;

import br.org.adfego.cadastro.model.entity.Associated;
import br.org.adfego.cadastro.model.entity.DeficiencyAssociated;
import br.org.adfego.cadastro.model.entity.Identifier;
import br.org.adfego.cadastro.model.repository.AssociatedRepository;
import br.org.adfego.cadastro.model.repository.DeficiencyAssociatedRepository;
import br.org.adfego.cadastro.model.repository.IdentifierRepository;
import br.org.adfego.cadastro.services.exceptions.DataIntegrityException;
import br.org.adfego.cadastro.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Collection;

@Service
public class AssociatedService {

    @Autowired
    private AssociatedRepository repository;

    @Autowired
    private IdentifierRepository identifierRepository;

    @Autowired
    private DeficiencyAssociatedRepository deficiencyAssociateds;

    public Associated findById(Long id) {
        Associated obj = repository.findById(id).get();
        if (obj == null) {
            throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Associated.class.getName());
        }
        return obj;
    }

    public Collection<Associated> findAll() {
        return repository.findAll();
    }

    public Associated insert(Associated obj) {
    	obj.setId(null);
        try {
            Associated associated = repository.save(obj);

            if(!ObjectUtils.isEmpty(associated.getIdentifiers())){
                for(Identifier i : obj.getIdentifiers()){
                    i.setAssociated(obj);
                    identifierRepository.save(i);
                }
            }

            if(!ObjectUtils.isEmpty(associated.getDeficiencyAssociateds())){
                for(DeficiencyAssociated i : obj.getDeficiencyAssociateds()){
                    i.setAssociated(obj);
                    deficiencyAssociateds.save(i);
                }
            }
        	return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) do Associado não foi(foram) preenchido(s): ");
        }
    }

    public Associated update(Associated obj) {
        try {
        	return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) do Associado não foi(foram) preenchido(s): ");
        }
    }

    public void delete(Long id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir um associado pois está sendo relacionado!");
        }
    }

    public Collection<Associated> findAllByOrderByName() {
        return repository.findAllByOrderByName();
    }

    public Collection<Associated> findByName(final String nome) {
        return repository.findByName(nome);
    }
}
