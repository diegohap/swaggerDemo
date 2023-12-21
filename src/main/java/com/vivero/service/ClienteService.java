package com.vivero.service;

import com.vivero.entity.Cliente;
import com.vivero.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService extends GenericService<Cliente, Integer>{

    public ClienteService(ClienteRepository clienteRepository){
        super(clienteRepository);
    }
}