package parcial.corte2;

/**
 * Clase Arma.
 *
 * Se usa COMPOSICIÓN en lugar de herencia.
 * Esto significa que una criatura "tiene un arma" en lugar de "ser un arma".
 * La composición es más flexible: una criatura puede equipar o desequipar
 * un arma en cualquier momento, sin cambiar su tipo o clase.
 */

public class Arma {

    // Atributos del arma
    private String nombre;
    private int dañoAdicional;

    // Constructor
    public Arma(String nombre, int dañoAdicional) {
        this.nombre = nombre;
        this.dañoAdicional = dañoAdicional;
    }

    /**
     * Realiza un ataque usando el arma sobre una criatura objetivo.
     * Llama al método defender del objetivo con el daño adicional del arma.
     *
     * @param objetivo La criatura que recibe el ataque del arma
     */
    public void atacarConArma(Criatura objetivo) {
        System.out.println("Usando el arma [" + nombre + "] para causar " + dañoAdicional + " daño adicional!");
        objetivo.defender(dañoAdicional);
    }

    /**
     * Retorna el daño adicional que esta arma proporciona.
     *
     * @return El valor numérico del daño adicional
     */
    public int getDañoAdicional() {
        return dañoAdicional;
    }

    /**
     * Retorna el nombre del arma.
     */
    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre + " (Daño adicional: " + dañoAdicional + ")";
    }
}
