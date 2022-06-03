/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arg.cuarteto.Proyecto_clasificados.Controller;

import arg.cuarteto.Proyecto_clasificados.Enumeraciones.Idiomas;
import arg.cuarteto.Proyecto_clasificados.Enumeraciones.Nacionalidad;
import arg.cuarteto.Proyecto_clasificados.Enumeraciones.Nivel;
import arg.cuarteto.Proyecto_clasificados.Enumeraciones.Oficio;
import arg.cuarteto.Proyecto_clasificados.Enumeraciones.Provincia;
import arg.cuarteto.Proyecto_clasificados.Enumeraciones.Remoto;
import arg.cuarteto.Proyecto_clasificados.Enumeraciones.estadoCivil;
import arg.cuarteto.Proyecto_clasificados.Service.FormUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Nnahu
 */
@Controller
@RequestMapping("/")
public class FormUsuarioController {
    
    @Autowired
    private FormUsuarioService FormusuarioService;
    
    @GetMapping("/Formulario-Usuario") 
    public String exito(ModelMap modelo) {
        modelo.addAttribute("Idiomas", Idiomas.values());
        modelo.addAttribute("Nacionalidad", Nacionalidad.values());
        modelo.addAttribute("Nivel", Nivel.values());
        modelo.addAttribute("Oficios", Oficio.values());
        modelo.addAttribute("Provincia", Provincia.values());
        modelo.addAttribute("Remoto", Remoto.values());
        modelo.addAttribute("EstadoCivil", estadoCivil.values());
        return "exito.html"; // falta vista html
    }
    
    @PostMapping("/Cargar-Form-usuario") // metodo registrar para la pagina registro,
            //carga en la base de datos lo solicitado
    public String crearPublicacion(ModelMap modelo,
         MultipartFile archivo, 
         @RequestParam (required = false) String nombre,
         @RequestParam (required = false) String apellido,
         @RequestParam (required = false) String descripcion,
         @RequestParam (required = false) Oficio oficio,
         @RequestParam (required = false) Date fechaAltabaja,
         @RequestParam (required = false) String idUsuario,
         @RequestParam (required = false) Provincia provincia) {        
        try {   
            
            publicacionService.crearPublicacion(archivo, idUsuario, titulo, precio, 
                    descripcion, oficio, fechaAltabaja, provincia); 
        } catch (ErrorService ex) { // <p th:if="${Error != null}" th:text="${Error}" style=color:red;></p>   
                modelo.put("Error", ex.getMessage()); //estos msj estan enlazados en validation usuarioService
                modelo.put("Foto:", archivo);
                modelo.put("titulo:", titulo);
                modelo.put("precio:", precio);
                modelo.put("descripcion:", descripcion);
                modelo.put("oficio:", oficio);
                modelo.put("usuario",idUsuario); 
                modelo.put("provincia", provincia);
               
                return "formularioClasificados.html";
        } 
           
            return "index.html";        
    }
}
