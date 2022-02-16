package com.uco.myproject.infraestructura.controlador;

import com.uco.myproject.aplicacion.servicio.ServicioAplicacionEditarPersona;
import com.uco.myproject.aplicacion.servicio.ServicioAplicacionEliminarPersona;
import com.uco.myproject.aplicacion.servicio.ServicioAplicacionGuardarPersona;
import com.uco.myproject.aplicacion.servicio.ServicioAplicacionListarPersonas;
import com.uco.myproject.aplicacion.dto.DtoPersona;
import com.uco.myproject.aplicacion.dto.DtoRespuesta;
import com.uco.myproject.dominio.modelo.Persona;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class ControladorPersona {


    private final ServicioAplicacionListarPersonas servicioListarPersonas;
    private final ServicioAplicacionGuardarPersona servicioGuardarPersona;
    private final ServicioAplicacionEliminarPersona servicioEliminarPersona;
    private final ServicioAplicacionEditarPersona servicioEditarPersona;

    public ControladorPersona(ServicioAplicacionListarPersonas servicioListarPersonas,
                              ServicioAplicacionGuardarPersona servicioGuardarPersona,
                              ServicioAplicacionEliminarPersona servicioEliminarPersona,
                              ServicioAplicacionEditarPersona servicioEditarPersona) {
        this.servicioListarPersonas = servicioListarPersonas;
        this.servicioGuardarPersona = servicioGuardarPersona;
        this.servicioEliminarPersona = servicioEliminarPersona;
        this.servicioEditarPersona = servicioEditarPersona;
    }

    @GetMapping
    public List<Persona> listar() {
        return servicioListarPersonas.ejecutar();
    }

    @PostMapping
    public DtoRespuesta<Long> crear(@RequestBody DtoPersona dto) {
        return this.servicioGuardarPersona.ejecutar(dto);
    }

    @DeleteMapping(value = "/{id}")
    public DtoRespuesta<Long> eliminar(@PathVariable Long id) {
        return this.servicioEliminarPersona.ejecutar(id);
    }

    @PutMapping(value = "/{id}")
    public DtoRespuesta<Boolean> actualizar(@PathVariable Long id, @RequestBody DtoPersona dto){
        return this.servicioEditarPersona.ejecutar(id,dto);
    }
}
