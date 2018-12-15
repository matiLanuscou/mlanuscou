package com.r2.crypto.main;


import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.r2.crypto.func.Decrypt;

public class Windows extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private Decrypt decrypt;
	private JTextArea encriptedText;
	private JTextArea decriptedText;
	private JTextField keyText;

	public static void main(String[] args) {
		Windows myWindows = new Windows();
		myWindows.setVisible(true);
	}

	public Windows() {
		Dimension d = new Dimension();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocation((int) ((d.getWidth() / 2) + 290), 50);
		this.setSize(500, 650);
		this.setVisible(true);
		initComponents();
		setTitle("R2 : Decrypt Test");
		setSize(700, 500);
		setLocationRelativeTo(null);
		decrypt = new Decrypt();
		//keyText.setText(decrypt.getPass());
	}

	public void initComponents() {

		Container container = this.getContentPane();
		container.setLayout(null);

		JButton decryptButton = new JButton();
		decryptButton.setText("Decrypt");
		decryptButton.setBounds(380, 210, 80, 23);
		decryptButton.addActionListener(this);
		
		JButton encryptButton = new JButton();
		encryptButton.setText("Encrypt");
		encryptButton.setBounds(480, 210, 80, 23);
		encryptButton.addActionListener(this);

		JLabel labelTitulo = new JLabel();
		labelTitulo.setText("Encripted text:");
		labelTitulo.setBounds(30, 20, 180, 23);
		
		JLabel keyTitle = new JLabel();
		keyTitle.setText("Key:");
		keyTitle.setBounds(30, 210, 180, 23);

		encriptedText = new JTextArea();
		encriptedText.setBounds(30, 50, 630, 150);
		encriptedText.setLineWrap(true);
		
		decriptedText = new JTextArea();
		decriptedText.setBounds(30, 250, 630, 150);
		decriptedText.setLineWrap(true);
		
		keyText = new JTextField();
		keyText.setBounds(60, 210, 300, 25);
		
		container.add(labelTitulo);
		container.add(decryptButton);
		container.add(encryptButton);
		container.add(encriptedText);
		container.add(decriptedText);
		container.add(keyText);
		container.add(keyTitle);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//decriptedText.setText(decrypt.decrypt(keyText.getText(),encriptedText.getText()));
		JButton pressed = (JButton) e.getSource();
		
		switch (pressed.getText()) {
		case "Decrypt":
			decriptedText.setText(decrypt.decrypt2(keyText.getText(),encriptedText.getText()));
			break;
		case "Encrypt":
			decriptedText.setText(decrypt.encrypt(keyText.getText(),encriptedText.getText()));
			break;
		default:
			break;
		}
	}
}
