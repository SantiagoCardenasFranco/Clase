package com.uco.myproject.dominio.servicio;

import com.uco.myproject.dominio.modelo.Persona;
import com.uco.myproject.dominio.puerto.RepositorioPersona;
import org.springframework.stereotype.Service;

@Service
public class ServicioEliminarPersona {

    private static final String MENSAJE_NO_EXISTE = "La persona que intenta elminar no está en el repositorio";

    private final RepositorioPersona repositorioPersona;

    public ServicioEliminarPersona(RepositorioPersona repositorioPersona){
        this.repositorioPersona = repositorioPersona;
    }

    public Long ejecutar(Long id) {
        //if(this.repositorioPersona.existe(persona)){
            return this.repositorioPersona.eliminar(id);
        /*}else
        {
            throw new IllegalStateException(MENSAJE_NO_EXISTE);
        }*/
    }
}
