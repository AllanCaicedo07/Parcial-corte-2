package parcial.corte2;

public class Guerrero extends Criatura {

    //atributos específicos del Guerrero
    private String armaNombre;
    private Arma arma;

    // Constructor del Guerrero
    public Guerrero(String nombre, int salud, int fuerza, String armaNombre) {
        super(nombre, salud, fuerza);
        this.armaNombre = armaNombre;
        this.arma = null;
    }

    
    @Override
    public void atacar(Criatura objetivo) {
        int dañoTotal = fuerza;

        if (arma != null) {
            System.out.println(nombre + " ataca con su arma: " + arma.getNombre() + "!");
            arma.atacarConArma(objetivo);
            dañoTotal += arma.getDañoAdicional();
        }

        System.out.println(nombre + " ataca a " + objetivo.getNombre()
                + " con su " + armaNombre + "! Daño: " + dañoTotal);
        objetivo.defender(dañoTotal);
    }

    
    @Override
    public void defender(int daño) {
        int dañoReducido = (int) (daño * 0.85); // La armadura absorbe un 15% del daño
        salud -= dañoReducido;
        System.out.println(nombre + " bloquea parte del golpe con su armadura! Recibe "
                + dañoReducido + " de daño. Salud restante: " + salud);
    }

    
    public void equiparArma(Arma arma) {
        this.arma = arma;
        System.out.println(nombre + " ha equipado: " + arma.getNombre());
    }

    /**
     * Desequipa el arma actual del guerrero.
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

    public String getArmaNombre() {
        return armaNombre;
    }

    public void setArmaNombre(String armaNombre) {
        this.armaNombre = armaNombre;
    }

    public Arma getArma() {
        return arma;
    }
}
