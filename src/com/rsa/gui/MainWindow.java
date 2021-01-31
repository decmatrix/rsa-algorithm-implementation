package com.rsa.gui;

import com.rsa.core.RSA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    RSA rsa = new RSA();

    JTextArea textToEncryptArea;
    JTextArea resultArea;

    JScrollPane textEnc;
    JScrollPane resText;

    JLabel status;

    JButton encryptButton;

    JPanel content;

    public MainWindow() {
        super("RSA Encrypter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initComponents();
        initAction();

        content.add(textEnc);
        content.add(resText);
        content.add(encryptButton);
        content.add(status);

        setContentPane(content);
        setSize(900,700);
        setResizable(false);
        setVisible(true);
    }

    private void initComponents() {
        content = new JPanel();
        status = new JLabel("");

        textToEncryptArea = new JTextArea("",10, 73);
        resultArea = new JTextArea(20,73);

        textEnc = new JScrollPane(textToEncryptArea);
        resText = new JScrollPane(resultArea);

        textEnc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        resText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        encryptButton = new JButton("Encrypt");
    }

    private void initAction() {
        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(textToEncryptArea.getText().equals("")) {
                    status.setText("Enter text, please!");
                    status.setForeground(Color.RED);
                } else{
                    rsa.rsa_encrypt(textToEncryptArea.getText() , resultArea);
                    status.setText("");
                }
            }
        });
    }
}
