package com.swaggerDemo.entity;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "calles")
public class Calle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_calle", nullable = false)
    private Integer id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
}
