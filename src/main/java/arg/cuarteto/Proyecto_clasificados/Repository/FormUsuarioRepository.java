/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arg.cuarteto.Proyecto_clasificados.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nnahu
 */
@Repository
public interface FormUsuarioRepository extends JpaRepository<FormUsuarioRepository, String> {
    
     @Query("SELECT f FROM FormUsuario f WHERE f.id = :id") // buscar por id
    public FormUsuarioRepository buscarPorId(@Param("id") String id);
}
