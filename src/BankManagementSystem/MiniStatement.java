package BankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {
    JButton close;
    String pin;

    MiniStatement(String pin){
        this.pin = pin;
        setLayout(null);
        setTitle("Mini Statement");

        JLabel statements = new JLabel();
        add(statements);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);

        JLabel cardno = new JLabel();
        cardno.setBounds(20, 80, 300, 20);
        add(cardno);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pin+"'");
            while(rs.next()){
                cardno.setText("Card Number:    " + rs.getString("card_number").substring(0, 4) + "XXXXXXXX" + rs.getString("card_number").substring(12));
            }
        }catch(Exception e){
            System.out.println(e);
        }

        int balance = 0;

        try{
            
            Conn c  = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin = '"+pin+"'");
            while(rs.next()){
                statements.setText(statements.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }

        statements.setBounds(20, 140, 400, 200);

        JLabel balance_details = new JLabel("Your total Balance is Rs "+balance);
        balance_details.setFont(new Font("System", Font.BOLD, 16));
        balance_details.setBounds(20, 400, 300, 20);
        add(balance_details);

        close = new JButton("BACK");
        close.setBounds(20, 500, 100, 25);
        close.addActionListener(this);
        add(close);

        setSize(400,600);
        setLocation(20,20);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }


    public static void main(String[] args) {
        new MiniStatement("");
    }
}
