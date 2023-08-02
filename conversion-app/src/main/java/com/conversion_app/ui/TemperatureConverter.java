package com.conversion_app.ui;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class TemperatureConverter extends JPanel {
	private String[] values = { "C - celsius", "F - fahrenheit", "K - kelvin" };

	private JTextField amount;
	private JComboBox<String> selector1;
	private JComboBox<String> selector2;
	private DecimalFormat decimalFormat;

	public TemperatureConverter() {

		decimalFormat = new DecimalFormat("0." + "0".repeat(2));

		setBackground(new Color(238, 238, 238));
		setPreferredSize(new Dimension((int) (720 * 0.7), 441));
		setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Temperature Converter");
		lblNewLabel_1.setBounds(0, 22, 503, 24);
		lblNewLabel_1.setForeground(new Color(57, 62, 70));
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		add(lblNewLabel_1);

		selector1 = new JComboBox<String>(values);
		selector1.setForeground(new Color(52, 62, 70));
		selector1.setFont(new Font("Dialog", Font.PLAIN, 12));
		selector1.setBounds(221, 122, 94, 20);
		selector1.setSelectedIndex(0);
		add(selector1);

		selector2 = new JComboBox<String>(values);
		selector2.setForeground(new Color(52, 62, 70));
		selector2.setFont(new Font("Dialog", Font.PLAIN, 12));
		selector2.setBounds(369, 122, 94, 20);
		selector2.setSelectedIndex(1);
		add(selector2);

		amount = new JTextField();
		amount.setForeground(new Color(52, 62, 70));
		amount.setFont(new Font("Dialog", Font.PLAIN, 12));
		amount.setBounds(22, 122, 111, 20);
		add(amount);

		JLabel lblNewLabel_1_1 = new JLabel("From");
		lblNewLabel_1_1.setForeground(new Color(52, 62, 70));
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(143, 122, 68, 20);
		add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("To");
		lblNewLabel_1_1_1.setForeground(new Color(52, 62, 70));
		lblNewLabel_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setBounds(325, 122, 34, 20);
		add(lblNewLabel_1_1_1);

		JButton convert = new JButton("Convert");
		convert.setForeground(new Color(52, 62, 70));
		convert.setFocusable(false);
		convert.setBorder(null);
		convert.setBounds(216, 181, 89, 23);
		add(convert);

		JLabel conversionResult = new JLabel("");
		conversionResult.setForeground(new Color(52, 62, 70));
		conversionResult.setFont(new Font("Dialog", Font.PLAIN, 15));
		conversionResult.setBounds(21, 200, 455, 42);
		add(conversionResult);

		amount.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyTyped(KeyEvent e) {
				char key = e.getKeyChar();

				boolean isNumberOrPoint = Character.isDigit(key) || key == '.';
				if (!isNumberOrPoint) {
					e.consume();
				} else if (key == '.' && amount.getText().contains(".")) {
					e.consume();
				}
				conversionResult.setText("");
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			}

		});

		updateList2();

		selector1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateList2();
			}
		});

		convert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Double result = 0.00;
				if (amount.getText().trim().isEmpty()) {
					conversionResult.setForeground(new Color(242, 53, 53));
					conversionResult.setText("Amount is empty");
					return;
				}

				conversionResult.setForeground(new Color(34, 40, 49));
				String from = (String) selector1.getSelectedItem();
				String to = (String) selector2.getSelectedItem();

				if (from.contains("C") && to.contains("F")) {
					result = celsiusToFarenheit(Double.parseDouble(amount.getText()));
				} else if (from.contains("C") && to.contains("K")) {
					result = celsiusToKelvin(Double.parseDouble(amount.getText()));
				} else if (from.contains("F") && to.contains("C")) {
					result = farenheitToCelsius(Double.parseDouble(amount.getText()));
				} else if (from.contains("F") && to.contains("K")) {
					result = farenheitToKelvin(Double.parseDouble(amount.getText()));
				} else if (from.contains("K") && to.contains("C")) {
					result = kelvinToCelsius(Double.parseDouble(amount.getText()));
				} else if (from.contains("K") && to.contains("F")) {
					result = kelvinToFarenheit(Double.parseDouble(amount.getText()));
				}

				conversionResult.setText(amount.getText() + "°" + from.charAt(0) + " = " + decimalFormat.format(result)
						+ "°" + to.charAt(0));
			}
		});
	}

	private double celsiusToFarenheit(Double celsius) {
		return (celsius * 9 / 5) + 32;
	}

	private double celsiusToKelvin(Double celsius) {
		return celsius + 273.15;
	}

	private double farenheitToCelsius(Double farenheit) {
		return (farenheit - 32) * 5 / 9;
	}

	private double farenheitToKelvin(Double farenheit) {
		return (farenheit - 32) + 273.15;
	}

	private double kelvinToCelsius(Double kelvin) {
		return kelvin - 273.15;
	}

	private double kelvinToFarenheit(Double kelvin) {
		return (kelvin - 273.15) * 9 / 5 + 32;
	}

	private void updateList2() {
		selector2.removeAllItems();

		for (String item : values) {
			if (!item.equals(selector1.getSelectedItem())) {
				selector2.addItem(item);
			}
		}
	}
}
