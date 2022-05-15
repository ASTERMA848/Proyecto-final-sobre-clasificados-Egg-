/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arg.cuarteto.Proyecto_clasificados.Controller;

import arg.cuarteto.Proyecto_clasificados.ErrorService.ErrorService;
import arg.cuarteto.Proyecto_clasificados.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
public class UsuarioController {
@Autowired
    private UsuarioService usuarioService;
       
@PreAuthorize("hasAnyRole ('ROLE_USUARIO_REGISTRADO')") // autorizacion para usuarios logeado "con esto podemos hacer que el admin tenga mas privilegios"
@GetMapping("/main") // paginaa main
    public String index() {
        return "index.html";
    }
    
@GetMapping("/exito") // pagina msj de exito del usuario registrado
    public String exito() {
        return "exito.html";
    }
    
@GetMapping ("/logear") // toma como enlace al securitySettings donde valida el inicio de sesion y redirecciona al main
    public String login (@RequestParam (required = false) String error, @RequestParam (required = false) String logout, ModelMap model) {// con ResquestParam (required = false) hacemos que no sea obligatorio el atributo solicitado
        if (error != null) {
        model.put("error", "Email de usuario o clave incorrectos."); // <p th:if="${error !=null}" th:text ="${error}" style="color:red"></p>
        }
            if(logout != null) {
        model.put("logout", "Ha salido correctamente de la plataforma."); // <p th:if="${logout !=null}" th:text ="${logout}" style="color:green"></p>
            }
                return "logg.html";
}

@GetMapping("/registro") // pagina registro
    public String registro() {
        return "registro.html";
    } 
    
    //registrar, envia datos del formlario a base datos, form th:action="@{/registrar}" method="POST"
    //RequestParam es para indicar que son necesarios para guardar y viajen  en metodo post
    //ModelMap guarda todo lo que neceistamos guardar temporariamente interfaz de usuario
@PostMapping("/registrar") // metodo registrar para la pagina registro, carga en la base de datos lo solicitado
    public String register(ModelMap modelo, MultipartFile archivo, @RequestParam String nombre, @RequestParam String apellido,
            @RequestParam String email, @RequestParam String clave) {        
        try {                 
            usuarioService.register(archivo, nombre, apellido, email, clave);
            
                } catch (ErrorService ex) { // <p th:if="${Error != null}" th:text="${Error}" style=color:red;></p>   
                modelo.put("Error", ex.getMessage()); //estos msj estan enlazados en validation usuarioService
                modelo.put("nombre:", nombre);
                modelo.put("apellido:", apellido);
                modelo.put("clave:", clave);
                    return "registro.html";
        } 
            modelo.put("titulo", "Bienvenido a PostSolutions"); // <h2 class="display-4" th:text="${titulo}"></h2> enlazado ala vista exito - msj que se ve una vez bien registrado el usuario
            modelo.put("descripcion", "Tu usuario fue registrado satisfactoriamente"); // <p th:text="${descripcion}"></p>     
            return "exito.html";        
    }
}