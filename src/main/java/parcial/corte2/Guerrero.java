package parcial.corte2;

// Guerrero: combatiente cuerpo a cuerpo. Sin magia ni vuelo.
// Su armadura reduce el daño recibido en un 15%.
// Usa composición con Arma para ataques adicionales.
public class Guerrero extends Criatura {

    private String armaNombre;
    private Arma arma;

    public Guerrero(String nombre, int salud, int fuerza, String armaNombre) {
        super(nombre, salud, fuerza);
        this.armaNombre = armaNombre;
        this.arma = null;
    }

    @Override
    public void atacar(Criatura objetivo) {
        int dañoTotal = fuerza;

        if (arma != null) {
            arma.atacarConArma(objetivo);
            dañoTotal += arma.getDañoAdicional();
        }

        Main.log(nombre + " ataca a " + objetivo.getNombre()
                + " con su " + armaNombre + ". Daño total: " + dañoTotal);
        objetivo.defender(dañoTotal);
    }

    // La armadura absorbe un 15% del daño recibido
    @Override
    public void defender(int daño) {
        int dañoReducido = (int) (daño * 0.85);
        if (this.salud - dañoReducido < 0)
            dañoReducido = this.salud;
        Main.log(nombre + " bloquea con su armadura y recibe " + dañoReducido + " de daño.");
        salud -= dañoReducido;
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

    public String getArmaNombre() {
        return armaNombre;
    }

    public Arma getArma() {
        return arma;
    }
}
