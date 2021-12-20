/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator_full;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author wku-cslab1
 */
public class Calculator_Full implements ActionListener {

    /**
     * @param args the command line arguments
     */
    JFrame frame ;
    JTextField textField;
    JButton [] numberButtons=new JButton[10];
    JButton [] functionButtons = new JButton[9];
    JButton addButton,subButton,divButton,mulButton;
    JButton decButton,equButton,delButton,clrButton,negButton;
    JPanel panel;
    Font myFont = new Font("Impact",Font.ITALIC,25);
    double num1=0,num2=0,result=0;
    char operator;
    
    Calculator_Full (){
        frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit on close
        frame.setSize(420,550);
        frame.setLayout(null);
        frame.setTitle("MyCalculator");
        frame.setResizable(false);
        // textField
        textField = new JTextField();
        textField.setBounds(50, 25, 300,50 );
        textField.setFont(myFont);
        textField.setEditable(false); // to ristrict user from inputing outside of the buttons
        // function buttons on the calc 
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        negButton = new JButton("(-)");
        // ad to the function Buttons array
        functionButtons [0] = addButton;     
        functionButtons [1] = subButton;
        functionButtons [2] = mulButton;
        functionButtons [3] = divButton;
        functionButtons [4] = decButton;
        functionButtons [5] = equButton;
        functionButtons [6] = delButton;
        functionButtons [7] = clrButton;
        functionButtons [8] = negButton;
        for(int i=0;i<9;i++){
        functionButtons[i].addActionListener(this); //add action listener on all function buttons
        functionButtons[i].setFont(myFont);// set my custom font on the buttons
        functionButtons[i].setFocusable(false); //to stop the square focus on thr button
        }
     
        for(int i=0;i<10;i++){
        numberButtons[i] = new JButton(String.valueOf(i));
        numberButtons[i].addActionListener(this); //add action listener on all number buttons
        numberButtons[i].setFont(myFont);
        numberButtons[i].setFocusable(false);
        
        
        }
        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150,430,100,50);       
        clrButton.setBounds(250,430,100,50);
        String Negus;
        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.LIGHT_GRAY);
        // add the Buttons to the panel
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
        panel.add(divButton);
        panel.add(equButton);


        
        
        frame.add(negButton);
        frame.add(panel);
        frame.add(delButton);        
        frame.add(clrButton);
        frame.add(textField); //add the text field to the frame
        
        
        
        frame.setVisible(true);
        
        
        
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Calculator_Full Calc = new Calculator_Full();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<10;i++){
            if(e.getSource() == numberButtons[i]){
                 textField.setText(textField.getText().concat(String.valueOf(i)));
             }
        }
        if(e.getSource() == decButton){
                 textField.setText(textField.getText().concat("."));
             }
        if(e.getSource() == addButton){
                num1 = Double.parseDouble(textField.getText());// to retrive the pushed numbers
                operator = '+';// assign the operator on the add button push
                textField.setText("");  // make the TextField clear to empty string
             }
        if(e.getSource() == subButton){
                num1 = Double.parseDouble(textField.getText());// to retrive the pushed numbers
                operator = '-';// assign the operator on the add button push
                textField.setText("");  // make the TextField clear to empty string
             }
        if(e.getSource() == mulButton){
                num1 = Double.parseDouble(textField.getText());// to retrive the pushed numbers
                operator = '*';// assign the operator on the add button push
                textField.setText("");  // make the TextField clear to empty string
             }
        if(e.getSource() == divButton){
                num1 = Double.parseDouble(textField.getText());// to retrive the pushed numbers
                operator = '/';// assign the operator on the add button push
                textField.setText("");  // make the TextField clear to empty string
             }
        if(e.getSource() == equButton){
        num2 = Double.parseDouble(textField.getText());
        
        switch(operator){
            
            case '+':
                result = num1+num2;
                break;
            case '-':
                result = num1-num2;
                break;
            case '*':
                result = num1*num2;
                break;
            case '/':
                result = num1/num2;
                break;
                
        }
        textField.setText(String.valueOf(result)); t//to show the answer after the swicth 
        num1 = result; // to make more operataion  
        }
        if(e.getSource() == clrButton){
        textField.setText("");
        }
        if(e.getSource() == delButton){
        String del = textField.getText();
        textField.setText(""); // set empty for a momenent 
        for(int i=0;i<del.length()-1;i++){// conditon to run till the length - 1 of the numbers
        textField.setText(textField.getText()+del.charAt(i));} //concatinate with rthe empty string the string of the condition 
    
        }
        if(e.getSource() == negButton){
            Double temp = Double.parseDouble(textField.getText());
            temp*=-1;
            textField.setText(String.valueOf(temp));
            
            
            
        }
        
        
        
    }
    
}
