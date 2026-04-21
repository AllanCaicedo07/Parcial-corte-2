package parcial.corte2;

import javax.swing.*;
import java.awt.*;

// Clase principal. Contiene la lógica de la interfaz gráfica y la simulación de batallas.
public class Main {

    // Acumula los mensajes de la batalla para mostrarlos en la ventana
    static StringBuilder logBatalla = new StringBuilder();

    // Agrega una línea al log y la imprime también en consola
    public static void log(String mensaje) {
        logBatalla.append(mensaje).append("\n");
        System.out.println(mensaje);
    }

    // Muestra el log completo en una ventana con scroll
    private static void mostrarLog(String titulo) {
        JTextArea area = new JTextArea(logBatalla.toString());
        area.setEditable(false);
        area.setFont(new Font("Monospaced", Font.PLAIN, 13));
        area.setBackground(new Color(30, 30, 30));
        area.setForeground(new Color(200, 255, 200));

        JScrollPane scroll = new JScrollPane(area);
        scroll.setPreferredSize(new Dimension(620, 420));

        JOptionPane.showMessageDialog(null, scroll, titulo, JOptionPane.INFORMATION_MESSAGE);
        logBatalla.setLength(0);
    }

    // Simula una batalla entre dos criaturas turno por turno
    public static void simularBatalla(Criatura criatura1, Criatura criatura2) {
        logBatalla.setLength(0);

        log("BATALLA: " + criatura1.getNombre() + " vs " + criatura2.getNombre());
        log(criatura1.toString());
        log(criatura2.toString());
        log("");

        int turno = 1;

        while (criatura1.estaViva() && criatura2.estaViva()) {
            log("Turno " + turno);

            criatura1.atacar(criatura2);
            log(criatura2.getNombre() + " queda con " + criatura2.getSalud() + " de salud.");

            if (criatura2.estaViva()) {
                criatura2.atacar(criatura1);
                log(criatura1.getNombre() + " queda con " + criatura1.getSalud() + " de salud.");
            }

            turno++;
            log("");
        }

        String resultado;
        if (!criatura1.estaViva() && !criatura2.estaViva()) {
            resultado = "Empate. Ambas criaturas cayeron.";
        } else if (criatura1.estaViva()) {
            resultado = "Ganador: " + criatura1.getNombre();
        } else {
            resultado = "Ganador: " + criatura2.getNombre();
        }

        log(resultado);

        mostrarLog("Batalla: " + criatura1.getNombre() + " vs " + criatura2.getNombre());

        JOptionPane.showMessageDialog(
                null,
                resultado,
                "Resultado",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(
                null,
                "Bienvenido al Sistema de Batallas de Criaturas",
                "Sistema de Batallas",
                JOptionPane.INFORMATION_MESSAGE);

        String[] opciones = {
                "Dragon vs Mago",
                "Guerrero vs Mago",
                "Dragon vs Guerrero",
                "Ver todas las batallas",
                "Salir"
        };

        while (true) {
            int eleccion = JOptionPane.showOptionDialog(
                    null,
                    "Selecciona una batalla:",
                    "Menu de Batallas",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);

            if (eleccion == -1 || eleccion == 4) {
                JOptionPane.showMessageDialog(null, "Hasta luego.", "Salir", JOptionPane.PLAIN_MESSAGE);
                break;
            }

            switch (eleccion) {

                case 0: {
                    Dragon d = new Dragon("Ignis", 200, 50, "escamas de obsidiana");
                    Mago m = new Mago("Gandalf", 120, 40, "Bola de Fuego");
                    d.equiparArma(new Arma("Garras Ardientes", 30));
                    m.equiparArma(new Arma("Baston del Caos", 20));
                    simularBatalla(d, m);
                    break;
                }

                case 1: {
                    Guerrero g = new Guerrero("Arturo", 150, 35, "espada larga");
                    Mago m = new Mago("Merlin", 110, 38, "Rayo de Hielo");
                    g.equiparArma(new Arma("Espada Legendaria", 25));
                    simularBatalla(g, m);
                    break;
                }

                case 2: {
                    Dragon d = new Dragon("Pyrax", 180, 45, "escamas de titanio");
                    Guerrero g = new Guerrero("Leonidas", 160, 40, "hacha de guerra");
                    g.equiparArma(new Arma("Hacha Runica", 28));
                    simularBatalla(d, g);
                    break;
                }

                case 3: {
                    Dragon d1 = new Dragon("Ignis", 200, 50, "escamas de obsidiana");
                    Mago m1 = new Mago("Gandalf", 120, 40, "Bola de Fuego");
                    d1.equiparArma(new Arma("Garras Ardientes", 30));
                    m1.equiparArma(new Arma("Baston del Caos", 20));
                    simularBatalla(d1, m1);

                    Guerrero g2 = new Guerrero("Arturo", 150, 35, "espada larga");
                    Mago m2 = new Mago("Merlin", 110, 38, "Rayo de Hielo");
                    g2.equiparArma(new Arma("Espada Legendaria", 25));
                    simularBatalla(g2, m2);

                    Dragon d3 = new Dragon("Pyrax", 180, 45, "escamas de titanio");
                    Guerrero g3 = new Guerrero("Leonidas", 160, 40, "hacha de guerra");
                    g3.equiparArma(new Arma("Hacha Runica", 28));
                    simularBatalla(d3, g3);
                    break;
                }
            }
        }
    }
}