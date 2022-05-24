
package arg.cuarteto.Proyecto_clasificados.Controller;

import arg.cuarteto.Proyecto_clasificados.Entity.Usuario;
import arg.cuarteto.Proyecto_clasificados.ErrorService.ErrorService;
import arg.cuarteto.Proyecto_clasificados.Service.PublicacionService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/")
public class PublicacionController {
    
    @Autowired
    private PublicacionService publicacionService;
    
    @PreAuthorize("hasAnyRole ('ROLE_USUARIO_REGISTRADO')") // autorizacion para usuarios logeado "con esto podemos hacer que el admin tenga mas privilegios"
      @GetMapping("/publicacionForm") // pagina registro
    public String crear() {
        
        return "formularioClasificados.html";
    }
    
    @PostMapping("/cargarPublicacionFrom") // metodo registrar para la pagina registro, carga en la base de datos lo solicitado
    public String crearPublicacion(ModelMap modelo,MultipartFile archivo, @RequestParam (required = false) String titulo, @RequestParam (required = false) int precio,
         @RequestParam (required = false) String localidad, @RequestParam (required = false) String descripcion,
         @RequestParam (required = false) String oficio, @RequestParam (required = false) Date fechaAltabaja, @RequestParam (required = false) String idUsuario) {        
        try {   
            System.out.println(archivo);
            publicacionService.crearPublicacion(archivo, idUsuario, titulo, precio, localidad, descripcion, oficio, fechaAltabaja); 
        } catch (ErrorService ex) { // <p th:if="${Error != null}" th:text="${Error}" style=color:red;></p>   
                modelo.put("Error", ex.getMessage()); //estos msj estan enlazados en validation usuarioService
                modelo.put("Foto:", archivo);
                modelo.put("titulo:", titulo);
                modelo.put("precio:", precio);
                modelo.put("localida:", localidad);
                modelo.put("descripcion:", descripcion);
                modelo.put("oficio:", oficio);
                modelo.put("Usuario",idUsuario); 
                    return "formularioClasificados.html";
        } 
           
            return "index.html";        
    }
}
