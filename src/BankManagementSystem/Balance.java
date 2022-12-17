package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;

public class Balance extends JFrame implements ActionListener {
    String pin;
    JButton back;

    Balance(String pin) {
        this.pin = pin;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        back = new JButton("BACK");
        back.setBounds(350, 500, 150, 35);
        back.addActionListener(this);
        image.add(back);

        
        int balance = 0;
        try{
            Conn c = new Conn();
            
            String query = "SELECT * FROM bank WHERE pin = '"+pin+"'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        JLabel balance_details = new JLabel("Your Current Account Balance is Rs " + balance);
        balance_details.setForeground(Color.WHITE);
        balance_details.setFont(new Font("System", Font.BOLD, 16));
        balance_details.setBounds(170, 350, 400, 35);
        image.add(balance_details);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }

    public static void main(String[] args) {
        new Balance("");
    }
}
