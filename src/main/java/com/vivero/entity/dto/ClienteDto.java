package com.vivero.entity.dto;

import com.vivero.entity.Provincia;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ClienteDto {
    private String apellido;
    private String nombre;
    private Integer id_provincia;
    private String ciudad;
    private String barrio;
    private String calle;
    private String telefono;
}