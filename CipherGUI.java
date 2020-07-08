/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cipher;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Ashad Nadeem
 */
public class CipherGUI extends JFrame {
    private static final int width = 500;
    private static final int hieght = 300;
    private JLabel introL, TextL , ETextL,ShiftL;
    private JTextField TextTF , ETextTF,ShiftTF;
    private JButton exitB, encryptB, decryptB;
    private ExitButtonHandler ebHandler;
    private EncryptButtonHandler encbHandler;
    private DecryptButtonHandler decbHandler;
    
    public CipherGUI(){
        //JLabel
        setTitle("Encryption-Decryption by ASHCorp");
        introL = new JLabel("ThankYou for using EncryptionConverter",SwingConstants.CENTER);
        TextL = new JLabel("Your Plain Text: ",SwingConstants.RIGHT);
        ETextL = new JLabel("Your Encrypted Text: ",SwingConstants.RIGHT);
        ShiftL = new JLabel("Enter Your Key: ",SwingConstants.RIGHT);
        
        //JText Feild
        TextTF = new JTextField();
        ETextTF = new JTextField();
        ShiftTF = new JTextField();
        
        //JButton
        exitB = new JButton("Exit");
        exitB.setBackground(Color.red);
        ebHandler = new ExitButtonHandler();
        exitB.addActionListener(ebHandler);
        
        encryptB = new JButton("Encrypt");
        encryptB.setBackground(Color.green);
        encbHandler = new EncryptButtonHandler();
        encryptB.addActionListener(encbHandler);
        
        decryptB = new JButton("Decrypt");
        decryptB.setBackground(Color.ORANGE);
        decbHandler = new DecryptButtonHandler();
        decryptB.addActionListener(decbHandler);
        
        //pane
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(5,1));
        pane.add(TextL);
        pane.add(TextTF);
        pane.add(ShiftL);
        pane.add(ShiftTF);
        pane.add(ETextL);
        pane.add(ETextTF);
        pane.add(encryptB);
        pane.add(decryptB);
        pane.add(introL);
        pane.add(exitB);
        setSize(width,hieght);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    private class ExitButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent press){System.exit(0);}
    }
    private class EncryptButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent press){
            String text = TextTF.getText();
            int key = (int)Integer.parseInt(ShiftTF.getText());
            Cipher obj = new Cipher(text,key);
            TextTF.setText(obj.Hide());
            ShiftTF.setText("##");
            ETextTF.setText(obj.Encrypt());
            
        }
    }
    private class DecryptButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent press){
            String text = ETextTF.getText();
            int key = (int)Integer.parseInt(ShiftTF.getText());
            Cipher obj = new Cipher(text,key);
            TextTF.setText(obj.Decrypt());}
    }
    
}
