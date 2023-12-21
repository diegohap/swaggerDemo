package com.vivero.service;

import com.vivero.exception.ElementNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
public abstract class GenericService<T, ID> {

    // T  -> Entity
    // ID -> ID entity type

    private final String ELEMENT_NOT_FOUND_MESSAGE_ID = "elemento no encontrada ID=";

    protected JpaRepository<T, ID> repository;

    public GenericService(JpaRepository<T, ID> repository){
        this.repository = repository;
    }

    public List<T> findAll(){
        return repository.findAll();
    }

    public Optional<T> findById(ID id){
        Optional<T> oElement = repository.findById(id);
        if(oElement.isPresent())
            return oElement;
        else {
            log.info(ELEMENT_NOT_FOUND_MESSAGE_ID + id);
            //throw new ElementNotFoundException(ELEMENT_NOT_FOUND_MESSAGE_ID + id);
            return Optional.empty();
        }
    }

    @Transactional
    public T save(T element){
        return repository.save(element);
    }

    @Transactional
    public void deleteById(ID id){
        repository.deleteById(id);
    }

}
