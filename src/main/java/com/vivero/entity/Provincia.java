package com.vivero.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "provincias")
public class Provincia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_provincia", nullable = false)
    private Integer id;
    @Column(name = "nombre", nullable = false)
    private String nombre;

//    @OneToOne
//    @JoinColumn(name = "fk_cod_cliente")
//    private Cliente cliente;
}
