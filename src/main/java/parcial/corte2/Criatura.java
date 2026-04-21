package parcial.corte2;

    ic abstract class Criatura {
 
    // Atributos básicos de toda criatura
    protected String nombre;
    protected int salud;
    protected int fuerza;

    // Constructor para inicializar los atributos
    public Criatura(String nombre, int salud, int fuerza) {
        this.nombre = nombre;
        this.salud = salud;
        this.fuerza = fuerza;
    }

    // Metodo abstracto para que cada criatura implemente su propio ataque
    public abstract void atacar(Criatura objetivo);

    // Metodo abstracto para que cada criatura implemente su propia defensa
    public abstract void defender(int daño);

    // Validar si la criatura sigue viva
    public boolean estaViva() {
        return salud > 0;
    }

    // Getters para acceder a los atributos
    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public int getFuerza() {
        return fuerza;
    }

    // Sobreescribir el método toString para mostrar información de la criatura
    @Override
    public String toString() {
        return "Criatura{" +
                "nombre='" + nombre + '\'' +
                ", salud=" + salud +
                ", fuerza=" + fuerza +
                '}';
    }

}
