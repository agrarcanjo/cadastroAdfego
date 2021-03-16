package br.org.adfego.cadastro.services;

import br.org.adfego.cadastro.model.entity.Phone;
import br.org.adfego.cadastro.model.repository.PhoneRepository;
import br.org.adfego.cadastro.services.exceptions.DataIntegrityException;
import br.org.adfego.cadastro.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.NoSuchElementException;

@Service
public class PhoneService {

    @Autowired
    private PhoneRepository repository;

    public Phone findById(Long id) {
    	try {
            Phone obj = repository.findById(id).get();
        	return obj;
        } catch (NoSuchElementException e) {
        	throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Phone.class.getName());
        }
    }

    public Collection<Phone> findAll() {
        return repository.findAll();
    }

    public Phone insert(Phone obj) {
        obj.setId(null);
        try {
        	return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) não foi(foram) preenchido(s)");
        }
    }

    public Phone update(Phone obj) {
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
            throw new DataIntegrityException("Não é possível excluir um Tipo de Filme com Filmes vinculados a Empréstimos!");
        }
    }

    public Collection<Phone> findPhones(Long idAssociated) {
        return repository.findPhones(idAssociated);
    }

    public Collection<Phone> findPhonesType(Long idAssociated, Integer type) {
        return repository.findPhonesType(idAssociated, type);
    }

}
