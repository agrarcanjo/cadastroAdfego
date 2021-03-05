package br.org.adfego.cadastro.controllers;

import br.org.adfego.cadastro.model.entity.Associated;
import br.org.adfego.cadastro.services.AssociatedService;
import br.org.adfego.cadastro.services.exceptions.ConstraintException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping(value = "/associated")
public class AssociatedController {

    @Autowired
    private AssociatedService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Associated>> findAll() {
        Collection<Associated> collection = service.findAll();
        return ResponseEntity.ok().body(collection);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Associated> find(@PathVariable Long id) {
        Associated obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Associated> insert(@Valid @RequestBody Associated obj, BindingResult br) {
        if (br.hasErrors())
        	throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Associated> update(@Valid @RequestBody Associated obj, BindingResult br) {
        if (br.hasErrors())
        	throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        obj = service.update(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/orderByNome", method = RequestMethod.GET)
    public ResponseEntity<Collection<Associated>> findAllByOrderByNome() {
        Collection<Associated> collection = service.findAllByOrderByName();
        return ResponseEntity.ok().body(collection);
    }

    @RequestMapping(value = "/byNome/{nome}", method = RequestMethod.GET)
    public ResponseEntity<Collection<Associated>> findByNome(@PathVariable String nome) {
        Collection<Associated> collection = service.findByName(nome);
        return ResponseEntity.ok().body(collection);
    }


}
