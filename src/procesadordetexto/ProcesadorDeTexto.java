package procesadordetexto;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ProcesadorDeTexto {

	public static void main(String[] args) {
		// Crea y muestra la ventana principal
		Marco marcoProcesador = new Marco();
		marcoProcesador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marcoProcesador.setVisible(true);
	}
}

// Clase que representa la ventana principal del programa
class Marco extends JFrame {

	public Marco() {
		// Título de la ventana
		setTitle("Procesador de texto");

		// Ubicación y tamaño: x, y, ancho, alto
		setBounds(180, 90, 400, 400);

		// Panel principal del procesador
		Lamina miLaminaProcesador = new Lamina();

		// Asignar barra de menú a la ventana
		setJMenuBar(miLaminaProcesador.getBarraMenu());

		// Añadir el panel principal al marco
		add(miLaminaProcesador);
	}
}

// Clase que contiene el área de texto y los menús
final class Lamina extends JPanel {

	public Lamina() {
		// Diseño tipo BorderLayout
		setLayout(new BorderLayout());

		// Crear la barra de menú
		menuProcesador = new JMenuBar();

		// Crear menús desplegables
		fuente = new JMenu("Fuente");
		estilo = new JMenu("Estilo");
		tamano = new JMenu("Tamaño");

		// ===== MENÚ ESTILO =====
		configuraMenu("Negrita", "estilo", "", Font.BOLD, 1);
		configuraMenu("Cursiva", "estilo", "", Font.ITALIC, 1);

		// ===== MENÚ TAMAÑO =====
		configuraMenu("12", "tamano", "", 9, 12);
		configuraMenu("16", "tamano", "", 9, 16);
		configuraMenu("20", "tamano", "", 9, 20);
		configuraMenu("24", "tamano", "", 9, 24);

		// ===== MENÚ FUENTE =====
		configuraMenu("Arial", "fuente", "Arial", 9, 10);
		configuraMenu("Courier", "fuente", "Courier", 9, 10);
		configuraMenu("Verdana", "fuente", "Verdana", 9, 10);

		// Añadir menús a la barra de menú
		menuProcesador.add(fuente);
		menuProcesador.add(estilo);
		menuProcesador.add(tamano);

		// Crear el área de texto (editor)
		textPane = new JTextPane();

		// Añadir el área de texto al centro del panel
		add(textPane, BorderLayout.CENTER);
	}

	// Método para crear elementos de menú dinámicamente
	public void configuraMenu(String rotulo, String menu, String tipoLetra, int estilos, int tam) {
		JMenuItem elemMenu = new JMenuItem(rotulo);
		if (menu == "fuente") {
			fuente.add(elemMenu);
		} else if (menu == "estilo") {
			estilo.add(elemMenu);
		} else if (menu == "tamano") {
			tamano.add(elemMenu);
		}

		
	}

	
	
	
	
	
	// Devuelve la barra de menú para que el marco la use
	public JMenuBar getBarraMenu() {
		return menuProcesador;
	}
	
	
	
	
	// ===== ATRIBUTOS =====
	private JTextPane textPane; // Área de texto
	private JMenuBar menuProcesador; // Barra de menú
	private JMenu fuente, estilo, tamano; // Menús desplegables
	private Font letras; // Fuente (por implementar)
}
