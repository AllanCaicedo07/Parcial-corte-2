package parcial.corte2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas Unitarias con JUnit 5.
 *
 * Cada método @Test verifica que una parte específica del código funcione bien.
 * El @BeforeEach prepara los objetos antes de cada prueba para que
 * cada test empiece con datos limpios.
 */
public class BatallaTest {

    // Variables que se usan en las pruebas
    private Dragon dragon;
    private Mago mago;
    private Guerrero guerrero;
    private Arma arma;

    /**
     * Este método se ejecuta ANTES de cada prueba.
     * Sirve para crear objetos frescos y evitar que una prueba afecte a otra.
     */
    @BeforeEach
    void setUp() {
        dragon = new Dragon("Dragon Test", 100, 20, "escamas duras");
        mago = new Mago("Mago Test", 80, 15, "Rayo");
        guerrero = new Guerrero("Guerrero Test", 90, 18, "espada");
        arma = new Arma("Espada de Prueba", 10);
    }

    // ===== Pruebas de Criatura =====

    @Test
    @DisplayName("La criatura debe estar viva cuando su salud es mayor a 0")
    void testEstaVivaConSaludPositiva() {
        assertTrue(dragon.estaViva(), "El dragón debería estar vivo con salud 100");
    }

    @Test
    @DisplayName("La criatura no debe estar viva cuando su salud llega a 0")
    void testNoEstaVivaConSaludCero() {
        // Hacemos que la salud llegue a 0 atacándolo mucho
        dragon.defender(10000); // Daño gigante para matar al dragón
        assertFalse(dragon.estaViva(), "El dragón no debería estar vivo con salud 0");
    }

    @Test
    @DisplayName("La salud de la criatura no debe volverse negativa")
    void testSaludNoNegativa() {
        dragon.defender(10000);
        assertTrue(dragon.getSalud() >= 0, "La salud no puede ser negativa");
    }

    // ===== Pruebas de Dragon =====

    @Test
    @DisplayName("El Dragon debe reducir el daño recibido por sus escamas (20%)")
    void testDragonReduceDaño() {
        int saludAntes = dragon.getSalud();
        dragon.defender(20); // Debería reducirse un 20% = 4 puntos
        int saludDespues = dragon.getSalud();
        // Con 20 de daño: reduccion = 20/5 = 4, dañoFinal = 16
        assertEquals(saludAntes - 16, saludDespues,
                "El dragón debería recibir solo 16 puntos de daño (20% reducido)");
    }

    @Test
    @DisplayName("El Dragon puede equipar un arma")
    void testDragonEquipaArma() {
        dragon.equiparArma(arma);
        assertNotNull(dragon.getArma(), "El dragón debería tener un arma equipada");
        assertEquals("Espada de Prueba", dragon.getArma().getNombre());
    }

    @Test
    @DisplayName("El Dragon puede desequipar un arma")
    void testDragonDesequipaArma() {
        dragon.equiparArma(arma);
        dragon.desequiparArma();
        assertNull(dragon.getArma(), "El dragón no debería tener arma después de desequipar");
    }

    // ===== Pruebas de Mago =====

    @Test
    @DisplayName("El Mago debe reducir 10 puntos fijos de daño con su escudo mágico")
    void testMagoReduceDaño() {
        int saludAntes = mago.getSalud();
        mago.defender(30);
        int saludDespues = mago.getSalud();
        // 30 - 10 (escudo) = 20 puntos de daño real
        assertEquals(saludAntes - 20, saludDespues,
                "El mago debería recibir solo 20 puntos de daño");
    }

    @Test
    @DisplayName("El escudo del Mago no puede hacer que el daño sea negativo")
    void testMagoEscudoConDañoMenorAlEscudo() {
        int saludAntes = mago.getSalud();
        mago.defender(5); // Menor que el escudo (10), debería recibir 0 daño
        assertEquals(saludAntes, mago.getSalud(),
                "El mago no debería perder salud si el daño es menor al escudo");
    }

    @Test
    @DisplayName("El Mago puede aprender un nuevo hechizo")
    void testMagoAprenderHechizo() {
        String hechizosAntes = mago.getHechizos();
        mago.aprenderHechizo();
        assertNotEquals(hechizosAntes, mago.getHechizos(),
                "Los hechizos del mago deben cambiar al aprender uno nuevo");
    }

    // ===== Pruebas de Guerrero =====

    @Test
    @DisplayName("El Guerrero debe reducir 15 puntos fijos de daño con su armadura")
    void testGuerreroReduceDaño() {
        int saludAntes = guerrero.getSalud();
        guerrero.defender(40);
        int saludDespues = guerrero.getSalud();
        // 40 - 15 (armadura) = 25 puntos de daño real
        assertEquals(saludAntes - 25, saludDespues,
                "El guerrero debería recibir solo 25 puntos de daño");
    }

    @Test
    @DisplayName("El Guerrero puede equipar y desequipar armas")
    void testGuerreroComposicionArma() {
        assertNull(guerrero.getArma(), "Al inicio el guerrero no tiene arma");
        guerrero.equiparArma(arma);
        assertNotNull(guerrero.getArma(), "Después de equipar debería tener arma");
        guerrero.desequiparArma();
        assertNull(guerrero.getArma(), "Después de desequipar no debería tener arma");
    }

    // ===== Pruebas de Arma =====

    @Test
    @DisplayName("El Arma debe retornar el daño adicional correcto")
    void testArmaGetDañoAdicional() {
        assertEquals(10, arma.getDañoAdicional(),
                "El arma debería tener 10 de daño adicional");
    }

    @Test
    @DisplayName("El Arma debe atacar y reducir la salud del objetivo")
    void testArmaAtacarConArma() {
        int saludAntesGuerrero = guerrero.getSalud();
        // El arma hace 10 de daño, el guerrero reduce 15 con armadura → 0 daño
        arma.atacarConArma(guerrero);
        // Con armadura de 15 y daño de 10: max(0, 10-15) = 0 daño
        assertEquals(saludAntesGuerrero, guerrero.getSalud(),
                "El guerrero no debería perder salud si su armadura supera el daño del arma");
    }

    // ===== Prueba de Polimorfismo =====

    @Test
    @DisplayName("Polimorfismo: todas las criaturas deben poder atacar y defenderse")
    void testPolimorfismo() {
        // Usamos el tipo base Criatura para referirnos a todas
        Criatura[] criaturas = { dragon, mago, guerrero };

        for (Criatura c : criaturas) {
            assertTrue(c.estaViva(), c.getNombre() + " debería estar viva al inicio");
            // Todas deben poder llamar a defender sin errores
            assertDoesNotThrow(() -> c.defender(5),
                    c.getNombre() + " debería poder defenderse sin errores");
        }
    }

    // ===== Prueba de interfaces =====

    @Test
    @DisplayName("El Dragon debe ser instancia de Volador")
    void testDragonEsVolador() {
        assertTrue(dragon instanceof Volador,
                "El Dragon debe implementar la interfaz Volador");
    }

    @Test
    @DisplayName("El Mago debe ser instancia de Magico")
    void testMagoEsMagico() {
        assertTrue(mago instanceof Magico,
                "El Mago debe implementar la interfaz Magico");
    }
}
