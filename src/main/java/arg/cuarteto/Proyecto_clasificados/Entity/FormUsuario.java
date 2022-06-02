
package arg.cuarteto.Proyecto_clasificados.Entity;

import arg.cuarteto.Proyecto_clasificados.Enumeraciones.Provincia;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class FormUsuario {
    
     //PERSONA
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String nombre;
    private String apellido;
    private String oficio;
    private String edad;
    @Enumerated(EnumType.STRING)
    private String nacionalidad; // hacer enum
    private Provincia provincia; 
    
    //CONTACTO
    private String direccion;
    private String telefono;
    private String instagram;
    private String facebook;
    private String linkedin;
    private String miweb;
    
    //EDUCACION
    private String educacion; 
  
    private Date anioInicio;
    
    private Date anioFin;
    private String descripcion; 
   
    private String instituciones;
    private Provincia provinciaEducacion; 
    
    //IDIOMAS
    @Enumerated(EnumType.STRING)
    private String idiomas; // HACER ENUM
    @Enumerated(EnumType.STRING)
    private String nivel; // HACER ENUM
    
    
    //EXPERIENCIA LABORAL
    private String trabajo;
    private String puesto;
    @Enumerated(EnumType.STRING)
    private String estado; // hacer enum  
    private Date anioInicio2;   
    private Date anioFin2;
    private String descripcion2;
    @Enumerated(EnumType.STRING)
    private String remoto ; // hacer enum
    
   //FUTURAS COSAS A AGREGAR ...

    public FormUsuario() {
    }

    public FormUsuario( String nombre, String apellido, String oficio, String edad,
            String nacionalidad, Provincia provincia, String direccion, String telefono,
            String instagram, String facebook, String linkedin, String miweb, String educacion,
            Date anioInicio, Date anioFin, String descripcion, String instituciones,
            Provincia provinciaEducacion, String idiomas, String nivel, 
            String trabajo, String puesto, String estado, Date anioInicio2, Date anioFin2,
            String descripcion2, String remoto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.oficio = oficio;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
        this.provincia = provincia;
        this.direccion = direccion;
        this.telefono = telefono;
        this.instagram = instagram;
        this.facebook = facebook;
        this.linkedin = linkedin;
        this.miweb = miweb;
        this.educacion = educacion;
        this.anioInicio = anioInicio;
        this.anioFin = anioFin;
        this.descripcion = descripcion;
        this.instituciones = instituciones;
        this.provinciaEducacion = provinciaEducacion;
        this.idiomas = idiomas;
        this.nivel = nivel;
        this.trabajo = trabajo;
        this.puesto = puesto;
        this.estado = estado;
        this.anioInicio2 = anioInicio2;
        this.anioFin2 = anioFin2;
        this.descripcion2 = descripcion2;
        this.remoto = remoto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getMiweb() {
        return miweb;
    }

    public void setMiweb(String miweb) {
        this.miweb = miweb;
    }

    public String getEducacion() {
        return educacion;
    }

    public void setEducacion(String educacion) {
        this.educacion = educacion;
    }

    public Date getAnioInicio() {
        return anioInicio;
    }

    public void setAnioInicio(Date anioInicio) {
        this.anioInicio = anioInicio;
    }

    public Date getAnioFin() {
        return anioFin;
    }

    public void setAnioFin(Date anioFin) {
        this.anioFin = anioFin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getInstituciones() {
        return instituciones;
    }

    public void setInstituciones(String instituciones) {
        this.instituciones = instituciones;
    }

    public Provincia getProvinciaEducacion() {
        return provinciaEducacion;
    }

    public void setProvinciaEducacion(Provincia provinciaEducacion) {
        this.provinciaEducacion = provinciaEducacion;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }


    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String isEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getAnioInicio2() {
        return anioInicio2;
    }

    public void setAnioInicio2(Date anioInicio2) {
        this.anioInicio2 = anioInicio2;
    }

    public Date getAnioFin2() {
        return anioFin2;
    }

    public void setAnioFin2(Date anioFin2) {
        this.anioFin2 = anioFin2;
    }

    public String getDescripcion2() {
        return descripcion2;
    }

    public void setDescripcion2(String descripcion2) {
        this.descripcion2 = descripcion2;
    }

    public String getRemoto() {
        return remoto;
    }

    public void setRemoto(String remoto) {
        this.remoto = remoto;
    }

    @Override
    public String toString() {
        return "FormUsuario{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + 
                apellido + ", oficio=" + oficio + ", edad=" + edad + ", nacionalidad=" +
                nacionalidad + ", provincia=" + provincia + ", direccion="
                + direccion + ", telefono=" + telefono + ", instagram=" + instagram +
                ", facebook=" + facebook + ", linkedin=" + linkedin + ", miweb=" 
                + miweb + ", educacion=" + educacion + ", anioInicio=" + anioInicio +
                ", anioFin=" + anioFin + ", descripcion=" + descripcion + ", instituciones=" +
                instituciones + ", provinciaEducacion=" + provinciaEducacion + ", idiomas=" + idiomas +
                ", nivel=" + nivel + ", trabajo=" + trabajo + 
                ", puesto=" + puesto + ", estado=" + estado + ", anioInicio2=" + anioInicio2 +
                ", anioFin2=" + anioFin2 + ", descripcion2=" + descripcion2 + ", remoto=" + remoto + '}';
    }
  
    
    
    
}
