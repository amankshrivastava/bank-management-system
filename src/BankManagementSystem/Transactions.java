package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Transactions extends JFrame implements ActionListener {

    JButton deposit, withdrawl, fast_cash, mini_statement, pin_change, balance, exit;
    String pin;

    Transactions(String pin) {
        this.pin = pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Please Select Your Transaction");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(235,300,700,35);
        image.add(text);

        deposit = new JButton("DEPOSIT");
        deposit.setBounds(170,350,150,35);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("CASH WITHDRAWL");
        withdrawl.setBounds(360,350,150,35);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fast_cash = new JButton("FAST CASH");
        fast_cash.setBounds(170,400,150,35);
        fast_cash.addActionListener(this);
        image.add(fast_cash);

        mini_statement = new JButton("MINI STATEMENT");
        mini_statement.setBounds(360,400,150,35);
        mini_statement.addActionListener(this);
        image.add(mini_statement);

        pin_change = new JButton("PIN CHANGE");
        pin_change.setBounds(170,450,150,35);
        pin_change.addActionListener(this);
        image.add(pin_change);

        balance = new JButton("BALANCE ENQUIRY");
        balance.setBounds(360,450,150,35);
        balance.addActionListener(this);
        image.add(balance);

        exit = new JButton("EXIT");
        exit.setBounds(360,500,150,35);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        // if(ae.getSource()==deposit){ 
        //     setVisible(false);
        //     new Deposit(pin).setVisible(true);
        // }else if(ae.getSource()==b2){ 
        //     setVisible(false);
        //     new Withdrawl(pin).setVisible(true);
        // }else if(ae.getSource()==b3){ 
        //     setVisible(false);
        //     new FastCash(pin).setVisible(true);
        // }else if(ae.getSource()==b4){ 
        //     new MiniStatement(pin).setVisible(true);
        // }else if(ae.getSource()==b5){ 
        //     setVisible(false);
        //     new Pin(pin).setVisible(true);
        // }else if(ae.getSource()==b6){ 
        //     this.setVisible(false);
        //     new BalanceEnquiry(pin).setVisible(true);
        // }else if(ae.getSource()==b7){ 
        //     System.exit(0);
        // }
        if(ae.getSource()==exit){ 
            System.exit(0);
        }
        else if(ae.getSource()==deposit){ 
            setVisible(false);
            new Deposit(pin).setVisible(true);
        }else if(ae.getSource()==withdrawl){ 
            setVisible(false);
            new Withdrawl(pin).setVisible(true);
        }else if(ae.getSource()==fast_cash){ 
            setVisible(false);
            new FastCash(pin).setVisible(true);
        }else if(ae.getSource()==pin_change){ 
            setVisible(false);
            new PinChange(pin).setVisible(true);
        }else if(ae.getSource()==balance){ 
            this.setVisible(false);
            new Balance(pin).setVisible(true);
        }else if(ae.getSource()==mini_statement){ 
            new MiniStatement(pin).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Transactions("");
    }
}
