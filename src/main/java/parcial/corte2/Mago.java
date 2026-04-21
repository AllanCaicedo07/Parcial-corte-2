package parcial.corte2;

public class Mago extends Criatura implements Magico{
    
    //atributos específicos del Mago
    private String hechizos;
    private Arma arma;
 
    
    public Mago(String nombre, int salud, int fuerza, String hechizos) {
        super(nombre, salud, fuerza);
        this.hechizos = hechizos;
        this.arma = null;
    }
 
    @Override
    public void atacar(Criatura objetivo) {
        int dañoTotal = fuerza;
 
        lanzarHechizo(); // El mago siempre lanza un hechizo al atacar
 
        if (arma != null) {
            System.out.println(nombre + " ataca también con su arma: " + arma.getNombre() + "!");
            arma.atacarConArma(objetivo);
            dañoTotal += arma.getDañoAdicional();
        }
 
        System.out.println(nombre + " ataca a " + objetivo.getNombre()
                + " con el hechizo \"" + hechizos + "\"! Daño: " + dañoTotal);
        objetivo.defender(dañoTotal);
    }

    @Override
    public void defender(int daño) {
        int dañoReducido = (int) (daño * 0.9); // El escudo mágico absorbe un 10% del daño
        salud -= dañoReducido;
        System.out.println(nombre + " conjura un escudo mágico! Recibe "
                + dañoReducido + " de daño. Salud restante: " + salud);
    }
 
    
    // El mago lanza su hechizo actual.
    // Implementación del método de la interfaz Magico.
     
    @Override
    public void lanzarHechizo() {
        System.out.println(nombre + " lanza el hechizo: \"" + hechizos + "\"!");
    }
 
    
     // El mago aprende un nuevo hechizo, reemplazando el anterior.
     // Implementación del método de la interfaz Magico.
     
    @Override
    public void aprenderHechizo() {
        String nuevoHechizo = "Rayo Arcano"; // Hechizo nuevo que aprende por defecto
        System.out.println(nombre + " ha aprendido un nuevo hechizo: \"" + nuevoHechizo + "\"!");
        this.hechizos = nuevoHechizo;
    }
 
    /**
     * Sobrecarga de aprenderHechizo para aprender un hechizo específico.
     *
     * @param nuevoHechizo El nombre del nuevo hechizo a aprender
     */
    public void aprenderHechizo(String nuevoHechizo) {
        System.out.println(nombre + " ha aprendido un nuevo hechizo: \"" + nuevoHechizo + "\"!");
        this.hechizos = nuevoHechizo;
    }
 
    /**
     * Equipa un arma al mago (composición).
     *
     * @param arma El arma a equipar
     */
    public void equiparArma(Arma arma) {
        this.arma = arma;
        System.out.println(nombre + " ha equipado: " + arma.getNombre());
    }
 
    /**
     * Desequipa el arma actual del mago.
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
 
    public String getHechizos() {
        return hechizos;
    }
 
    public void setHechizos(String hechizos) {
        this.hechizos = hechizos;
    }
 
    public Arma getArma() {
        return arma;
    }

}
