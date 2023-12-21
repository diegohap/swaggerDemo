package com.vivero.service;

import com.vivero.entity.Provincia;
import com.vivero.repository.ProvinciaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProvinciaService extends GenericService<Provincia, Integer>{

    public ProvinciaService(ProvinciaRepository repository){
        super(repository);
    }
}
