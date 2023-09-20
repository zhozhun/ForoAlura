package com.alura.foro.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class PrincipalView extends JFrame {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			PrincipalView ventana = new PrincipalView();

			// Hacer que la ventana sea visible
			ventana.setVisible(true);
		});

	}

	public PrincipalView() {

		setLayout(null);

//    	==================== 1. Elementos básicos ====================

//		Configurar el título de la ventana
		setTitle("Foro Hotel");

//		Establecer el tamaño de la ventana (ancho x alto)
		setSize(1200, 800);

//		Configurar la operación al cerrar la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//    	==================== 2. Componentes ====================
//		==================== 2.1. Imágenes ====================
		ImageIcon imagenForo = new ImageIcon("images/imagenForo1.png");
		JLabel labelImagenForo = new JLabel(imagenForo);
		labelImagenForo.setBounds(50, 30, 100, 100);
		add(labelImagenForo);

//    	==================== 2.2. Etiquetas ====================	
		JLabel etiquetaForo = new JLabel("Inicio");
		etiquetaForo.setBounds(1000, 30, 200, 40);
		etiquetaForo.setFont(new Font("Arial", Font.BOLD, 20));
		add(etiquetaForo);

//    	==================== 2.3. Botones ====================

		ButtonBorders agregarTopico = new ButtonBorders("Agregar tópico", new Color(82, 37, 96), 20);
		agregarTopico.setBounds(950, 150, 220, 40);
		agregarTopico.setFont(new Font("Arial", Font.BOLD, 20));
		agregarTopico.setForeground(Color.WHITE);
		agregarTopico.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		agregarTopico.setFocusPainted(false); // Deshabilitar el enfoque predeterminado
		add(agregarTopico);

		ButtonBorders eliminarTopico = new ButtonBorders("Eliminar tópico", new Color(82, 37, 96), 20);
		eliminarTopico.setBounds(950, 200, 220, 40);
		eliminarTopico.setFont(new Font("Arial", Font.BOLD, 20));
		eliminarTopico.setForeground(Color.WHITE);
		eliminarTopico.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		eliminarTopico.setFocusPainted(false); // Deshabilitar el enfoque predeterminado
		add(eliminarTopico);

		ButtonBorders botonSalir = new ButtonBorders("⌂", new Color(82, 37, 96), 20);
		botonSalir.setBounds(1000, 600, 80, 80);
		botonSalir.setFont(new Font("Arial", Font.BOLD, 40));
		botonSalir.setForeground(Color.WHITE);
		botonSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonSalir.setFocusPainted(false); // Deshabilitar el enfoque predeterminado
		add(botonSalir);

//		====================  2.4. Páneles ====================

		JPanel panelTopicos = new JPanel();
		panelTopicos.setLayout(null);
		panelTopicos.setBounds(100, 150, 800, 600);
		panelTopicos.setBackground(Color.WHITE);

//    	==================== 2.5. Textos ====================

		// JTextArea para mostrar los tópicos
		JTextArea areaTopicos = new JTextArea();
//        areaTopicos.setBounds(100, 150, 800, 600);
		areaTopicos.setWrapStyleWord(true);
		areaTopicos.setLineWrap(true);
		areaTopicos.setEditable(false);
		
//		texto prueba
//		areaTopicos.setText("Este es un ejemplo de tópico.\nOtro tópico.\nY otro más."
//				+ "\\nY otro más.\\nY otro más.\\nY otro más.\\nY otro más.\\nY otro más.\\nY otro más.\\nY otro más.")


//    	==================== 2.6. Desplazamiento ====================

		JScrollPane scrollPane = new JScrollPane(areaTopicos);
//		tamaño de scrollPane igual a panelTopicos para que abarque toda el área
		scrollPane.setBounds(0, 0, 800, 600);
		panelTopicos.add(scrollPane);
//		agregar panelTopicos acá en scrollPane para que se muestre la barra de desplazamiento vertical
		add(panelTopicos);

//		====================  2.6. Métodos ====================

	}
}