package arg.cuarteto.Proyecto_clasificados.Controller;

import arg.cuarteto.Proyecto_clasificados.Entity.Photo;
import arg.cuarteto.Proyecto_clasificados.ErrorService.ErrorService;
import arg.cuarteto.Proyecto_clasificados.Repository.PhotoRepository;
import arg.cuarteto.Proyecto_clasificados.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/foto")
public class FotoControlador {

    @Autowired
    private UsuarioService usuarioServicio;
    
    
    @Autowired
    private PhotoRepository repositorioFoto ;

    @GetMapping("/usuario/{id}")
    public ResponseEntity<byte[]> fotoUsuario(@PathVariable String id) throws ErrorService {
        try {
            
       Photo foto = repositorioFoto.searchPhoto(id);
         
            if (foto == null) {
                throw new ErrorService("El Usuario no tiene foto asignada");
            }

            byte[] fotoByte = foto.getContent();// saco la foto

            HttpHeaders headers = new HttpHeaders();//para indicar que es una foto
            headers.setContentType(MediaType.IMAGE_JPEG);
            return new ResponseEntity<>(fotoByte, headers, HttpStatus.OK);//como devuelvo  

        } catch (ErrorService e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }

}
