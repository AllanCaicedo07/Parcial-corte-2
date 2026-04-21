package parcial.corte2;

/**
 * Interfaz Volador.
 * Se usa una interfaz porque "volar" es una habilidad
 * que no todas las criaturas tienen. Las interfaces permiten agregar
 * comportamientos específicos sin cambiar la jerarquía de clases.
 * Así, solo el Dragon (y cualquier otra criatura voladora) la implementa.
 */

public interface Volador {

    /**
     * Permite a la criatura alzar vuelo.
     * Cada criatura que implemente esta interfaz define su propia forma de volar.
     */
    void volar();

    /**
     * Permite a la criatura aterrizar.
     * Cada criatura que implemente esta interfaz define su propia forma de
     * aterrizar.
     */
    void aterrizar();
}
