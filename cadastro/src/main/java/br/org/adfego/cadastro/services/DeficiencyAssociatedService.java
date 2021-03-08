package br.org.adfego.cadastro.services;

import br.org.adfego.cadastro.model.entity.DeficiencyAssociated;
import br.org.adfego.cadastro.model.repository.DeficiencyAssociatedRepository;
import br.org.adfego.cadastro.services.exceptions.DataIntegrityException;
import br.org.adfego.cadastro.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.NoSuchElementException;

@Service
public class DeficiencyAssociatedService {

    @Autowired
    private DeficiencyAssociatedRepository repository;

    public DeficiencyAssociated findById(Long id) {
    	try {
            DeficiencyAssociated obj = repository.findById(id).get();
        	return obj;
        } catch (NoSuchElementException e) {
        	throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + DeficiencyAssociated.class.getName());
        }
    }

    public Collection<DeficiencyAssociated> findAll() {
        return repository.findAll();
    }

    public DeficiencyAssociated insert(DeficiencyAssociated obj) {
        obj.setId(null);
        try {
        	return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) não foi(foram) preenchido(s)");
        }
    }

    public DeficiencyAssociated update(DeficiencyAssociated obj) {
        findById(obj.getId());
        try {
        	return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) não foi(foram) preenchido(s)");
        }
    }

    public void delete(Long id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir um tipo de deficiencia vinculados a Associados!");
        }
    }

    public Collection<DeficiencyAssociated> findDeficiencyAssociated(Long idAssociated) {
        return repository.findDeficiencyAssociated(idAssociated);
    }

}
