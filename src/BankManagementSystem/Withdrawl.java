package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener {

    String pin;
    JTextField amountTextField;
    JButton withdrawl, back;

    Withdrawl(String pin) {
        this.pin = pin;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Osward", Font.BOLD, 30));
        text.setForeground(Color.WHITE);
        text.setBounds(200,300,450,40);
        image.add(text);

        amountTextField = new JTextField();
        amountTextField.setFont(new Font("Raleway", Font.BOLD, 22));
        amountTextField.setBounds(180,380,320,30);
        image.add(amountTextField);

        withdrawl = new JButton("Withdraw");
        withdrawl.setBounds(355, 485, 150, 30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

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
        if(ae.getSource() == withdrawl){
            String amount = amountTextField.getText();
            Date date = new Date();

            if(amount.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the Amount you want to Withdraw");
            }
            else {
                try {
                    Conn c = new Conn();
                    String query1 = "select * from bank where pin = '"+pin+"'";
                    ResultSet rs = c.s.executeQuery(query1);
                    int balance = 0;

                    while(rs.next()){
                        if(rs.getString("type").equals("Deposit")){
                            balance += Integer.parseInt(rs.getString("amount"));
                        }else{
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }

                    if(balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }
                    String query2 = "INSERT INTO bank VALUES('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')";
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Withdrawled Successfully");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        else if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Withdrawl("");
    }
}
