package parcial.corte2;

/**
 * Aquí se crean las criaturas, se les equipan armas y se simulan batallas.
 * El método simularBatalla() es el corazón del juego: las criaturas se turnan
 * atacándose hasta que una de las dos muera.
 */
public class Main {

    /**
     * Simula una batalla entre dos criaturas.
     * La batalla continúa por turnos hasta que una de las criaturas muera.
     *
     * @param criatura1 El primer combatiente
     * @param criatura2 El segundo combatiente
     */

    public static void simularBatalla(Criatura criatura1, Criatura criatura2) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println(" INICIO DE BATALLA" // Salto de linea
                + "\n" + "=".repeat(60));
        System.out.println("  " + criatura1 + "  VS  " + criatura2);
        System.out.println("=".repeat(60) + "\n");

        int turno = 1;

        // La batalla continúa mientras ambas criaturas estén vivas
        while (criatura1.estaViva() && criatura2.estaViva()) {
            System.out.println("--- Turno " + turno + " ---");

            // Criatura 1 ataca a Criatura 2
            if (criatura1.estaViva()) {
                criatura1.atacar(criatura2);
                System.out
                        .println("  -> " + criatura2.getNombre() + " queda con " + criatura2.getSalud() + " de salud");
            }

            // Solo ataca la criatura 2 si sigue viva después del ataque anterior
            if (criatura2.estaViva()) {
                criatura2.atacar(criatura1);
                System.out
                        .println("  -> " + criatura1.getNombre() + " queda con " + criatura1.getSalud() + " de salud");
            }

            turno++;
            System.out.println();
        }

        // Resultado final de la batalla
        System.out.println("=".repeat(60));
        System.out.println("        🏆 RESULTADO FINAL 🏆");
        if (!criatura1.estaViva() && !criatura2.estaViva()) {
            System.out.println("  ¡Ambas criaturas han caído! ¡Es un EMPATE!");
        } else if (criatura1.estaViva()) {
            System.out.println("  🎉 ¡" + criatura1.getNombre() + " ha GANADO la batalla!");
        } else {
            System.out.println("  🎉 ¡" + criatura2.getNombre() + " ha GANADO la batalla!");
        }
        System.out.println("=".repeat(60) + "\n");
    }

    /**
     * Método principal del programa.
     * Crea criaturas con características únicas, les equipa armas y simula
     * batallas.
     */
    public static void main(String[] args) {

        System.out.println("\n🎮 BIENVENIDO AL SISTEMA DE BATALLAS DE CRIATURAS 🎮\n");

        // ---- Crear armas ----
        Arma espadaLegendaria = new Arma("Espada Legendaria", 25);
        Arma bastonMagico = new Arma("Bastón del Caos", 20);
        Arma garrasDragon = new Arma("Garras Ardientes", 30);

        // ---- Crear criaturas ----
        Dragon dragon = new Dragon("Ignis el Grande", 200, 50, "escamas de obsidiana");
        Mago mago = new Mago("Gandalf el Sabio", 120, 40, "Bola de Fuego");
        Guerrero guerrero = new Guerrero("Arturo el Valiente", 150, 35, "espada larga");

        // ---- Equipar armas mediante composición ----
        dragon.equiparArma(garrasDragon);
        mago.equiparArma(bastonMagico);
        guerrero.equiparArma(espadaLegendaria);

        // El mago aprende un hechizo adicional antes de la batalla
        mago.aprenderHechizo();

        // El dragón demuestra que puede volar antes de la batalla
        dragon.volar();
        dragon.aterrizar();

        System.out.println("\n--- Criaturas listas para combatir ---");
        System.out.println(dragon);
        System.out.println(mago);
        System.out.println(guerrero);

        // ---- BATALLA 1: Dragon vs Mago ----
        // Reiniciamos las criaturas para la primera batalla
        Dragon dragon1 = new Dragon("Ignis", 200, 50, "escamas de obsidiana");
        Mago mago1 = new Mago("Gandalf", 120, 40, "Bola de Fuego");
        dragon1.equiparArma(new Arma("Garras Ardientes", 30));
        mago1.equiparArma(new Arma("Bastón del Caos", 20));

        simularBatalla(dragon1, mago1);

        // ---- BATALLA 2: Guerrero vs Mago ----
        Guerrero guerrero2 = new Guerrero("Arturo", 150, 35, "espada larga");
        Mago mago2 = new Mago("Merlín", 110, 38, "Rayo de Hielo");
        guerrero2.equiparArma(new Arma("Espada Legendaria", 25));

        simularBatalla(guerrero2, mago2);

        // ---- BATALLA 3: Dragon vs Guerrero ----
        Dragon dragon3 = new Dragon("Pyrax", 180, 45, "escamas de titanio");
        Guerrero guerrero3 = new Guerrero("Leonidas", 160, 40, "hacha de guerra");
        guerrero3.equiparArma(new Arma("Hacha Rúnica", 28));

        simularBatalla(dragon3, guerrero3);

        System.out.println("🎮 FIN DEL JUEGO. ¡Gracias por ver las batallas! 🎮\n");
    }
}