package com.vivero.controller;

import com.vivero.entity.Provincia;
import com.vivero.service.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/provincias")
public class ProvinciaController {
    private final ProvinciaService provinciaService;
    @Autowired
    public ProvinciaController(ProvinciaService provinciaService){
        this.provinciaService = provinciaService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/", produces = "application/json")
    public ResponseEntity<List<Provincia>> getAll(){
        return ResponseEntity.ok(provinciaService.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = "application/json")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        Optional<Provincia> oLocalidad = provinciaService.findById(id);
        if (oLocalidad.isPresent())
            return ResponseEntity.ok(oLocalidad.get());
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/", produces = "application/json")
    public ResponseEntity<Provincia> createLocalidad(@RequestBody Provincia provincia){
        return ResponseEntity.ok(provinciaService.save(provincia));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/", produces = "application/json")
    public ResponseEntity<Provincia> updateLocalidad(@RequestBody Provincia provincia){
        return ResponseEntity.ok(provinciaService.save(provincia));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public ResponseEntity<?> deleteLocalidadById(@PathVariable Integer id){
        provinciaService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
