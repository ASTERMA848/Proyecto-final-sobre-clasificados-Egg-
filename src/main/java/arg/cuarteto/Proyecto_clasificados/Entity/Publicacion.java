
package arg.cuarteto.Proyecto_clasificados.Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Publicacion implements Serializable {
   
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")

    private String id;
    
    @OneToMany
    private Usuario usuario;
    //private Photo photo;
    private String titulo;
    private int precio;
    private String localidad;
    private String oficio;
    private String descripcion;
    private Boolean activo;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAltabaja;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Date getFechaAltabaja() {
        return fechaAltabaja;
    }

    public void setFechaAltabaja(Date fechaAltabaja) {
        this.fechaAltabaja = fechaAltabaja;
    }

    @Override
    public String toString() {
        return "Publicacion{" + "id=" + id + ", usuario=" + usuario + ", titulo=" + titulo + ", precio=" + precio + ", localidad=" + localidad + ", oficio=" + oficio + ", descripcion=" + descripcion + ", activo=" + activo + ", fechaAltabaja=" + fechaAltabaja + '}';
    }
 
}
