package br.org.adfego.cadastro.controllers;

import br.org.adfego.cadastro.model.entity.DeficiencyAssociated;
import br.org.adfego.cadastro.services.DeficiencyAssociatedService;
import br.org.adfego.cadastro.services.exceptions.ConstraintException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping(value = "/deficiencyAssociated")
public class DeficiencyAssociatedController {

    @Autowired
    private DeficiencyAssociatedService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<DeficiencyAssociated>> findAll() {
        Collection<DeficiencyAssociated> collection = service.findAll();
        return ResponseEntity.ok().body(collection);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<DeficiencyAssociated> find(@PathVariable Long id) {
        DeficiencyAssociated obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<DeficiencyAssociated> insert(@Valid @RequestBody DeficiencyAssociated obj, BindingResult br) {
        if (br.hasErrors())
        	throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<DeficiencyAssociated> update(@Valid @RequestBody DeficiencyAssociated obj, BindingResult br) {
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

    @RequestMapping(value = "/deficiencyAssociated/{idAssociated}", method = RequestMethod.GET)
    public ResponseEntity<Collection<DeficiencyAssociated>> findDeficiencyAssociated(@PathVariable Long idAssociated) {
        Collection<DeficiencyAssociated> collection = service.findDeficiencyAssociated(idAssociated);
        return ResponseEntity.ok().body(collection);
    }

}
