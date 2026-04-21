package parcial.corte2;

/**
 * Clase Dragon
 * Representa un dragón en el sistema de batallas.
 * Extiende la clase abstracta Criatura e implementa la interfaz Volador,
 * ya que los dragones tienen la habilidad de volar.
 *
 * Decisión de diseño: El dragón tiene un ataque más fuerte (fuerza * 2)
 * y puede equipar un arma mediante composición. También implementa Volador
 * porque es una habilidad característica de esta criatura.
 */
public class Dragon extends Criatura implements Volador {

    /**
     * Tipo de escamas del dragón (ej: "escamas de fuego", "escamas de hielo")
     * Aporta identidad única a cada dragón.
     */
    private String escamas;

    /**
     * Arma que el dragón puede equipar (composición).
     * Puede ser null si no tiene arma equipada.
     */
    private Arma arma;

    /**
     * Constructor del Dragon.
     *
     * @param nombre  Nombre del dragón
     * @param salud   Puntos de salud iniciales
     * @param fuerza  Fuerza base del dragón
     * @param escamas Tipo de escamas del dragón
     */
    public Dragon(String nombre, int salud, int fuerza, String escamas) {
        super(nombre, salud, fuerza);
        this.escamas = escamas;
        this.arma = null;
    }

    /**
     * Ataca a una criatura objetivo.
     * El dragón tiene un ataque más fuerte: aplica fuerza * 2 como daño base.
     * Si tiene un arma equipada, se suma el daño adicional del arma.
     *
     * @param objetivo La criatura que recibirá el ataque
     */
    @Override
    public void atacar(Criatura objetivo) {
        int dañoTotal = fuerza * 2;

        if (arma != null) {
            System.out.println(nombre + " ataca con su arma: " + arma.getNombre() + "!");
            arma.atacarConArma(objetivo);
            dañoTotal += arma.getDañoAdicional();
        }

        System.out.println(nombre + " ataca a " + objetivo.getNombre()
                + " con sus garras de fuego! Daño: " + dañoTotal);
        objetivo.defender(dañoTotal);
    }

    /**
     * El dragón se defiende de un ataque recibido.
     * Gracias a sus escamas, reduce el daño recibido en un 20%.
     *
     * @param daño Cantidad de daño recibido
     */
    @Override
    public void defender(int daño) {
        int dañoReducido = (int) (daño * 0.8); // Las escamas absorben un 20% del daño
        salud -= dañoReducido;
        System.out.println(nombre + " se defiende con sus " + escamas
                + "! Recibe " + dañoReducido + " de daño. Salud restante: " + salud);
    }

    /**
     * El dragón alza el vuelo.
     * Implementación del método de la interfaz Volador.
     */
    @Override
    public void volar() {
        System.out.println(nombre + " despliega sus enormes alas y alza el vuelo!");
    }

    /**
     * El dragón aterriza.
     * Implementación del método de la interfaz Volador.
     */
    @Override
    public void aterrizar() {
        System.out.println(nombre + " desciende desde las alturas y aterriza con gran estruendo!");
    }

    /**
     * Equipa un arma al dragón (composición).
     *
     * @param arma El arma a equipar
     */
    public void equiparArma(Arma arma) {
        this.arma = arma;
        System.out.println(nombre + " ha equipado: " + arma.getNombre());
    }

    /**
     * Desequipa el arma actual del dragón.
     */
    public void desequiparArma() {
        if (arma != null) {
            System.out.println(nombre + " ha desequipado: " + arma.getNombre());
            this.arma = null;
        } else {
            System.out.println(nombre + " no tiene ningún arma equipada.");
        }
    }

    // -------------------- Getters y Setters --------------------

    public String getEscamas() {
        return escamas;
    }

    public void setEscamas(String escamas) {
        this.escamas = escamas;
    }

    public Arma getArma() {
        return arma;
    }
}
