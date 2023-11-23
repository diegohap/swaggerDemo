package com.swaggerDemo.repository;

import com.swaggerDemo.entity.Calle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalleRepository extends JpaRepository<Calle, Integer> {
}
