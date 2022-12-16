package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {

    String formno;
    JRadioButton saving, fixed, current, recurring;
    JCheckBox atm, internet_banking, mobile_banking, email_alerts, cheque_book, e_statement, declaration;
    JButton submit, cancel;

    SignupThree(String formno) {
        setLayout(null);
        this.formno = formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");

        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280,40,400,40);
        add(l1); 

        JLabel type = new JLabel("Account Type:");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100,140,200,30);
        add(type); 

        saving = new JRadioButton("Saving Account");
        saving.setFont(new Font("Raleway", Font.BOLD, 16));
        saving.setBackground(Color.WHITE);
        saving.setBounds(100,180,250,30);
        add(saving);

        fixed = new JRadioButton("Fixed Deposit Account");
        fixed.setFont(new Font("Raleway", Font.BOLD, 16));
        fixed.setBackground(Color.WHITE);
        fixed.setBounds(350,180,250,30);
        add(fixed);

        current = new JRadioButton("Current Account");
        current.setFont(new Font("Raleway", Font.BOLD, 16));
        current.setBackground(Color.WHITE);
        current.setBounds(100,220,250,30);
        add(current);

        recurring = new JRadioButton("Recurring Deposit Account");
        recurring.setFont(new Font("Raleway", Font.BOLD, 16));
        recurring.setBackground(Color.WHITE);
        recurring.setBounds(350,220,250,30);
        add(recurring);

        ButtonGroup typeGroup = new ButtonGroup();
        typeGroup.add(saving);
        typeGroup.add(fixed);
        typeGroup.add(current);
        typeGroup.add(recurring);

        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100,300,200,30);
        add(card);

        JLabel cardDetails = new JLabel("Your 16 digit card number");
        cardDetails.setFont(new Font("Raleway", Font.BOLD, 12));
        cardDetails.setBounds(100,330,300,30);
        add(cardDetails);
        
        JLabel c_number = new JLabel("XXXX-XXXX-XXXX-XXXX");
        c_number.setFont(new Font("Raleway", Font.BOLD, 22));
        c_number.setBounds(330,300,300,30);
        add(c_number);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100,370,200,30);
        add(pin);

        JLabel pinDetails = new JLabel("Your 4 digit PIN");
        pinDetails.setFont(new Font("Raleway", Font.BOLD, 12));
        pinDetails.setBounds(100,400,300,30);
        add(pinDetails);
        
        JLabel p_number = new JLabel("XXXX");
        p_number.setFont(new Font("Raleway", Font.BOLD, 22));
        p_number.setBounds(330,370,300,30);
        add(p_number);

        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100,440,300,30);
        add(services);

        atm = new JCheckBox("ATM CARD");
        atm.setBackground(Color.WHITE);
        atm.setFont(new Font("Raleway", Font.BOLD, 16));
        atm.setBounds(100,500,200,30);
        add(atm);

        internet_banking = new JCheckBox("Internet Banking");
        internet_banking.setBackground(Color.WHITE);
        internet_banking.setFont(new Font("Raleway", Font.BOLD, 16));
        internet_banking.setBounds(300,500,200,30);
        add(internet_banking);

        mobile_banking = new JCheckBox("Mobile Banking");
        mobile_banking.setBackground(Color.WHITE);
        mobile_banking.setFont(new Font("Raleway", Font.BOLD, 16));
        mobile_banking.setBounds(100,550,200,30);
        add(mobile_banking);

        email_alerts = new JCheckBox("EMAIL Alerts");
        email_alerts.setBackground(Color.WHITE);
        email_alerts.setFont(new Font("Raleway", Font.BOLD, 16));
        email_alerts.setBounds(300,550,200,30);
        add(email_alerts);

        cheque_book = new JCheckBox("Cheque Book");
        cheque_book.setBackground(Color.WHITE);
        cheque_book.setFont(new Font("Raleway", Font.BOLD, 16));
        cheque_book.setBounds(100,600,200,30);
        add(cheque_book);

        e_statement = new JCheckBox("E-Statement");
        e_statement.setBackground(Color.WHITE);
        e_statement.setFont(new Font("Raleway", Font.BOLD, 16));
        e_statement.setBounds(300,600,200,30);
        add(e_statement);

        declaration = new JCheckBox("I hereby declares that the above entered details correct to th best of my knowledge.",true);
        declaration.setBackground(Color.WHITE);
        declaration.setFont(new Font("Raleway", Font.BOLD, 12));
        declaration.setBounds(80,680,600,30);
        add(declaration);

        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(250,750,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(420,750,100,30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);
        setSize(850,850);
        setLocation(350,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){

            String account_type = null;
            if(saving.isSelected()){ 
                account_type = "Saving Account";
            }
            else if(fixed.isSelected()){ 
                account_type = "Fixed Deposit Account";
            }
            else if(current.isSelected()){ 
                account_type = "Current Account";
            }else if(recurring.isSelected()){ 
                account_type = "Recurring Deposit Account";
            }
            
            Random random = new Random();
            String card_number = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
        
            String pin = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            
            String facility = "";
            if(atm.isSelected()){ 
                facility = facility + " ATM Card";
            }
            if(internet_banking.isSelected()){ 
                facility = facility + " Internet Banking";
            }
            if(mobile_banking.isSelected()){ 
                facility = facility + " Mobile Banking";
            }
            if(email_alerts.isSelected()){ 
                facility = facility + " EMAIL Alerts";
            }
            if(cheque_book.isSelected()){ 
                facility = facility + " Cheque Book";
            }
            if(e_statement.isSelected()){ 
                facility = facility + " E-Statement";
            }  
            
            try{
                if(account_type.equals("")){
                    JOptionPane.showMessageDialog(null, "Fill all the required fields");
                }else{
                    Conn c = new Conn();
                    String query1 = "INSERT INTO signupthree VALUES('"+formno+"','"+account_type+"','"+card_number+"','"+pin+"','"+facility+"')";  
                    String query2 = "INSERT INTO login VALUES('"+formno+"','"+card_number+"','"+pin+"')";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "Card Number: " + card_number + "\n Pin:"+ pin);
                    
                    // new Deposit(pin).setVisible(true);
                    // setVisible(false);
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource() == cancel) {
            System.exit(0);
        }
        
    }
    public static void main(String[] args) {
        new SignupThree("");
    }
}
