package parcial.corte2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

// Pruebas unitarias con JUnit 5.
// Cada @Test verifica el comportamiento correcto de una clase o método específico.
// @BeforeEach crea objetos limpios antes de cada prueba para evitar interferencias.
public class BatallaTest {

    private Dragon dragon;
    private Mago mago;
    private Guerrero guerrero;
    private Arma arma;

    @BeforeEach
    void setUp() {
        dragon = new Dragon("Dragon Test", 100, 20, "escamas duras");
        mago = new Mago("Mago Test", 80, 15, "Rayo");
        guerrero = new Guerrero("Guerrero Test", 90, 18, "espada");
        arma = new Arma("Espada de Prueba", 10);
    }

    // Criatura

    @Test
    @DisplayName("La criatura esta viva cuando su salud es mayor a 0")
    void testEstaViva() {
        assertTrue(dragon.estaViva());
    }

    @Test
    @DisplayName("La criatura muere cuando su salud llega a 0")
    void testNoEstaViva() {
        dragon.defender(10000);
        assertFalse(dragon.estaViva());
    }

    @Test
    @DisplayName("La salud nunca se vuelve negativa")
    void testSaludNoNegativa() {
        dragon.defender(10000);
        assertTrue(dragon.getSalud() >= 0);
    }

    // Dragon

    @Test
    @DisplayName("El Dragon reduce el daño un 20% con sus escamas")
    void testDragonReduceDanio() {
        int saludAntes = dragon.getSalud();
        dragon.defender(20);
        // reduccion = 20/5 = 4, dañoFinal = 16
        assertEquals(saludAntes - 16, dragon.getSalud());
    }

    @Test
    @DisplayName("El Dragon puede equipar un arma")
    void testDragonEquipaArma() {
        dragon.equiparArma(arma);
        assertNotNull(dragon.getArma());
        assertEquals("Espada de Prueba", dragon.getArma().getNombre());
    }

    @Test
    @DisplayName("El Dragon puede desequipar un arma")
    void testDragonDesequipaArma() {
        dragon.equiparArma(arma);
        dragon.desequiparArma();
        assertNull(dragon.getArma());
    }

    // Mago

    @Test
    @DisplayName("El Mago reduce el daño un 10% con su escudo magico")
    void testMagoReduceDanio() {
        int saludAntes = mago.getSalud();
        mago.defender(30);
        // dañoReducido = (int)(30 * 0.9) = 27
        assertEquals(saludAntes - 27, mago.getSalud());
    }

    @Test
    @DisplayName("El Mago puede aprender un nuevo hechizo")
    void testMagoAprenderHechizo() {
        String hechizosAntes = mago.getHechizos();
        mago.aprenderHechizo();
        assertNotEquals(hechizosAntes, mago.getHechizos());
    }

    @Test
    @DisplayName("El Mago puede equipar y desequipar armas")
    void testMagoComposicionArma() {
        assertNull(mago.getArma());
        mago.equiparArma(arma);
        assertNotNull(mago.getArma());
        mago.desequiparArma();
        assertNull(mago.getArma());
    }

    // Guerrero

    @Test
    @DisplayName("El Guerrero reduce el daño un 15% con su armadura")
    void testGuerreroReduceDanio() {
        int saludAntes = guerrero.getSalud();
        guerrero.defender(40);
        // dañoReducido = (int)(40 * 0.85) = 34
        assertEquals(saludAntes - 34, guerrero.getSalud());
    }

    @Test
    @DisplayName("El Guerrero puede equipar y desequipar armas")
    void testGuerreroComposicionArma() {
        assertNull(guerrero.getArma());
        guerrero.equiparArma(arma);
        assertNotNull(guerrero.getArma());
        guerrero.desequiparArma();
        assertNull(guerrero.getArma());
    }

    // Arma

    @Test
    @DisplayName("El Arma retorna el daño adicional correcto")
    void testArmaDanioAdicional() {
        assertEquals(10, arma.getDañoAdicional());
    }

    // Polimorfismo

    @Test
    @DisplayName("Todas las criaturas pueden defenderse sin errores (polimorfismo)")
    void testPolimorfismo() {
        Criatura[] criaturas = { dragon, mago, guerrero };
        for (Criatura c : criaturas) {
            assertTrue(c.estaViva());
            assertDoesNotThrow(() -> c.defender(5));
        }
    }

    // Interfaces

    @Test
    @DisplayName("El Dragon implementa la interfaz Volador")
    void testDragonEsVolador() {
        assertTrue(dragon instanceof Volador);
    }

    @Test
    @DisplayName("El Mago implementa la interfaz Magico")
    void testMagoEsMagico() {
        assertTrue(mago instanceof Magico);
    }
}