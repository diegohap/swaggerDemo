package com.vivero.controller;

import com.vivero.entity.Cliente;
import com.vivero.entity.dto.ClienteDto;
import com.vivero.service.ClienteService;
import com.vivero.service.ProvinciaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
@Slf4j
public class ClienteController {

    private final ClienteService clienteService;
    private final ProvinciaService provinciaService;

    @Autowired
    private ClienteController(ClienteService clienteService,
                              ProvinciaService provinciaService){
        this.clienteService = clienteService;
        this.provinciaService = provinciaService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/", produces = "application/json")
    public ResponseEntity<List<Cliente>> getAll(){
        return ResponseEntity.ok(clienteService.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = "application/json")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        Optional<Cliente> oCliente = clienteService.findById(id);
        if (oCliente.isPresent())
            return ResponseEntity.ok(oCliente.get());
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/", produces = "application/json")
    public ResponseEntity<?> createCliente(@RequestBody ClienteDto clienteDto){
        if(provinciaService.findById(clienteDto.getId_provincia()).isEmpty()){
            log.warn("provincia no encontrada");
            return ResponseEntity.badRequest().body("provincia id=" + clienteDto.getId_provincia() + " no encontrada ");
        }
        return ResponseEntity.ok(clienteService.save(mapToCliente(clienteDto)));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}/id", produces = "application/json")
    public ResponseEntity<?> updateCliente(@PathVariable Integer id, @RequestBody ClienteDto clienteDto){
        if(clienteService.findById(id).isEmpty()){
            log.warn("cliente no encontrada");
            return ResponseEntity.badRequest().body("cliente id=" + id + " no encontrada ");
        }
        if(provinciaService.findById(clienteDto.getId_provincia()).isEmpty()){
            log.warn("provincia no encontrada");
            return ResponseEntity.badRequest().body("provincia id=" + clienteDto.getId_provincia() + " no encontrada ");
        }
        Cliente cliente = mapToCliente(clienteDto);
        cliente.setId(id);
        return ResponseEntity.ok(clienteService.save(cliente));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public ResponseEntity<?> deleteClienteById(@PathVariable Integer id){
        clienteService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    private Cliente mapToCliente(ClienteDto clienteDto){
        return Cliente.builder()
                .nombre(clienteDto.getNombre())
                .apellido(clienteDto.getApellido())
                .provincia(provinciaService.findById(clienteDto.getId_provincia()).get())
                .ciudad(clienteDto.getCiudad())
                .barrio(clienteDto.getBarrio())
                .calle(clienteDto.getCalle())
                .telefono(clienteDto.getTelefono())
                .build();
    }
}
