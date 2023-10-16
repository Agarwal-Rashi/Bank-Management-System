package bank.management.syst;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
import java.awt.*;


public class Login extends JFrame implements ActionListener{

    JLabel label1 , label2 , label3 , label4;//global so that it can be used outside constructor
    JTextField text;
    JPasswordField password;
    JButton b1 , b2 , b3;
    Login(){
        super("Bank Management System");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 100 ,100);
        add(image);

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("Icons/card.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(90, 350, 100 ,100);
        add(iimage);

        //Text in the frame
        label1 = new JLabel("WELCOME TO SAFE & SECURE ATM");
        label1.setForeground(Color.black);
        label1.setFont(new Font("AvantGarde" , Font.BOLD , 20));
        label1.setBounds(210, 125, 450, 40);
        add(label1);

        label2 = new JLabel("CARD NO.");
        label2.setFont(new Font("Ralway" , Font.BOLD , 21));
        label2.setBounds(150, 190, 375, 30);
        add(label2);

        //Card No text field
        text = new JTextField(15);
        text.setBounds(325, 190, 230, 30);
        text.setFont(new Font("Arial" , Font.BOLD , 14));
        add(text);


        label3 = new JLabel("PIN NO.");
        label3.setFont(new Font("Ralway" , Font.BOLD , 21));
        label3.setBounds(150, 250, 375, 30);
        add(label3);

        //Add Password Field
        password = new JPasswordField(15);
        password.setBounds(325, 250, 230, 30);
        password.setFont(new Font("Arial" , Font.BOLD , 14));
        add(password);

        b1 = new JButton("SIGN IN");
        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setBounds(325, 320, 100, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("CLEAR");
        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setForeground(Color.RED);
        b2.setBackground(Color.WHITE);
        b2.setBounds(450, 320, 100, 30);
        b2.addActionListener(this);
        add(b2);

        label4 = new JLabel("New Customer?");
        label4.setFont(new Font("Ralway" , Font.BOLD , 14));
        label4.setBounds(10, 10, 375, 30);
        add(label4);
        b3 = new JButton("SIGN UP");
        b3.setFont(new Font("Arial", Font.BOLD, 14));
        b3.setForeground(Color.BLUE);
        b3.setBackground(Color.LIGHT_GRAY);
        b3.setBounds(10, 40, 100, 30);
        b3.addActionListener(this);
        add(b3);

        ImageIcon bg1 = new ImageIcon(ClassLoader.getSystemResource("Icons/backg.jpg"));
        Image bg2 = bg1.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
        ImageIcon bg3 = new ImageIcon(bg2);
        JLabel bgimage = new JLabel(bg3);//to add the image in the frame
        bgimage.setBounds(0, 0, 850 ,480);//to give location to the image
        add(bgimage);

        setLayout(null);
        setSize(850, 480);
        setLocation(450, 200);
        setUndecorated(true);
        setVisible(true);//always write this at the bottom to make things visible

    }
    //To make the buttons work
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource() == b1){
                conn c = new conn();
                String cardno = text.getText();
                String pin = password.getText();
                String q = "Select * from login where card_no = '"+cardno+"' and pin = '"+pin+"'";
                ResultSet result = c.statement.executeQuery(q);
                if(result.next()){
                    setVisible(false);
                    new main_class(pin);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect card no. or pin");;
                }





            }else if (e.getSource() == b2){
                text.setText("");
                password.setText("");

            }else if (e.getSource() == b3){
                new SignUp();
                setVisible(false);

            }

        }catch(Exception E){
            E.printStackTrace();
        }

    }
    public static void main(String[] args) {
        new Login();
    }
}