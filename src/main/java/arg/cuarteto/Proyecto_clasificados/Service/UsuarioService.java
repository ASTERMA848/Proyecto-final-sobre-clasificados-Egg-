package arg.cuarteto.Proyecto_clasificados.Service;

import arg.cuarteto.Proyecto_clasificados.Entity.Photo;
import arg.cuarteto.Proyecto_clasificados.Repository.UsuarioRepository;
import arg.cuarteto.Proyecto_clasificados.Entity.Usuario;
import arg.cuarteto.Proyecto_clasificados.Enumeraciones.Provincia;
import arg.cuarteto.Proyecto_clasificados.ErrorService.ErrorService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;


@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PhotoService fotoService;

    @Transactional(propagation = Propagation.NESTED)
    public void register(MultipartFile archivo, String nombre, String apellido, String email, String clave, Provincia provincia) throws ErrorService {//este metodo registra al usuario en la base de datos
        validation(nombre, apellido, email, clave,provincia);// implementamos validation para no andar haciendo if en cada transaccion
        //llamamos a usuario entidad donde seteamos los atributos
        Usuario usuario = new Usuario();
        Photo foto = fotoService.guardar(archivo); // guarda la foto en la base de dato
        usuario.setFoto(foto); // setea la foto
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setProvincia(provincia);
        usuario.setEmail(email);
        //encriptamos la clave para que se vea con un hash 
        String encriptada = new BCryptPasswordEncoder().encode(clave);
        usuario.setClave(encriptada);
        usuario.setAlta(new Date());
        //guardamos los datos en un nuevo objeto usuario    
        usuarioRepository.save(usuario);
    }

    @Transactional(propagation = Propagation.NESTED)
    public void modificar(MultipartFile archivo, String id, String nombre, String apellido, String email, String clave, Provincia provincia) throws ErrorService {// este metodo modifica al usuario en la base de datos
        validation(nombre, apellido, email, clave,provincia);

        //jpa nos devuelve un opcional usuario
        Optional<Usuario> respuesta = usuarioRepository.findById(id);
        if (respuesta.isPresent()) {
            Usuario usuario = respuesta.get();
            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            usuario.setEmail(email);
            usuario.setClave(clave);
            usuario.setProvincia(provincia);

            String idFoto = null; // crea una variable para guardar el idfoto en el servicio foto
            if (usuario.getFoto() != null) { //if vinculaa la foto que no este nula
                idFoto = usuario.getFoto().getid(); // vincula esa foto con el id del usuario
            }

            Photo foto = fotoService.editar(idFoto, archivo); // edita la foto con el metodo servicio foto
            usuario.setFoto(foto); //setea la foto a editar

            usuarioRepository.save(usuario);
        } else {
            throw new ErrorService("No se encontro el usuario solicitado");
        }
    }

    public Usuario buscarPorId(String id) { // todavia no le doy uso
        return usuarioRepository.buscarPorId(id);
    }

    private void validation(String nombre, String apellido, String email, String clave, Provincia provincia) throws ErrorService {// validation para no andar haciendo if anidados en cada transaccion

        if (nombre == null || nombre.isEmpty()) {//pd: esto enlaza al msj de ErrorService para controlador, que luego se ve reflejado en la vista
            throw new ErrorService("El nombre del usuario no puede ser nulo.");
        }
        if (apellido == null || apellido.isEmpty()) {
            throw new ErrorService("El apellido del usuario no puede ser nulo.");
        }
        if (email == null || email.isEmpty()) {
            throw new ErrorService("El email del usuario no puede ser nulo.");
        }
        if (clave == null || clave.isEmpty() || clave.length() <= 3) {
            throw new ErrorService("La clave del usuario no puede ser nulo y debe tener mas de tres digitos.");
        }
        
        if (provincia==null ){
            throw new ErrorService("Debe ingresar una provincia valida");
        }

    }

    @Transactional(propagation = Propagation.NESTED)
    public void deshabilitar(String id) throws ErrorService {

        Optional<Usuario> respuesta = usuarioRepository.findById(id);
        if (respuesta.isPresent()) {
            Usuario usuario = respuesta.get();
            usuario.setBaja(new Date());

            usuarioRepository.save(usuario);
        } else {
            throw new ErrorService("No se encontro el usuario solicitado");
        }
    }

    @Transactional(propagation = Propagation.NESTED)
    public void habilitar(String id) throws ErrorService {

        Optional<Usuario> respuesta = usuarioRepository.findById(id);
        if (respuesta.isPresent()) {
            Usuario usuario = respuesta.get();
            usuario.setBaja(null);

            usuarioRepository.save(usuario);
        } else {
            throw new ErrorService("No se encontro el usuario solicitado");
        }
    }

    @Override // usuario quiere autentificarse en plataforma, les da esos permisos
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.buscarPorEmail(email);
        if (usuario != null) {
            List<GrantedAuthority> permisos = new ArrayList<>();
//Esto son roles que se le agregar al usuario. 
            GrantedAuthority p1 = new SimpleGrantedAuthority("ROLE_USUARIO_REGISTRADO");
            permisos.add(p1);
//Esto me permite guardar el OBJETO USUARIO LOG, para luego ser utilizado
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpSession session = attr.getRequest().getSession();
            session.setAttribute("usuariosession", usuario);
            User user = new User(usuario.getEmail(), usuario.getClave(), permisos);
            return user;
        } else {
            return null;
        }
    }
}
