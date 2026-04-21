package parcial.corte2;

// Mago: ataca con hechizos usando su fuerza base.
// Implementa Magico para lanzar y aprender hechizos.
// Usa composición con Arma para ataques adicionales.
public class Mago extends Criatura implements Magico {

    private String hechizos;
    private Arma arma;

    public Mago(String nombre, int salud, int fuerza, String hechizos) {
        super(nombre, salud, fuerza);
        this.hechizos = hechizos;
        this.arma = null;
    }

    @Override
    public void atacar(Criatura objetivo) {
        lanzarHechizo();
        int dañoTotal = fuerza;

        if (arma != null) {
            arma.atacarConArma(objetivo);
            dañoTotal += arma.getDañoAdicional();
        }

        Main.log(nombre + " ataca a " + objetivo.getNombre()
                + " con \"" + hechizos + "\". Daño total: " + dañoTotal);
        objetivo.defender(dañoTotal);
    }

    // El escudo magico absorbe un 10% del daño recibido
    @Override
    public void defender(int daño) {
        int dañoReducido = (int) (daño * 0.9);
        if (this.salud - dañoReducido < 0)
            dañoReducido = this.salud;
        Main.log(nombre + " conjura un escudo magico y recibe " + dañoReducido + " de daño.");
        salud -= dañoReducido;
    }

    @Override
    public void lanzarHechizo() {
        Main.log(nombre + " lanza el hechizo: " + hechizos);
    }

    @Override
    public void aprenderHechizo() {
        String nuevo = "Rayo Arcano";
        Main.log(nombre + " aprende un nuevo hechizo: " + nuevo);
        this.hechizos = hechizos + " + " + nuevo;
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

    public String getHechizos() {
        return hechizos;
    }

    public Arma getArma() {
        return arma;
    }
}
