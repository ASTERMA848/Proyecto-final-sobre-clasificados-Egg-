
package arg.cuarteto.Proyecto_clasificados.Enumeraciones;
public enum Provincia {
    
    CATAMARCA("CATAMARCA"),
    CIUDAD_AUTONOMA_DE_BUENOS_AIRES("CIUDAD AUTONOMA DE BUENOS AIRES"),
    CORDOBA("CORDOBA"),
    CORRIENTES("CORRIENTES"),
    CHACO("CHACO"),
    CHUBUT("CHUBUT"),
    ENTRE_RIOS("ENTRE RIOS"),
    FORMOSA("FORMOSA"),
    JUJUY("JUJUY"),
    LA_PAMPA("LA PAMPA"),
    LA_RIOJA("LA RIOJA"),
    MENDOZA("MENDOZA"),
    MISIONES("MISIONES"),
    NEUQUEN("NEUQUEN"),
    RIO_NEGRO("RIO NEGRO"),
    SALTA("SALTA"),
    SAN_JUAN("SAN JUAN"),
    SAN_LUIS("SAN LUIS"),
    SANTA_CRUZ("SANTA CRUZ"),
    SANTA_FE("SANTA FE"),
    SANTIAGO_DEL_ESTERO("SANTIAGO DEL ESTERO"),
    TIERRA_DEL_FUEGO("TIERRA DEL FUEGO"),
    TUCUMAN("TUCUMAN");

    private String nombre;

    private Provincia(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }
}
