package com.alura.foro.view;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import javax.swing.border.AbstractBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class ButtonBorders extends JButton {

	private Color backgroundColor;
	private Color borderColor;
	private int cornerRadius;

//	Quitar el color de borde:
//	public RoundedBorder(String text, Color backgroundColor, Color borderColor, int cornerRadius)
	public ButtonBorders(String text, Color backgroundColor, int cornerRadius) {
		super(text);
		this.backgroundColor = backgroundColor;
//		this.borderColor = borderColor;
		this.cornerRadius = cornerRadius;
		setContentAreaFilled(false);
//		Quitar el recuadro alrededor
//		setFocusPainted(false); // Deshabilitar el enfoque del botón
		setBorderPainted(false); // Deshabilitar el borde del botón
//		setOpaque(true); // Hacer el botón opaco
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();

		// Pintar el fondo redondeado
		g2d.setColor(backgroundColor);
		g2d.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius));

		// Pintar el borde redondeado
		g2d.setColor(borderColor);
		g2d.draw(new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius));

		// Dibujar el texto en el centro
		super.paintComponent(g2d);

		g2d.dispose();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			LoginView ventana = new LoginView();
			ventana.setVisible(true);
		});
	}
}
