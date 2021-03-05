package br.org.adfego.cadastro.services;

import br.org.adfego.cadastro.model.entity.Identifier;
import br.org.adfego.cadastro.model.repository.IdentifierRepository;
import br.org.adfego.cadastro.services.exceptions.DataIntegrityException;
import br.org.adfego.cadastro.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.NoSuchElementException;

@Service
public class IdentifierService {

    @Autowired
    private IdentifierRepository repository;

    public Identifier findById(Long id) {
    	try {
            Identifier obj = repository.findById(id).get();
        	return obj;
        } catch (NoSuchElementException e) {
        	throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Identifier.class.getName());
        }
    }

    public Collection<Identifier> findAll() {
        return repository.findAll();
    }

    public Identifier insert(Identifier obj) {
        obj.setId(null);
        try {
        	return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) do Tipo de Filme não foi(foram) preenchido(s)");
        }
    }

    public Identifier update(Identifier obj) {
        findById(obj.getId());
        try {
        	return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) do Tipo de Filme não foi(foram) preenchido(s)");
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

    public Collection<Identifier> findIdentifiers(Long idAssociated) {
        return repository.findIdentifiers(idAssociated);
    }

}
