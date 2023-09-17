package com.alura.foro.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

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
		setTitle("Alura Hotel");

//		Establecer el tamaño de la ventana (ancho x alto)
		setSize(1200, 800);

//		Configurar la operación al cerrar la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//		fondo título #5225c4

//    	==================== 2. Componentes ====================
//		==================== 2.1. Imágenes ====================

		ImageIcon tituloInicio = new ImageIcon("images/tituloPrincipal1.png");
		JLabel labelTituloInicio = new JLabel(tituloInicio);
		labelTituloInicio.setBounds(110, 40, 340, 50);
		add(labelTituloInicio);

		ImageIcon imagenInicio = new ImageIcon("images/imagenPrincipal1.png");
		JLabel labelImagenInicio = new JLabel(imagenInicio);
		labelImagenInicio.setBounds(70, 200, 400, 400);
		add(labelImagenInicio);

		ImageIcon imagenInicio2 = new ImageIcon("images/imagenPrincipal3.png");
		JLabel labelImagenInicio2 = new JLabel(imagenInicio2);
		labelImagenInicio2.setBounds(850, 100, 80, 70);
		add(labelImagenInicio2);
		
//    	==================== 2.2. Textos ====================

		JTextField textoUsuario = createPlaceholderTextField("Ingresar su usuario: ");
		textoUsuario.setBounds(700, 250, 400, 50);
		textoUsuario.setFont(new Font("Arial", Font.BOLD, 16));
		add(textoUsuario);

		JPasswordField textoContrasena = createPlaceholderPasswordField("Contraseña: ");
		textoContrasena.setBounds(700, 350, 400, 50);
		textoContrasena.setFont(new Font("Arial", Font.BOLD, 16));
		add(textoContrasena);

//    	==================== 2.3. Botones ====================

		ButtonBorders botonIniciarSesion = new ButtonBorders("Iniciar sesión", new Color(82, 37, 96), 20);
		botonIniciarSesion.setBounds(750, 450, 300, 60);
		botonIniciarSesion.setFont(new Font("Arial", Font.BOLD, 24));
		botonIniciarSesion.setForeground(Color.WHITE);
		botonIniciarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonIniciarSesion.setFocusPainted(false); // Deshabilitar el enfoque predeterminado
		add(botonIniciarSesion);

//		====================  Páneles ====================

		JPanel panelDerecho = new JPanel();
		panelDerecho.setBackground(new Color(82, 37, 96));
		panelDerecho.setBounds(0, 0, 600, 800);
		panelDerecho.setOpaque(true);

		add(panelDerecho);

	}

//	====================  Métodos ====================

//	====================  Placeholder Usuario ====================

	private JTextField createPlaceholderTextField(String placeholder) {
		JTextField textoUsuario = new JTextField(placeholder);
		textoUsuario.setForeground(Color.GRAY);

		// Agregar un FocusListener para quitar el placeholder cuando se obtiene el foco
		textoUsuario.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textoUsuario.getText().equals(placeholder)) {
					textoUsuario.setText("");
					textoUsuario.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textoUsuario.getText().isEmpty()) {
					textoUsuario.setText(placeholder);
					textoUsuario.setForeground(Color.GRAY);
				}
			}
		});

		return textoUsuario;
	}

	private JPasswordField createPlaceholderPasswordField(String placeholder) {
		JPasswordField passwordField = new JPasswordField(placeholder);
		passwordField.setForeground(Color.GRAY);

		// Configurar el carácter de eco para mostrar el placeholder como texto
		passwordField.setEchoChar((char) 0);

		// Agregar un FocusListener para quitar el placeholder cuando se obtiene el foco
		passwordField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				char[] password = passwordField.getPassword();
				String passwordText = new String(password);
				if (passwordText.equals(placeholder)) {
					passwordField.setText("");
					passwordField.setEchoChar('*'); // Cambiar a asteriscos cuando se escriba
					passwordField.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				char[] password = passwordField.getPassword();
				String passwordText = new String(password);
				if (passwordText.isEmpty()) {
					passwordField.setText(placeholder);
					passwordField.setEchoChar((char) 0); // Mostrar el placeholder como texto
					passwordField.setForeground(Color.GRAY);
				}
			}
		});

		return passwordField;
	}

}
