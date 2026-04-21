package parcial.corte2;

// Clase abstracta base para todas las criaturas del juego.
// Define los atributos y comportamientos comunes que toda criatura debe tener.
public abstract class Criatura {

    protected String nombre;
    protected int salud;
    protected int fuerza;

    public Criatura(String nombre, int salud, int fuerza) {
        this.nombre = nombre;
        this.salud = salud;
        this.fuerza = fuerza;
    }

    // Cada criatura implementa su propia forma de atacar
    public abstract void atacar(Criatura objetivo);

    // Cada criatura implementa su propia forma de defenderse
    public abstract void defender(int daño);

    // Retorna true si la criatura sigue viva
    public boolean estaViva() {
        return salud > 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public int getFuerza() {
        return fuerza;
    }

    @Override
    public String toString() {
        return nombre + " | Salud: " + salud + " | Fuerza: " + fuerza;
    }
}