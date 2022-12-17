package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton b1, b2, b3, b4, b5, b6, back;
    String pin;

    FastCash(String pin) {
        setLayout(null);
        this.pin = pin;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Select Withdrawl Amount");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(235,300,700,35);
        image.add(text);

        b1 = new JButton("Rs 100");
        b1.setBounds(170,350,150,35);
        b1.addActionListener(this);
        image.add(b1);

        b2 = new JButton("Rs 500");
        b2.setBounds(360,350,150,35);
        b2.addActionListener(this);
        image.add(b2);

        b3 = new JButton("Rs 1000");
        b3.setBounds(170,400,150,35);
        b3.addActionListener(this);
        image.add(b3);

        b4 = new JButton("Rs 2000");
        b4.setBounds(360,400,150,35);
        b4.addActionListener(this);
        image.add(b4);

        b5 = new JButton("Rs 5000");
        b5.setBounds(170,450,150,35);
        b5.addActionListener(this);
        image.add(b5);

        b6 = new JButton("Rs 10000");
        b6.setBounds(360,450,150,35);
        b6.addActionListener(this);
        image.add(b6);

        back = new JButton("EXIT");
        back.setBounds(360,500,150,35);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
        else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            if(amount.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
            }
            else {
                try {
                    Conn c = new Conn();
                    String query1 =  "SELECT * FROM bank WHERE pin = '"+pin+"'";
                    ResultSet rs = c.s.executeQuery(query1);
                    int balance = 0;
                    while (rs.next()) {
                        if (rs.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(rs.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
    
                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }
                    Date date = new Date();
                    String query2 = "INSERT INTO bank VALUES('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')";
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                        
                    setVisible(false);
                    new Transactions(pin).setVisible(true);

                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
