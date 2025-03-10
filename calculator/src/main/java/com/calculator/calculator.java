package com.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
    // ActionListener is to define what should be done when an user performs certain operation.
    public class calculator implements ActionListener{
    // Declaring everything that we will need    
    // our frame
    JFrame frame;
    // we need a textField
    JTextField textField;
    // these are array for number buttons that holds all number buttons
    JButton[] numberButtons = new JButton[10];
    // these are arrays for function buttons that hold all functions buttons
    JButton[] functionButtons = new JButton[9];
    // naming all functions buttons
    JButton addButton, subButton, mulButton, divButton, negButton;
    // the same thing just add it to new line to make it more organized
    JButton decButton, eqButton, delButton, clrButton;
    // the JPanel is to hold all the buttons
    JPanel panel;
    
    // We only use one font in this calculator so we might as well declare our font
    // we make it bold and size of the font
    Font myFont = new Font("Serif", Font.BOLD,30);
    // we set 3 number the first number that will be enter into the cal = 0 and the second number = 0 and result = 0
    double num1 = 0, num2 = 0, result = 0;
    // and we declare the operator as char because it is only one character 
    char operator;

    calculator(){
        // we are setting up the frame of the calculator
        // so we call the object frame and the description of the frame is Calculator
        frame = new JFrame("Calculator");
        // the frame comes with the close button the minimizer and everything but we need to add th defaultcloseoperation thingi every when we close it it will also stop running the code if not it will continue to run the code even after we close the program
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);
        // this is setting up the text field which is the box on the top of the thing to display result and number that we have inserted into the function
        textField = new JTextField();
        // set bounds is just setting the size of the box 
        // x, y, width, height 
        // x and y is the axys
        textField.setBounds(50,25,300,50);
        // and set the font inside the textField into our font that we choose 
        textField.setFont(myFont);
        // make it false in editable makes it so that we can't click and type on the text field and only display the number and the result 
        textField.setEditable(false);

        // now we have to make the button for function button
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        eqButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        negButton = new JButton("(-)");
        
        // and then we put all the button we made into the array of functionbuttons
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = eqButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        // once it's already been put into the array to call all of it we must use a loop and loop all of it 
        for(int i = 0; i < 9 ; i++){
            // so right now we just add all the button to the ActionListener 
            functionButtons[i].addActionListener(this);
            // setting the button with the same font we use
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }
        // now for the number button we don't have to make all the button one by one like the functionbutton
        for(int i = 0; i < 10 ; i++){
            // once the loop is call the number from 0-9 will run out
            // once that happen the number will be set to be a new Jbutton that has the value of each and indivual i that was loop 0-9
            numberButtons[i] = new JButton(String.valueOf(i));
            // and then we set each button with the same thing as we did on the top by adding it to the ActionListener 
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }
        // because the delete and clear button will be bigger than other function button we have to set it its own bound
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);
        negButton.setBounds(50,430,100,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.GRAY);
        
        // now we add the button into the panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(eqButton);
        panel.add(divButton);
        // Now add the panel to the frame
        frame.add(panel);
        // after that we add it to the frame
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        // add the textField to the frame
        frame.add(textField);
        frame.setVisible(true);
    }
    // The Main function
    public static void main(String[] args) {
        new calculator();
    }
    // in the actionPerformed part we have to add all the action that we need to perform 
    @Override
    public void actionPerformed(ActionEvent e){
        // loop the number from 0-9 and if the number that was clicked = to the number of the numberButtons that we put it in order of 0-9 it will be put in the textField 
        for(int i = 0; i < 10; i++){
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        // place decimal into the textField
        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }
        // turn num1 from text to double variable, set operator to + and make it so that when we press + the text field has nothing
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        // turn num1 from text to double variable, set operator to - and make it so that when we press - the text field has nothing
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        // turn num1 from text to double variable, set operator to * and make it so that when we press * the text field has nothing
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        // turn num1 from text to double variable, set operator to / and make it so that when we press / the text field has nothing
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        // when = is input in the source field the second number that we later input is turned into a double from text
        if (e.getSource() == eqButton) {
            num2 = Double.parseDouble(textField.getText());
        // and when the second number is entered the switch operator will start its thing by calculating the result depends on the operator
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            // once it is finished the value of the result is then put into the text field
            textField.setText(String.valueOf(result));
            // then the result get changed into num1 incase we want to continue the calculating
            num1 = result;
        }
        // clear the text in the text field
        if (e.getSource() == clrButton) {
            textField.setText("");
        }

        if (e.getSource() == delButton) {
            // first we move the value of the text in the textField into a object
            String d = textField.getText();
            // and it clears everything in the textField but only temporary
            textField.setText("");
            // then we loop the text of the textField but minus the last character
            for(int i = 0; i < d.length()-1; i++){
                // then we set the next text in the textField
                textField.setText(textField.getText()+ d.charAt(i));
            }
        }
        
        if (e.getSource() == negButton){
            // make a temporary object and turn the text in the textField into double and store it in the temp object
            double temp = Double.parseDouble(textField.getText());
            // then time it by -1
            temp *= -1;
            // place it back into the field
            textField.setText(String.valueOf(temp));
        }
    }
}