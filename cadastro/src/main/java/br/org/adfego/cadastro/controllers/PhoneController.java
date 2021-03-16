package br.org.adfego.cadastro.controllers;

import br.org.adfego.cadastro.model.entity.Phone;
import br.org.adfego.cadastro.services.PhoneService;
import br.org.adfego.cadastro.services.exceptions.ConstraintException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping(value = "/phone")
public class PhoneController {

    @Autowired
    private PhoneService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Phone>> findAll() {
        Collection<Phone> collection = service.findAll();
        return ResponseEntity.ok().body(collection);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Phone> find(@PathVariable Long id) {
        Phone obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Phone> insert(@Valid @RequestBody Phone obj, BindingResult br) {
        if (br.hasErrors())
        	throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Phone> update(@Valid @RequestBody Phone obj, BindingResult br) {
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

    @RequestMapping(value = "/associated/{idAssociated}", method = RequestMethod.GET)
    public ResponseEntity<Collection<Phone>> findPhones(@PathVariable Long idAssociated) {
        Collection<Phone> collection = service.findPhones(idAssociated);
        return ResponseEntity.ok().body(collection);
    }

    @RequestMapping(value = "/associated/{idAssociated}&{phoneType}", method = RequestMethod.GET)
    public ResponseEntity<Collection<Phone>> findPhonesType(@PathVariable Long idAssociated , @PathVariable Integer phoneType) {
        Collection<Phone> collection = service.findPhonesType(idAssociated,phoneType);
        return ResponseEntity.ok().body(collection);
    }

}
