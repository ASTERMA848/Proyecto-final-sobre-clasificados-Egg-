
package arg.cuarteto.Proyecto_clasificados.Service;

import arg.cuarteto.Proyecto_clasificados.Entity.Publicacion;

import arg.cuarteto.Proyecto_clasificados.ErrorService.ErrorService;
import arg.cuarteto.Proyecto_clasificados.Repository.PublicacionRepository;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PublicacionService {
     @Autowired
    private PublicacionRepository publicacionRepository;
    @Transactional(propagation = Propagation.NESTED)
     public void crearPublicacion(String titulo, int precio, String localidad, String descripcion, String oficio, Date fechaAltabaja )throws ErrorService{
        validar(titulo,precio,localidad,descripcion,oficio);
        Publicacion publicacion = new Publicacion();
        publicacion.setActivo(Boolean.TRUE);
        publicacion.setTitulo(titulo);
       
        publicacion.setDescripcion(descripcion);
        publicacion.setLocalidad(localidad);
        publicacion.setOficio(oficio);
        publicacion.setFechaAltabaja(new Date());
        publicacionRepository.save(publicacion);      
    }
    @Transactional(propagation = Propagation.NESTED)
     public void modificarPublicacion(String id,String titulo, int precio, String localidad, String descripcion, String oficio, Date fechaAltabaja )throws ErrorService{
	validar(titulo,precio,localidad,descripcion,oficio);
	Optional<Publicacion> respuesta = publicacionRepository.findById(id);
        if(respuesta.isPresent()){
         	Publicacion publicacion = respuesta.get(); 
	    	publicacion.setActivo(Boolean.TRUE);
        	publicacion.setTitulo(titulo);
        	publicacion.setDescripcion(descripcion);
        	publicacion.setLocalidad(localidad);
        	publicacion.setOficio(oficio);
        	publicacion.setFechaAltabaja(new Date());        
        	publicacionRepository.save(publicacion);	       
        }
    }
    @Transactional(propagation = Propagation.NESTED)
    public void publicacionDeshabilitar(String id) throws ErrorService{
        Optional<Publicacion> respuesta = publicacionRepository.findById(id);
        if(respuesta.isPresent()){
            Publicacion publicacion = respuesta.get();
            publicacion.setFechaAltabaja(new Date());
            publicacionRepository.save(publicacion);   
        }else {
            throw new ErrorService("El ID consultado no se encuentra en la base de datos.");
        }                             
    }
    @Transactional(propagation = Propagation.NESTED)
    public void publicacionHabilitar(String id) throws ErrorService{
        Optional<Publicacion> respuesta = publicacionRepository.findById(id);
        if(respuesta.isPresent()){
            Publicacion publicacion = respuesta.get();
            publicacion.setFechaAltabaja(null);
            publicacionRepository.save(publicacion);   
        }else {
            throw new ErrorService("El ID consultado no se encuentra en la base de datos.");
        }
    }
public void validar(String titulo, int precio, String localidad, String descripcion, String oficio) throws ErrorService{
        if (titulo == null || titulo.isEmpty()){
            throw new ErrorService("El nombre no puede ser nulo ni puede estar vacio");
        }
        if (precio <= 0 ){
            throw new ErrorService("El precio tiene que ser mayor a 0.");
        }
        if (descripcion == null || descripcion.isEmpty()){
            throw new ErrorService("La descripcion no puede ser nulo ni puede estar vacio");
        }
        if(localidad == null){
            throw new ErrorService("Debe poseer una localidad identificada");
        }
        if(oficio == null){
            throw new ErrorService("Debe poseer un oficio identificado");
        }
    }

}
