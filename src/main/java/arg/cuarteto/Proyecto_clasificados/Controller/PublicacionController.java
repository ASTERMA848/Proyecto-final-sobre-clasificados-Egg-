
package arg.cuarteto.Proyecto_clasificados.Controller;

import arg.cuarteto.Proyecto_clasificados.Entity.Usuario;
import arg.cuarteto.Proyecto_clasificados.Enumeraciones.Oficio;
import arg.cuarteto.Proyecto_clasificados.Enumeraciones.Provincia;
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
    
    @PreAuthorize("hasAnyRole ('ROLE_USUARIO_REGISTRADO')") // autorizacion para 
            //usuarios logeado "con esto podemos hacer que el admin tenga mas privilegios"
      @GetMapping("/publicacionForm") // pagina registro
    public String crear(ModelMap modelo) {
       modelo.addAttribute("oficios", Oficio.values()); //paso la lista de oficios
       //para que se muestre en una lista en el html
       
       modelo.addAttribute("prvincias", Provincia.values()); //paso las provincias
       //para ponerlas en el html en forma de lista
        return "formularioClasificados.html";
    }
    
    @PostMapping("/cargarPublicacionFrom") // metodo registrar para la pagina registro,
            //carga en la base de datos lo solicitado
    public String crearPublicacion(ModelMap modelo,MultipartFile archivo, 
         @RequestParam (required = false) String titulo,
         @RequestParam (required = false) int precio,
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
