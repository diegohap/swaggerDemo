package com.vivero.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_cliente", nullable = false)
    @JsonIgnore
    private Integer id;
    @Column(name = "apellido", nullable = false)
    private String apellido;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "ciudad", nullable = false)
    private String ciudad;
    @Column(name = "barrio", nullable = false)
    private String barrio;
    @Column(name = "calle", nullable = false)
    private String calle;
    @Column(name = "telefono", nullable = false)
    private String telefono;

    @ManyToOne
    private Provincia provincia;


//    @ManyToOne
//    private Barrio barrio;


//    @OneToOne(mappedBy = "cliente")
//    private Barrio barrio;
//
//    @OneToOne(mappedBy = "cliente")
//    private CondicionIva condicionIva;
//
//    @OneToOne(mappedBy = "cliente")
//    private Localidad localidad;
//
//    @OneToOne(mappedBy = "cliente")
//    private Provincia provincia;


}
