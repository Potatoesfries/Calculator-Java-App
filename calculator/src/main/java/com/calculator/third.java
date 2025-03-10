package com.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class third implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton, decButton, eqButton, delButton, clrButton, negButton;
    JPanel panel;

    Font buttonFont = new Font("SansSerif", Font.BOLD, 24);
    Font textFont = new Font("SansSerif", Font.BOLD, 36);

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    third() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(30, 30, 30)); // Dark grey background

        textField = new JTextField();
        textField.setBounds(30, 30, 340, 60);
        textField.setFont(textFont);
        textField.setBackground(new Color(20, 20, 20));
        textField.setForeground(Color.WHITE);
        textField.setCaretColor(Color.WHITE);
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);

        addButton = createButton("+", new Color(255, 159, 10)); // Orange
        subButton = createButton("-", new Color(255, 159, 10)); 
        mulButton = createButton("x", new Color(255, 159, 10));
        divButton = createButton("÷", new Color(255, 159, 10));
        decButton = createButton(".", new Color(80, 80, 80)); // Dark grey
        eqButton = createButton("=", new Color(255, 159, 10)); 
        delButton = createButton("Del", new Color(80, 80, 80)); 
        clrButton = createButton("AC", new Color(255, 69, 58)); // Red
        negButton = createButton("±", new Color(80, 80, 80));

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = eqButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        for (JButton button : functionButtons) {
            button.addActionListener(this);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = createButton(String.valueOf(i), new Color(60, 60, 60)); // Medium grey
            numberButtons[i].addActionListener(this);
        }

        panel = new JPanel();
        panel.setBounds(30, 100, 340, 440);
        panel.setLayout(new GridLayout(5, 4, 10, 10));
        panel.setBackground(new Color(30, 30, 30)); // Match background

        // Add buttons to the panel in a calculator layout
        panel.add(clrButton);
        panel.add(delButton);
        panel.add(negButton);
        panel.add(divButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[0]);
        panel.add(decButton);
        panel.add(eqButton);

        frame.add(textField);
        frame.add(panel);
        frame.setVisible(true);
    }

    private JButton createButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setFont(buttonFont);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(new Color(30, 30, 30))); // Seamless buttons
        return button;
    }

    public static void main(String[] args) {
        new third();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        if (e.getSource() == eqButton) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': result = num1 / num2; break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }

        if (e.getSource() == clrButton) {
            textField.setText("");
        }

        if (e.getSource() == delButton) {
            String text = textField.getText();
            textField.setText(text.length() > 0 ? text.substring(0, text.length() - 1) : "");
        }

        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
    }
}
