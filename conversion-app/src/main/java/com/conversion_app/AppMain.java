package com.conversion_app;

import java.awt.EventQueue;

import com.conversion_app.ui.HomePage;

public class AppMain {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }

}
