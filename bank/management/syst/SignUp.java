package bank.management.syst;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.sql.*;


import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SignUp extends JFrame implements ActionListener {

    JRadioButton r1,r2,m1,m2,m3;
    JTextField name ,fname ,email,addr,city,pin,state;
    JDateChooser datechooser;
    JButton next;

    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L)+1000L;
    String first = " "+Math.abs(first4);

    SignUp(){
        super("APPLICATION FORM");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25, 10, 100 ,100);
        add(image);

        JLabel  label1 = new JLabel("APPLICATION FORM NO."+first);
        label1.setBounds(160, 20, 600, 40);
        label1.setFont(new Font("Ralway", Font.BOLD, 38));
        add(label1);

        JLabel label2 = new JLabel("Page 1");
        label2.setFont(new Font("Ralway", Font.ROMAN_BASELINE, 12));
        label2.setBounds(790, 40,600, 30);
        add(label2);

        JLabel label3 = new JLabel("Personal Details");
        label3.setFont(new Font("Ralway", Font.BOLD, 22));
        label3.setBounds(350, 90, 600, 30);
        add(label3);

        JLabel labelname = new JLabel("Name");
        labelname.setFont(new Font("Raleway", Font.BOLD, 20));
        labelname.setBounds(100, 190, 100, 30);
        add(labelname);
        name = new JTextField();
        name.setFont(new Font("Raleway", Font.BOLD, 14));
        name.setBounds(300, 190, 400, 30);
        add(name);

        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setFont(new Font("Raleway", Font.BOLD, 20));
        labelfname.setBounds(100, 240, 300, 30);
        add(labelfname);
        fname = new JTextField();
        fname.setFont(new Font("Raleway", Font.BOLD, 14));
        fname.setBounds(300, 240, 400, 30);
        add(fname);

        JLabel labeldob = new JLabel("Date Of Birth");
        labeldob.setFont(new Font("Raleway", Font.BOLD, 20));
        labeldob.setBounds(100, 340, 200, 30);
        add(labeldob);
        datechooser = new JDateChooser();
        datechooser.setForeground(new Color(105,105,105));
        datechooser.setBounds(300,340,400,30);
        add(datechooser);

        JLabel labelG = new JLabel("Gender");
        labelG.setFont(new Font("Raleway", Font.BOLD, 20));
        labelG.setBounds(100, 290, 200, 30);
        add(labelG);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway", Font.BOLD, 20));
        r1.setBounds(300, 290, 90, 30);
        r1.setBackground(new Color(222,255,228));
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway", Font.BOLD, 20));
        r2.setBounds(450, 290, 100, 30);
        r2.setBackground(new Color(222,255,228));
        add(r2);
        //to select either of the option
        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        JLabel labelemail = new JLabel("Email Address");
        labelemail.setFont(new Font("Raleway", Font.BOLD, 20));
        labelemail.setBounds(100, 390, 200, 30);
        add(labelemail);

        email = new JTextField();
        email.setFont(new Font("Raleway", Font.BOLD, 14));
        email.setBounds(300, 390, 400, 30);
        add(email);

        JLabel labelmar = new JLabel("Marital Status");
        labelmar.setFont(new Font("Raleway", Font.BOLD, 20));
        labelmar.setBounds(100, 440,200,30);
        add(labelmar);
        m1 = new JRadioButton("Married");
        m1.setFont(new Font("Raleway", Font.BOLD, 20));
        m1.setBounds(300, 440, 100, 30);
        m1.setBackground(new Color(222,255,228));
        add(m1);
        m2 = new JRadioButton("Unmarried");
        m2.setFont(new Font("Raleway", Font.BOLD, 20));
        m2.setBounds(450, 440, 200, 30);
        m2.setBackground(new Color(222,255,228));
        add(m2);
        m3 = new JRadioButton("Other");
        m3.setFont(new Font("Raleway", Font.BOLD, 20));
        m3.setBounds(645, 440, 100, 30);
        m3.setBackground(new Color(222,255,228));
        add(m3);
        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(m1);
        bg1.add(m2);
        bg1.add(m3);


         JLabel labeladd = new JLabel("Address");
        labeladd.setFont(new Font("Raleway", Font.BOLD, 20));
        labeladd.setBounds(100, 490,200,30);
        add(labeladd);
        addr = new JTextField();
        addr.setFont(new Font("Raleway", Font.BOLD, 14));
        addr.setBounds(300, 490, 400, 30);
        add(addr);

         JLabel labelcity = new JLabel("City");
        labelcity.setFont(new Font("Raleway", Font.BOLD, 20));
        labelcity.setBounds(100, 540,200,30);
        add(labelcity);
        city = new JTextField();
        city.setFont(new Font("Raleway", Font.BOLD, 14));
        city.setBounds(300, 540, 400, 30);
        add(city);

         JLabel labelpin = new JLabel("PinCode");
        labelpin.setFont(new Font("Raleway", Font.BOLD, 20));
        labelpin.setBounds(100, 590,200,30);
        add(labelpin);
        pin = new JTextField();
        pin.setFont(new Font("Raleway", Font.BOLD, 14));
        pin.setBounds(300, 590, 400, 30);
        add(pin);

         JLabel labelst = new JLabel("State");
        labelst.setFont(new Font("Raleway", Font.BOLD, 20));
        labelst.setBounds(100, 640,200,30);
        add(labelst);
        state = new JTextField();
        state.setFont(new Font("Raleway", Font.BOLD, 14));
        state.setBounds(300, 640, 400, 30);
        add(state);


        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620, 710, 80, 30);
        next.addActionListener(this);
        add(next);








        getContentPane().setBackground(new Color(222,255,228));
        setLayout(null);
        setSize(850, 800);
        setLocation(360, 40);
        setVisible(true);


    }

   

@Override
public void actionPerformed(ActionEvent e) {
    String formno = first;
    String tname = name.getText();
    String faname = fname.getText();
    String dob = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
    String tgender = null;
    if(r1.isSelected()){
        tgender = "Male";

    }
    else if (r2.isSelected()){
        tgender = "Female";
    }

    String temail = email.getText();
    String marital = null;
    if(m1.isSelected()){
        marital = "Married";
    }
    else if(m2.isSelected()){
        marital = "UnMarried";
    }
    else if(m3.isSelected()){
        marital = "Other";
    }
    String add = addr.getText();
    String tcity = city.getText();
    String tpin = pin.getText();
    String tstate = state.getText();
    try{
        if(name.getText().equals("")){
            JOptionPane.showMessageDialog(null , "Fill all the fields.");
        }
        else{
            conn con1 = new conn();
            String q = "INSERT INTO signup VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = con1.prepareStatement(q);
            preparedStatement.setString(1, formno);
            preparedStatement.setString(2, tname);
            preparedStatement.setString(3, faname);
            preparedStatement.setString(4, dob);
            preparedStatement.setString(5, tgender);
            preparedStatement.setString(6, temail);
            preparedStatement.setString(7, marital);
            preparedStatement.setString(8, add);
            preparedStatement.setString(9, tcity);
            preparedStatement.setString(10, tpin);
            preparedStatement.setString(11, tstate);
    
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Data inserted successfully.");
                new SignUp2(formno);
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Failed to insert data.");
            }
        }
    } catch (Exception E) {
        E.printStackTrace();
    }

        }
        public static void main(String args[]){
            new SignUp();
        }
    }


