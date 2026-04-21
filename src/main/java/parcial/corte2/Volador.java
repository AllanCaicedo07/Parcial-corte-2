package parcial.corte2;

/**
 * Interfaz Volador
 * Define el comportamiento de las criaturas que tienen la capacidad de volar.
 * Esta interfaz es implementada por criaturas como el Dragon.
 *
 * Decisión de diseño: Se usa una interfaz en lugar de una clase abstracta
 * porque "volar" es una habilidad adicional que no todas las criaturas poseen,
 * y no forma parte de la jerarquía principal de Criatura.
 */
public interface Volador {

    /**
     * Permite a la criatura alzar vuelo.
     * Cada criatura que implemente esta interfaz define su propia forma de volar.
     */
    void volar();

    /**
     * Permite a la criatura aterrizar.
     * Cada criatura que implemente esta interfaz define su propia forma de aterrizar.
     */
    void aterrizar();
}
