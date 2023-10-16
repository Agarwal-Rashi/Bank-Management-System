package bank.management.syst;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SignUp2 extends JFrame implements ActionListener {
    String formno;
    JComboBox comboBox , comboBox2 , comboBox3 , comboBox4 , comboBox5;
    JTextField textpan , textadhaar;
    JRadioButton r1 , r2 ,r3 ,r4;
    JButton next;


    SignUp2(String formno){
        super("APPLICATION FORM");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 5, 100 ,100);
        add(image);

        this.formno=formno;

        JLabel l1 = new JLabel("Page 2");
        l1.setFont(new Font("Raleway",Font.BOLD,12));
        l1.setBounds(780, 10,600,40);;
        add(l1);

        JLabel l2 = new JLabel("Additional Details ");
        l2.setFont(new Font("Raleway",Font.BOLD,22));
        l2.setBounds(350, 60,600,40);;
        add(l2);

        JLabel l3 = new JLabel("Religion ");
        l3.setFont(new Font("Raleway",Font.BOLD,18));
        l3.setBounds(100, 120,100,30);;
        add(l3);

        String religion[] = {"Select" ,"Hindu" , "Muslim" ,"Sikh" , "Christan" , "Others"};
        comboBox = new JComboBox(religion);
        comboBox.setBackground(new Color(195,203,194));
        comboBox.setFont(new Font("Raleway" , Font.BOLD , 14));
        comboBox.setBounds(350,120,320,30);
        add(comboBox);

        JLabel l4 = new JLabel("Category");
        l4.setFont(new Font("Raleway",Font.BOLD,18));
        l4.setBounds(100, 170,100,30);;
        add(l4);

        String category[] = {"Select" , "General" , "OBC" ,"SC" , "ST" , "Others"};
        comboBox2 = new JComboBox(category);
        comboBox2.setBackground(new Color(195,203,194));
        comboBox2.setFont(new Font("Raleway" , Font.BOLD , 14));
        comboBox2.setBounds(350,170,320,30);
        add(comboBox2);

        JLabel l5 = new JLabel("Income");
        l5.setFont(new Font("Raleway",Font.BOLD,18));
        l5.setBounds(100, 220,100,30);;
        add(l5);

        String Income[] = {"Select" , "NULL" , "Less than 150000" ,"Less than 250000" , "Upto 500000" , "Upto 1000000" , "More than 100000"};
        comboBox3 = new JComboBox(Income);
        comboBox3.setBackground(new Color(195,203,194));
        comboBox3.setFont(new Font("Raleway" , Font.BOLD , 14));
        comboBox3.setBounds(350,220,320,30);
        add(comboBox3);

        JLabel l6 = new JLabel("Education");
        l6.setFont(new Font("Raleway",Font.BOLD,18));
        l6.setBounds(100, 270,150,30);;
        add(l6);

        String Education[] = {"Select" , "Non Graduate" , "Graduate" ,"Post Graduate" , "Doctorate" , "Others"};
        comboBox4 = new JComboBox(Education);
        comboBox4.setBackground(new Color(195,203,194));
        comboBox4.setFont(new Font("Raleway" , Font.BOLD , 14));
        comboBox4.setBounds(350,270,320,30);
        add(comboBox4);

         JLabel l7 = new JLabel("Occupation");
        l7.setFont(new Font("Raleway",Font.BOLD,18));
        l7.setBounds(100, 340,150,30);;
        add(l7);

        String Occupation[] = {"Select" , "Salarate" , "Self Employed" ,"Business" , "Student" , "Retired" , "House Wife"  , "Others"};
        comboBox5 = new JComboBox(Occupation);
        comboBox5.setBackground(new Color(195,203,194));
        comboBox5.setFont(new Font("Raleway" , Font.BOLD , 14));
        comboBox5.setBounds(350,340,320,30);
        add(comboBox5);

        JLabel l8 = new JLabel("PAN NO");
        l8.setFont(new Font("Raleway",Font.BOLD,18));
        l8.setBounds(100, 390,150,30);;
        add(l8);
        textpan = new JTextField();
        textpan.setFont(new Font("Raleway",Font.BOLD,18));
        textpan.setBounds(350, 390,320,30);;
        add(textpan);

        JLabel l9 = new JLabel("AADHAR NO");
        l9.setFont(new Font("Raleway",Font.BOLD,18));
        l9.setBounds(100, 440,150,30);;
        add(l9);
        textadhaar = new JTextField();
        textadhaar.setFont(new Font("Raleway",Font.BOLD,18));
        textadhaar.setBounds(350, 440,320,30);;
        add(textadhaar);

        JLabel l10 = new JLabel("Senior Citizen");
        l10.setFont(new Font("Raleway",Font.BOLD,18));
        l10.setBounds(100, 490,150,30);;
        add(l10);

        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Raleway",Font.BOLD,18));
        r1.setBounds(350, 490,150,30);
        r1.setBackground(new Color(181, 235, 177 ));
        add(r1);
        r2 = new JRadioButton("No");
        r2.setFont(new Font("Raleway",Font.BOLD,18));
        r2.setBounds(460, 490,150,30);
        r2.setBackground(new Color(181, 235, 177 ));
        add(r2);

        JLabel l11 = new JLabel("Existing Account");
        l11.setFont(new Font("Raleway",Font.BOLD,18));
        l11.setBounds(100,540 ,150,30);;
        add(l11);

        r3 = new JRadioButton("Yes");
        r3.setFont(new Font("Raleway",Font.BOLD,18));
        r3.setBounds(350, 540,150,30);
        r3.setBackground(new Color(181, 235, 177 ));
        add(r3);
        r4 = new JRadioButton("No");
        r4.setFont(new Font("Raleway",Font.BOLD,18));
        r4.setBounds(460, 540,150,30);
        r4.setBackground(new Color(181, 235, 177 ));
        add(r4);


        JLabel l12 = new JLabel("Form No");
        l12.setFont(new Font("Raleway",Font.BOLD,14));
        l12.setBounds(700,10 ,100,30);
        add(l12);


        JLabel l13 = new JLabel(formno);
        l13.setFont(new Font("Raleway",Font.BOLD,14));
        l13.setBounds(760,10 ,60,30);
        add(l13);
        
        next=new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,18));
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.setBounds(570,640 ,100,30);
        next.addActionListener(this);
        add(next);


        setLayout(null);
        setSize(850, 750);
        setLocation(450,80);
        getContentPane().setBackground(new Color(181, 235, 177 ));
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e){
        String rel = (String) comboBox.getSelectedItem();
        String cate = (String) comboBox2.getSelectedItem();
        String inc = (String) comboBox3.getSelectedItem();
        String edu = (String) comboBox4.getSelectedItem();
        String occ = (String) comboBox5.getSelectedItem();

        String pan = textpan.getText();
        String adhaar = textadhaar.getText();

        String scitizen = null;
        if(r1.isSelected()){
            scitizen= "Yes";
        }
        else if (r2.isSelected()){
            scitizen = "No";

        }

        String eaccount = null;
        if(r1.isSelected()){
            eaccount= "Yes";
        }
        else if (r2.isSelected()){
            eaccount = "No";
            
        }

        try{
            if(textpan.getText().equals("") || textadhaar.getText().equals("")){
                JOptionPane.showMessageDialog(null, "fill all the fields.");
            }else{
                conn c1 = new conn();
                String s = "Insert into SignUp2 values('"+formno+"' ,'"+rel+"' , '"+cate+"' , '"+inc+"' , '"+edu+"' , '"+occ+"' , '"+pan+"' , '"+adhaar+"' , '"+scitizen+"' ,'"+eaccount+"')";
                c1.statement.executeUpdate(s);
                new Signup3(formno);
                setVisible(false);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
        

    }



    public static void main(String[] args) {
        new SignUp2("");
        
    }
    
}
