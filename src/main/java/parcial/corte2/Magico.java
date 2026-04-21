package parcial.corte2;

/**
 * Interfaz Magico.
 * Similar a Volador, "ser mágico" es una habilidad especial.
 * El Mago implementa esta interfaz para poder lanzar hechizos y aprenderlos.
 * Si en el futuro hay más criaturas mágicas, solo se necesita implementar esta
 * interfaz.
 */

public interface Magico {

    // La criatura lanza un hechizo.
    void lanzarHechizo();

    // La criatura aprende un nuevo hechizo.
    void aprenderHechizo();
}
