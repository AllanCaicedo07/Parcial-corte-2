package parcial.corte2;

// Clase Arma — usada mediante composición por las criaturas.
// Una criatura "tiene un arma", no "es un arma", por eso no se usa herencia.
public class Arma {

    private String nombre;
    private int dañoAdicional;

    public Arma(String nombre, int dañoAdicional) {
        this.nombre = nombre;
        this.dañoAdicional = dañoAdicional;
    }

    // Aplica el daño del arma directamente sobre el objetivo
    public void atacarConArma(Criatura objetivo) {
        Main.log("  [Arma] " + nombre + " causa " + dañoAdicional + " de daño adicional a " + objetivo.getNombre());
        objetivo.defender(dañoAdicional);
    }

    public int getDañoAdicional() {
        return dañoAdicional;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre + " (daño adicional: " + dañoAdicional + ")";
    }
}
