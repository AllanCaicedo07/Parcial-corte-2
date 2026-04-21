package parcial.corte2;

/**
 * Clase Dragon.
 *
 * El dragón es la criatura más poderosa: ataca con el doble de su fuerza
 * (representa su aliento de fuego). Además puede volar gracias a que
 * implementa la interfaz Volador.
 *
 * Usa COMPOSICIÓN: tiene una referencia a un objeto Arma que puede equipar.
 */

public class Dragon extends Criatura implements Volador {

    // Atibutos propios del dragon
    private String escamas;
    private Arma arma; // El dragón puede equipar un arma para aumentar su poder de ataque

    // Constructor
    public Dragon(String nombre, int salud, int fuerza, String escamas) {
        super(nombre, salud, fuerza);
        this.escamas = escamas;
        this.arma = null; // El dragón comienza sin arma equipada
    }

    // El dragon ataca con aliento de fuego:daño = fuerza * 2
    @Override
    public void atacar(Criatura objetivo) {
        int daño = fuerza * 2;
        System.out.println("El dragón [" + nombre + "] lanza su aliento de fuego sobre " + objetivo.getNombre()
                + " causando " + daño + " puntos de daño!");
        objetivo.defender(daño);
        // Si tiene arma equipada, también ataca con ella
        if (arma != null) {
            volar(); // El dragón vuela para aprovechar mejor su arma
            arma.atacarConArma(objetivo);
            aterrizar();
        }
    }

    /**
     * El dragón se defiende con sus escamas, que absorben parte del daño.
     * Sus escamas reducen el daño recibido en un 20%.
     *
     * @param daño El daño recibido antes de la defensa
     */
    @Override
    public void defender(int daño) {
        int reduccion = daño / 5; // 20% de reducción gracias a las escamas
        int dañoFinal = daño - reduccion;
        System.out.println(" Proteccion " + nombre + " usa sus " + escamas + " y reduce el daño de "
                + daño + " a " + dañoFinal);
        this.salud -= dañoFinal;
        if (this.salud < 0)
            this.salud = 0; // La salud no puede ser negativa
    }

    // Implementación de los métodos de la interfaz Volador
    @Override
    public void volar() {
        System.out.println("El dragón [" + nombre + "] alza vuelo majestuosamente!");
    }

    @Override
    public void aterrizar() {
        System.out.println("El dragón [" + nombre + "] aterriza con fuerza, sacudiendo el suelo!");
    }

    // Método para equipar un arma al dragón
    public void equiparArma(Arma arma) {
        this.arma = arma;
        System.out.println("El dragón [" + nombre + "] equipa el arma: " + arma);
    }

    // Método para desequipar el arma
    public void desequiparArma() {
        System.out.println("El dragón [" + nombre + "] desequipa el arma: " + arma);
        this.arma = null;
    }

    public Arma getArma() {
        return arma;
    }

    public String getEscamas() {
        return escamas;
    }
}