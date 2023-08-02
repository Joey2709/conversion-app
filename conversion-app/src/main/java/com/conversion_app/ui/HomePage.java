package com.conversion_app.ui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

@SuppressWarnings("serial")
public class HomePage extends JFrame {

	private JPanel contentPane;
	private JPanel mainContent;
	private JPanel currencyConverterPanel = new CurrencyConverter();
	private JPanel temperatureConverterPanel = new TemperatureConverter();
	private int width = 720;
	private int height = 480;
	private CardLayout cardLayout;

	public HomePage() {

		setTitle("Conversion App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Establecer el tamaño preferido de la ventana
		setPreferredSize(new Dimension(width, height));

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout()); 

		// Configurar el tamaño del sidebar en porcentaje (30%)
		JPanel sidebar = new JPanel();
		sidebar.setBackground(new Color(48, 56, 65));
		sidebar.setPreferredSize(new Dimension((int) (width * 0.3), height));
		contentPane.add(sidebar, BorderLayout.WEST);
		sidebar.setLayout(null);

		JLabel title = new JLabel("Conversion App");
		title.setBounds(32, 17, 151, 26);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(new Color(0, 173, 181));
		title.setFont(new Font("Dialog", Font.BOLD, 20));
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		sidebar.add(title);

		JButton btnNewButton = new JButton("");
		ImageIcon currencyButton = new ImageIcon(this.getClass().getResource("/Img/HomeIcon.png"));
		ImageIcon currencyButtonHover = new ImageIcon(
				this.getClass().getResource("/Img/HomeIcon-Hover.png"));
		btnNewButton.setBounds(48, 54, 114, 100);
		btnNewButton.setIcon(currencyButton);
		btnNewButton.setRolloverIcon(currencyButtonHover);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBorder(null);
		btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		sidebar.add(btnNewButton);

		JButton currencyConverter = new JButton("Currency converter");
		currencyConverter.setFocusPainted(false);
		currencyConverter.setFocusable(false);
		currencyConverter.setBounds(32, 203, 151, 23);
		currencyConverter.setAlignmentX(Component.CENTER_ALIGNMENT);
		sidebar.add(currencyConverter);

		JButton temperatureConverter = new JButton("Temperature converter");
		temperatureConverter.setFocusable(false);
		temperatureConverter.setBounds(32, 256, 151, 23);
		temperatureConverter.setAlignmentX(Component.CENTER_ALIGNMENT);
		sidebar.add(temperatureConverter);

		currencyConverter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(mainContent, "currency");
			}
		});

		temperatureConverter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(mainContent, "temperature");
			}
		});

		// Configurar el tamaño del contenido principal en porcentaje (70%)
		mainContent = new JPanel();
		cardLayout = new CardLayout();
		mainContent.setLayout(cardLayout);
		mainContent.setBackground(new Color(0, 128, 255));
		contentPane.add(mainContent, BorderLayout.CENTER);
		mainContent.add(currencyConverterPanel, "currency");
		mainContent.add(temperatureConverterPanel, "temperature");
		setContentPane(contentPane);

		
		// Empaquetar y centrar
		pack();
		setLocationRelativeTo(null);
	}
}
