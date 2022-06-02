
package arg.cuarteto.Proyecto_clasificados.Entity;

import arg.cuarteto.Proyecto_clasificados.Enumeraciones.Provincia;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
    @Enumerated(EnumType.STRING)
    private String anioInicio; // hacer enum 
    @Enumerated(EnumType.STRING)
    private String anioFin; // hacer enum 
    private String descripcion; 
    @Enumerated(EnumType.STRING)
    private String instituciones; //hacer enum 
    private Provincia provinciaEducacion; 
    
    //IDIOMAS
    @Enumerated(EnumType.STRING)
    private String idiomas; // hacer enum
    @Enumerated(EnumType.STRING)
    private String nivel; // hacer enum
    @Enumerated(EnumType.STRING)
    private String porcentaje; //hacer enum
    
    //EXPERIENCIA LABORAL
    private String trabajo;
    private String puesto;
    @Enumerated(EnumType.STRING)
    private boolean estado; // hacer enum
    private String anioInicio2;
    private String anioFin2;
    private String descripcion2;
    @Enumerated(EnumType.STRING)
    private String remoto ; // hacer enum
    
   //FUTURAS COSAS A AGREGAR ...

    public FormUsuario() {
    }

    public FormUsuario(String nombre, String apellido, String oficio, String edad,
            String nacionalidad, Provincia provincia, String direccion, String telefono,
            String instagram, String facebook, String linkedin, String miweb, String educacion, 
            String anioInicio, String anioFin, String descripcion, String instituciones,
            Provincia provinciaEducacion, String idiomas, String nivel, String porcentaje,
            String trabajo, String puesto, boolean estado, String anioInicio2, String anioFin2,
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
        this.porcentaje = porcentaje;
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

    public String getAnioInicio() {
        return anioInicio;
    }

    public void setAnioInicio(String anioInicio) {
        this.anioInicio = anioInicio;
    }

    public String getAnioFin() {
        return anioFin;
    }

    public void setAnioFin(String anioFin) {
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

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getAnioInicio2() {
        return anioInicio2;
    }

    public void setAnioInicio2(String anioInicio2) {
        this.anioInicio2 = anioInicio2;
    }

    public String getAnioFin2() {
        return anioFin2;
    }

    public void setAnioFin2(String anioFin2) {
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
        return "FormUsuario{" + "nombre=" + nombre + ", apellido=" + apellido + ", oficio=" + oficio + ", edad=" + edad + ", nacionalidad=" + nacionalidad + ", provincia=" + provincia + ", direccion=" + direccion + ", telefono=" + telefono + ", instagram=" + instagram + ", facebook=" + facebook + ", linkedin=" + linkedin + ", miweb=" + miweb + ", educacion=" + educacion + ", anioInicio=" + anioInicio + ", anioFin=" + anioFin + ", descripcion=" + descripcion + ", instituciones=" + instituciones + ", provinciaEducacion=" + provinciaEducacion + ", idiomas=" + idiomas + ", nivel=" + nivel + ", porcentaje=" + porcentaje + ", trabajo=" + trabajo + ", puesto=" + puesto + ", estado=" + estado + ", anioInicio2=" + anioInicio2 + ", anioFin2=" + anioFin2 + ", descripcion2=" + descripcion2 + ", remoto=" + remoto + '}';
    }
    
    
    
}
