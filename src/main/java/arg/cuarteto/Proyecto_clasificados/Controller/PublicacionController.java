
package arg.cuarteto.Proyecto_clasificados.Controller;

import arg.cuarteto.Proyecto_clasificados.Entity.Usuario;
import arg.cuarteto.Proyecto_clasificados.ErrorService.ErrorService;
import arg.cuarteto.Proyecto_clasificados.Service.PublicacionService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Nnahu
 */
@Controller
public class PublicacionController {
    
    @Autowired
    private PublicacionService publicacionService;
    
    
      @GetMapping("/publicacionForm") // pagina registro
    public String crear() {
        return "formularioClasificados.html";
    }
    
    @PostMapping("/cargarPublicacionFrom") // metodo registrar para la pagina registro, carga en la base de datos lo solicitado
    public String crearPublicacion(ModelMap modelo,MultipartFile archivo, @RequestParam (required = false) String titulo, @RequestParam (required = false) int precio,
         @RequestParam (required = false) String localidad, @RequestParam (required = false) String descripcion,
         @RequestParam (required = false) String oficio, @RequestParam (required = false) Date fechaAltabaja, @RequestParam (required = false) Usuario usuario) {        
        try {                 
            publicacionService.crearPublicacion(archivo, titulo, precio, localidad, descripcion, oficio, fechaAltabaja, usuario); 
        } catch (ErrorService ex) { // <p th:if="${Error != null}" th:text="${Error}" style=color:red;></p>   
                modelo.put("Error", ex.getMessage()); //estos msj estan enlazados en validation usuarioService
                modelo.put("Foto:", archivo);
                modelo.put("titulo:", titulo);
                modelo.put("precio:", precio);
                modelo.put("localida:", localidad);
                modelo.put("descripcion:", descripcion);
                modelo.put("oficio:", oficio);
                modelo.put("Usuario",usuario); 
                    return "formularioClasificados.html";
        } 
            modelo.put("titulo", "Bienvenido a PostSolutions"); // <h2 class="display-4" th:text="${titulo}"></h2> enlazado ala vista exito - msj que se ve una vez bien registrado el usuario
            modelo.put("descripcion", "Tu usuario fue registrado satisfactoriamente"); // <p th:text="${descripcion}"></p>     
            return "index.html";        
    }
}
