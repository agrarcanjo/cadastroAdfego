package br.org.adfego.cadastro.services;

import br.org.adfego.cadastro.model.entity.Adress;
import br.org.adfego.cadastro.model.repository.AdressRepository;
import br.org.adfego.cadastro.services.exceptions.DataIntegrityException;
import br.org.adfego.cadastro.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.NoSuchElementException;

@Service
public class AdressService {

    @Autowired
    private AdressRepository repository;

    public Adress findById(Long id) {
    	try {
            Adress obj = repository.findById(id).get();
        	return obj;
        } catch (NoSuchElementException e) {
        	throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Adress.class.getName());
        }
    }

    public Collection<Adress> findAll() {
        return repository.findAll();
    }

    public Adress insert(Adress obj) {
    	obj.setId(null);
        try {
        	return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) do Endereço não foi(foram) preenchido(s): ");
        }
    }

    public Adress update(Adress obj) {
    	findById(obj.getId());
        try {
        	return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) do Endereço não foi(foram) preenchido(s): ");
        }
    }

    public void delete(Long id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir um Endereço associado a uma Pessoa (Associado)!");
        }
    }

}
