
package arg.cuarteto.Proyecto_clasificados.Enumeraciones;
public enum Nacionalidad {
    
    ARGENTINA("ARGENTINA"),
    CHILENA("CHILENA"),
    BOLIVIANA("BOLIVIANA"),
    BRASILEÑA("BRASILEÑA"),
    COLOMBIANA("COLOMBIANA"),
    COSTARRICENSE("COSTARRICENSE"),
    MEXICANA("MEXICANA"),
    PANAMEÑA("PANAMEÑA"),
    PARAGUAYA("PARAGUAYA"),
    URUGUAYA("URUGUAYA"),
    PERUANA("PERUANA"),
    PUERTORIQUEÑO("PUERTORIQUEÑO"),
    VENEZOLANA("VENEZOLANA"),
    ECUATORIANA("ECUATORIANA"),
    CHINA("CHINA"),
    JAPONES("JAPONES"),
    COREANA("COREANA"),
    ALEMANA("ALEMANA"),
    FRANCESA("FRANCESA"),
    AUSTRALIANA("AUSTRALIANA"),
    CANADIENSE("CANADIENSE"),
    CUBANA("CUBANA");
    private String nombre;

    private Nacionalidad(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }
}
