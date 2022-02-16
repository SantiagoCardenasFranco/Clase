package com.uco.myproject.aplicacion.servicio;

import com.uco.myproject.aplicacion.dto.DtoPersona;
import com.uco.myproject.aplicacion.dto.DtoRespuesta;
import com.uco.myproject.dominio.modelo.Persona;
import com.uco.myproject.dominio.servicio.ServicioActualizarPersona;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEditarPersona {

    private final ServicioActualizarPersona servicioActualizarPersona;

    public ServicioAplicacionEditarPersona(ServicioActualizarPersona servicioActualizarPersona) {
        this.servicioActualizarPersona = servicioActualizarPersona;
    }

    public DtoRespuesta<Boolean> ejecutar(Long id, DtoPersona dto) {
        Persona persona = Persona.of(dto.getNombre(), dto.getApellido());
        return new DtoRespuesta<>(this.servicioActualizarPersona.ejecutar(id,persona));
    }
}
