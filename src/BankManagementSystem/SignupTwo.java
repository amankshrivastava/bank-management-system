package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {

    JComboBox religionComboBox, categoryComboBox, incomeComboBox, educationComboBox, occupationComboBox;
    JTextField panTextField, aadharTextField;
    JButton next;
    JRadioButton senior_yes, senior_no, existing_acc_yes, existing_acc_no;
    String formno;
    
    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);
        setTitle("New Account Application Form - Page 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);

        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 22));
        religion.setBounds(100,140,200,30);
        add(religion);

        String valReligions[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religionComboBox = new JComboBox<>(valReligions);
        religionComboBox.setBounds(300,140,400,30);
        religionComboBox.setBackground(Color.WHITE);
        add(religionComboBox);

        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 22));
        category.setBounds(100,190,200,30);
        add(category);

        String valCategory[] = {"General","OBC","SC","ST","Other"};
        categoryComboBox = new JComboBox<>(valCategory);
        categoryComboBox.setBounds(300,190,400,30);
        categoryComboBox.setBackground(Color.WHITE);
        add(categoryComboBox);

        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 22));
        income.setBounds(100,240,200,30);
        add(income);

        String valIncome[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
        incomeComboBox = new JComboBox<>(valIncome);
        incomeComboBox.setBounds(300, 240, 400, 30);
        incomeComboBox.setBackground(Color.WHITE);
        add(incomeComboBox);

        JLabel educational = new JLabel("Educational:");
        educational.setFont(new Font("Raleway", Font.BOLD, 22));
        educational.setBounds(100,290,200,30);
        add(educational);

        String valEducation[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        educationComboBox = new JComboBox<>(valEducation);
        educationComboBox.setBounds(300, 290, 400, 30);
        educationComboBox.setBackground(Color.WHITE);
        add(educationComboBox);

        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 22));
        occupation.setBounds(100,340,200,30);
        add(occupation);

        String valOccupation[] = {"Salaried","Self-Employmed","Business","Student","Retired","Others"};
        occupationComboBox = new JComboBox<>(valOccupation);
        occupationComboBox.setBounds(300, 340, 400, 30);
        occupationComboBox.setBackground(Color.WHITE);
        add(occupationComboBox);

        JLabel pannumber = new JLabel("PAN Number:");
        pannumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pannumber.setBounds(100,390,200,30);
        add(pannumber);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(300,390,400,30);
        add(panTextField);

        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 22));
        aadhar.setBounds(100,440,200,30);
        add(aadhar);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(300,440,400,30);
        add(aadharTextField);

        JLabel senior_citizen = new JLabel("Senior Citizen:");
        senior_citizen.setFont(new Font("Raleway", Font.BOLD, 22));
        senior_citizen.setBounds(100,490,200,30);
        add(senior_citizen);

        senior_yes = new JRadioButton("Yes");
        senior_yes.setBounds(300, 490, 100, 30);
        senior_yes.setBackground(Color.WHITE);
        add(senior_yes);

        senior_no = new JRadioButton("No");
        senior_no.setBounds(450, 490, 100, 30);
        senior_no.setBackground(Color.WHITE);
        add(senior_no);

        ButtonGroup seniorCitizenGroup = new ButtonGroup();
        seniorCitizenGroup.add(senior_yes);
        seniorCitizenGroup.add(senior_no);

        JLabel existing_account = new JLabel("Existing Account:");
        existing_account.setFont(new Font("Raleway", Font.BOLD, 22));
        existing_account.setBounds(100,540,200,30);
        add(existing_account);

        existing_acc_yes = new JRadioButton("Yes");
        existing_acc_yes.setBounds(300, 540, 100, 30);
        existing_acc_yes.setBackground(Color.WHITE);
        add(existing_acc_yes);

        existing_acc_no = new JRadioButton("No");
        existing_acc_no.setBounds(450, 540, 100, 30);
        existing_acc_no.setBackground(Color.WHITE);
        add(existing_acc_no);

        ButtonGroup existingAccountGroup = new ButtonGroup();
        existingAccountGroup.add(existing_acc_yes);
        existingAccountGroup.add(existing_acc_no);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 600, 80, 30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(500,120);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String religion = (String)religionComboBox.getSelectedItem(); 
        String category = (String)categoryComboBox.getSelectedItem();
        String income = (String)incomeComboBox.getSelectedItem();
        String education = (String)educationComboBox.getSelectedItem();
        String occupation = (String)occupationComboBox.getSelectedItem();
        
        String pan = panTextField.getText();
        String aadhar = aadharTextField.getText();
        
        String scitizen = "";
        if(senior_yes.isSelected()){ 
            scitizen = "Yes";
        }
        else if(senior_no.isSelected()){ 
            scitizen = "No";
        }
           
        String eaccount = "";
        if(existing_acc_yes.isSelected()){ 
            eaccount = "Yes";
        }else if(existing_acc_no.isSelected()){ 
            eaccount = "No";
        }
        
        try{
            if(aadharTextField.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            }else{
                Conn c = new Conn();
                String query = "INSERT INTO signuptwo VALUES('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+aadhar+"','"+scitizen+"','"+eaccount+"')";
                c.s.executeUpdate(query);
                
                // new Signup3(formno).setVisible(true);
                // setVisible(false);
            }
                
      
            
        }catch(Exception e){
             e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SignupTwo("");
    }
}
