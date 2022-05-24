
package arg.cuarteto.Proyecto_clasificados.Enumeraciones;
public enum Oficio {
    
    CARPINTERO("CARPINTERO"),
    ELECTRICISTA("ELECTRICISTA"),
    ALBAÑIL("ALBAÑIL"),
    PLOMERO("PLOMERO"),
    PROFESOR("PROFESOR"),
    ARTESANO("ARTESANO"),
    PANADERO("PANADERO"),
    COMERCIANTE("COMERCIANTE"),
    COCINERO("COCINERO"),
    REPOSTERO("REPOSTERO"),
    JARDINERO("JADINERO"),
    GASISTA("GASISTA"),
    ESTALISTA("ESTILISTA"),
    REMISERO("REMISERO"),
    OTRO("OTRO");


    private String nombre;

    private Oficio(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }
}
