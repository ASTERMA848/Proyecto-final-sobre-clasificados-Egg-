
package arg.cuarteto.Proyecto_clasificados.Repository;

import arg.cuarteto.Proyecto_clasificados.Entity.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicacionRepository  extends JpaRepository<Publicacion, String> {
    
    //Busca por Titulo
    @Query("SELECT u FROM Publicacion u WHERE u.titulo = :titulo")
    public Publicacion buscarPorTitulo(@Param("titulo") String titulo);
    
    // buscar por id
    @Query("SELECT c FROM Publicacion c WHERE c.id = :id")
    public Publicacion buscarPorId(@Param("id") String id);
    
    //buscar por oficio
    @Query("SELECT f FROM Publicacion f WHERE f.oficio = :oficio")
    public Publicacion buscarporOficio (@Param("oficio") String oficio);
    
    //buscar por localidad
    @Query("SELECT g FROM Publicacion g WHERE g.localidad = :localidad")
    public Publicacion buscarporLocalidad (@Param("localidad") String localidad);

}
