/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arg.cuarteto.Proyecto_clasificados.Service;

import arg.cuarteto.Proyecto_clasificados.Entity.FormUsuario;
import arg.cuarteto.Proyecto_clasificados.Enumeraciones.Idiomas;
import arg.cuarteto.Proyecto_clasificados.Enumeraciones.Nacionalidad;
import arg.cuarteto.Proyecto_clasificados.Enumeraciones.Nivel;
import arg.cuarteto.Proyecto_clasificados.Enumeraciones.Oficio;
import arg.cuarteto.Proyecto_clasificados.Enumeraciones.Provincia;
import arg.cuarteto.Proyecto_clasificados.Enumeraciones.Remoto;
import arg.cuarteto.Proyecto_clasificados.ErrorService.ErrorService;
import arg.cuarteto.Proyecto_clasificados.Repository.FormUsuarioRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nnahu
 */
@Service
public class FormUsuarioService {

    @Autowired
    private FormUsuarioRepository FormUsuarioRepository;

    @Autowired
    private PhotoService fotoService;

    @Autowired
    private EnvioMail envioDeMail;

    @Transactional(propagation = Propagation.NESTED)
    public void guardarForm(String nombre, String apellido, String email, Oficio oficio, String edad, Nacionalidad nacionalidad,
            Provincia provincia, String direccion, String telefono, String instagram, String facebook, String linkedin, String miweb,
            String educacion, Date anioInicio, Date anioFin, String descripcion, String instituciones, Provincia provinciaEducacion,
            Idiomas idiomas, Nivel nivel, String trabajo, String puesto, Boolean estado, Date anioInicio2, Date anioFin2,
            String descripcion2, Remoto remoto ) throws ErrorService {//este metodo registra al usuario en la base de datos
        
        FormUsuario formUsuario = new FormUsuario();
        formUsuario.setNombre(nombre);
        formUsuario.setApellido(apellido);       
        formUsuario.setOficio(oficio);
        formUsuario.setEdad(edad);
        formUsuario.setNacionalidad(nacionalidad);
        formUsuario.setProvincia(provincia);
        formUsuario.setDireccion(direccion);
        formUsuario.setTelefono(telefono);
        formUsuario.setInstagram(instagram);
        formUsuario.setFacebook(facebook);
        formUsuario.setLinkedin(linkedin);
        formUsuario.setMiweb(miweb);
        formUsuario.setEducacion(educacion);
        formUsuario.setAnioInicio(anioInicio);
        formUsuario.setAnioFin(anioFin);
        formUsuario.setDescripcion(descripcion);
        formUsuario.setInstituciones(instituciones);
        formUsuario.setProvinciaEducacion(provinciaEducacion);
        formUsuario.setIdiomas(idiomas);
        formUsuario.setNivel(nivel);
        formUsuario.setTrabajo(trabajo);
        formUsuario.setPuesto(puesto);
        formUsuario.setEstado(estado);
        formUsuario.setAnioInicio2(anioInicio2);
        formUsuario.setAnioFin2(anioFin2);
        formUsuario.setDescripcion2(descripcion2);
        formUsuario.setRemoto(remoto);
        

       

        envioDeMail.enviarMail(email, "Bienvenido " + nombre + " a Post Solutions ",
                "Su registro a sido confirmado con exito");

        

        FormUsuarioRepository.save(formUsuario);
    }
}
