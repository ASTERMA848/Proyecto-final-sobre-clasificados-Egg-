package arg.cuarteto.Proyecto_clasificados.Repository;


import arg.cuarteto.Proyecto_clasificados.Entity.Direccion;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionRepositorio extends JpaRepository<Direccion, String> {

    @Query("SELECT a FROM Direccion a WHERE a.id = :PARAMETRO")
    public Direccion buscarPorId(@Param("PARAMETRO") String id);
    
    @Query("SELECT a FROM Direccion a JOIN Usuario u WHERE u.apellido = :apellido")
    public List<Direccion> buscarPorApellido(@Param("apellido") String apellido);
    
    
}
