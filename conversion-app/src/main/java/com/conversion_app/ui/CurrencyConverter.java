package com.conversion_app.ui;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Dimension;

import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.conversion_app.UrlDataFetcher;
import java.text.DecimalFormat;
import java.awt.Cursor;

@SuppressWarnings("serial")
public class CurrencyConverter extends JPanel {
	private String[] values = { "USD", "EUR", "GBP", "JPY", "KRW", "PEN" };

	private JComboBox<String> selector1;
	private JComboBox<String> selector2;

	private UrlDataFetcher data;
	private DecimalFormat decimalFormat;

	public CurrencyConverter() {
		// amount 22 - 133, from 143 - 177, selector 1 187 - 281, to 291 - 325, selector
		// 2 335 - 429
		data = new UrlDataFetcher();
		decimalFormat = new DecimalFormat("0." + "0".repeat(2));

		setBackground(new Color(255, 255, 255));
		setPreferredSize(new Dimension((int) (720 * 0.7), 480));
		setLayout(new BorderLayout());

		JPanel comboBoxPanel = new JPanel();
		comboBoxPanel.setBackground(new Color(238, 238, 238));
		comboBoxPanel.setLayout(null);

		selector1 = new JComboBox<>(values);
		selector1.setForeground(new Color(52, 62, 70));
		selector1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		selector1.setFont(new Font("Dialog", Font.PLAIN, 12));
		selector1.setBounds(221, 122, 94, 20);
		selector1.setSelectedIndex(0);
		comboBoxPanel.add(selector1);

		selector2 = new JComboBox<>(values);
		selector2.setForeground(new Color(52, 62, 70));
		selector2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		selector2.setFont(new Font("Dialog", Font.PLAIN, 12));
		selector2.setBounds(369, 122, 94, 20);
		selector2.setSelectedIndex(1);
		comboBoxPanel.add(selector2);

		add(comboBoxPanel, BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("Currency Converter");
		lblNewLabel.setBounds(0, 22, 503, 24);
		lblNewLabel.setForeground(new Color(57, 62, 70));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(new Color(255, 255, 255));

		comboBoxPanel.add(lblNewLabel);

		JTextField amount = new JTextField();
		amount.setForeground(new Color(52, 62, 70));
		amount.setFont(new Font("Dialog", Font.PLAIN, 12));
		amount.setBounds(22, 122, 111, 20);
		comboBoxPanel.add(amount);
		amount.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("From");
		lblNewLabel_1.setForeground(new Color(52, 62, 70));
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(143, 122, 68, 20);
		comboBoxPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("To");
		lblNewLabel_1_1.setForeground(new Color(52, 62, 70));
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(325, 122, 34, 20);
		comboBoxPanel.add(lblNewLabel_1_1);

		JButton convert = new JButton("Convert");
		convert.setForeground(new Color(52, 62, 70));
		convert.setFocusable(false);
		convert.setBorder(null);

		convert.setBounds(216, 181, 89, 23);
		comboBoxPanel.add(convert);

		JLabel exchangeRate = new JLabel("");
		exchangeRate.setForeground(new Color(34, 40, 49));
		exchangeRate.setFont(new Font("Dialog", Font.PLAIN, 15));
		exchangeRate.setBounds(22, 223, 455, 42);
		comboBoxPanel.add(exchangeRate);

		JLabel conversionResult = new JLabel("");
		conversionResult.setForeground(new Color(34, 40, 49));
		conversionResult.setFont(new Font("Dialog", Font.PLAIN, 15));
		conversionResult.setBounds(22, 267, 455, 42);
		comboBoxPanel.add(conversionResult);

		selector1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateList2();
			}
		});

		updateList2();

		convert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (amount.getText().trim().isEmpty()) {
					exchangeRate.setForeground(new Color(242, 53, 53));
					exchangeRate.setText("Amount is empty");
					conversionResult.setText("");
					return;
				}

				exchangeRate.setForeground(new Color(34, 40, 49));
				String from = (String) selector1.getSelectedItem();
				String to = (String) selector2.getSelectedItem();

				exchangeRate.setText("Exchange Rate: 1 " + from + " = "
						+ decimalFormat.format(Double.parseDouble(data.find(from, to))) + " " + to);

				String result = decimalFormat
						.format(Double.parseDouble(data.getResult()) * Double.parseDouble(amount.getText()));

				String auxAmount = amount.getText().startsWith(".") ? 0 + amount.getText() : amount.getText();

				conversionResult.setText("Conversion Result: " + auxAmount + " " + from + " = " + result + " " + to);
			}
		});

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
				exchangeRate.setText("");
				conversionResult.setText("");
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			}

		});
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
