package com.uco.myproject.dominio.servicio;

import com.uco.myproject.dominio.modelo.Persona;
import com.uco.myproject.dominio.puerto.RepositorioPersona;
import org.springframework.stereotype.Service;

@Service
public class ServicioActualizarPersona {

    private static final String PERSONA_ACTUALIZADA = "NO SE ENCONTRÓ A LA PERSONA O NO EXISTE";

    private final RepositorioPersona repositorioPersona;

    public ServicioActualizarPersona(RepositorioPersona repositorioPersona)
    {
        this.repositorioPersona = repositorioPersona;
    }

    public Boolean ejecutar(Long id, Persona persona){
        //if(this.repositorioPersona.existe(persona)){
            return this.repositorioPersona.actualizar(id, persona);
       /* }else
        {
            throw new IllegalStateException(PERSONA_ACTUALIZADA);
        }*/
    }
}
