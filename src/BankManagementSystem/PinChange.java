package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class PinChange extends JFrame implements ActionListener {
    JPasswordField newPinField,newPinConfirmField;
    JButton save,back;    
    String pin;

    PinChange(String pin) {
        this.pin = pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Change Your PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(235,300,700,35);
        image.add(text);

        JLabel pin_text = new JLabel("New PIN:");
        pin_text.setForeground(Color.WHITE);
        pin_text.setFont(new Font("System", Font.BOLD, 16));
        pin_text.setBounds(165,350,180,25);
        image.add(pin_text);

        newPinField = new JPasswordField();
        newPinField.setFont(new Font("Raleway", Font.BOLD, 25));
        newPinField.setBounds(320,350,180,25);
        image.add(newPinField);

        JLabel re_pin_text = new JLabel("Re-enter New PIN:");
        re_pin_text.setForeground(Color.WHITE);
        re_pin_text.setFont(new Font("System", Font.BOLD, 16));
        re_pin_text.setBounds(165,400,180,25);
        image.add(re_pin_text);

        newPinConfirmField = new JPasswordField();
        newPinConfirmField.setFont(new Font("Raleway", Font.BOLD, 25));
        newPinConfirmField.setBounds(320,400,180,25);
        image.add(newPinConfirmField);

        save = new JButton("Save PIN");
        save.setBounds(355, 485, 150, 30);
        save.addActionListener(this);
        image.add(save);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == save){
            
        }
        else {
            String npin = newPinField.getText();
            String rpin = newPinConfirmField.getText();

            if (npin.equals("")){
                JOptionPane.showMessageDialog(null, "Enter New PIN");
            }
            else if (rpin.equals("")){
                JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
            }
            else if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            else {
                try {
                    Conn c = new Conn();
                    String q1 = "update bank set pin = '"+rpin+"' where pin = '"+pin+"' ";
                    String q2 = "update login set pin = '"+rpin+"' where pin = '"+pin+"' ";
                    String q3 = "update signupthree set pin = '"+rpin+"' where pin = '"+pin+"' ";

                    c.s.executeUpdate(q1);
                    c.s.executeUpdate(q2);
                    c.s.executeUpdate(q3);

                    JOptionPane.showMessageDialog(null, "PIN changed successfully");
                    setVisible(false);
                    new Transactions(rpin).setVisible(true);

                }catch(Exception e){
                    System.out.println(e);
                }
            }

        }
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }

    public static void main(String[] args) {
        new PinChange("");
    }
}
