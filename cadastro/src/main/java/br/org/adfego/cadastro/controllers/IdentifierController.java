package br.org.adfego.cadastro.controllers;

import br.org.adfego.cadastro.model.entity.Identifier;
import br.org.adfego.cadastro.services.IdentifierService;
import br.org.adfego.cadastro.services.exceptions.ConstraintException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping(value = "/identifiers")
public class IdentifierController {

    @Autowired
    private IdentifierService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Identifier>> findAll() {
        Collection<Identifier> collection = service.findAll();
        return ResponseEntity.ok().body(collection);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Identifier> find(@PathVariable Long id) {
        Identifier obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Identifier> insert(@Valid @RequestBody Identifier obj, BindingResult br) {
        if (br.hasErrors())
        	throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Identifier> update(@Valid @RequestBody Identifier obj, BindingResult br) {
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

    @RequestMapping(value = "/identifiers/{idAssociated}", method = RequestMethod.GET)
    public ResponseEntity<Collection<Identifier>> findIdentifiers(@PathVariable Long idAssociated) {
        Collection<Identifier> collection = service.findIdentifiers(idAssociated);
        return ResponseEntity.ok().body(collection);
    }

}
