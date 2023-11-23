package com.swaggerDemo.controller;

import com.swaggerDemo.entity.Calle;
import com.swaggerDemo.repository.CalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/calle")
public class CalleController {

    @Autowired
    private CalleRepository calleRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/getAll", produces = "application/json")
    public ResponseEntity<List<Calle>> getAll(){
        return ResponseEntity.ok(calleRepository.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ping")
    public String ping(){
        return "ping";
    }

}
