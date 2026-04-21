package parcial.corte2;

// Dragon: la criatura más fuerte. Ataca con el doble de su fuerza.
// Implementa Volador porque puede volar y aterrizar.
// Usa composición con Arma para ataques adicionales.
public class Dragon extends Criatura implements Volador {

    private String escamas;
    private Arma arma;

    public Dragon(String nombre, int salud, int fuerza, String escamas) {
        super(nombre, salud, fuerza);
        this.escamas = escamas;
        this.arma = null;
    }

    @Override
    public void atacar(Criatura objetivo) {
        int daño = fuerza * 2;
        Main.log(nombre + " lanza su aliento de fuego sobre " + objetivo.getNombre()
                + " causando " + daño + " puntos de daño.");
        objetivo.defender(daño);

        if (arma != null) {
            volar();
            arma.atacarConArma(objetivo);
            aterrizar();
        }
    }

    // Las escamas reducen el daño recibido en un 20%
    @Override
    public void defender(int daño) {
        int reduccion = daño / 5;
        int dañoFinal = daño - reduccion;
        if (this.salud - dañoFinal < 0)
            dañoFinal = this.salud;
        Main.log(nombre + " usa sus " + escamas + " y reduce el daño de " + daño + " a " + dañoFinal + ".");
        this.salud -= dañoFinal;
    }

    @Override
    public void volar() {
        Main.log(nombre + " alza vuelo.");
    }

    @Override
    public void aterrizar() {
        Main.log(nombre + " aterriza.");
    }

    public void equiparArma(Arma arma) {
        this.arma = arma;
        Main.log(nombre + " equipa: " + arma);
    }

    public void desequiparArma() {
        if (arma != null) {
            Main.log(nombre + " desequipa: " + arma);
            this.arma = null;
        }
    }

    public Arma getArma() {
        return arma;
    }

    public String getEscamas() {
        return escamas;
    }
}