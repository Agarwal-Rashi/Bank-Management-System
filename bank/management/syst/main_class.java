package bank.management.syst;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class main_class extends JFrame implements ActionListener{ 

    JButton b1 , b2 , b3 , b4 , b5 , b6 , b7;
    String pin;

    main_class(String pin){
        this.pin=pin;

         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1550, 830);
        add(l3);

            JLabel label = new JLabel("Please select your transaction");
            label.setFont(new Font("System", Font.BOLD, 28));
            label.setBounds(430, 180, 700, 35);
            label.setForeground(Color.WHITE);
            l3.add(label);

            b1 = new JButton("DEPOSIT");
            b1.setForeground(Color.WHITE);
            b1.setBackground(new Color(65,125,128));
            b1.setBounds(410, 274, 150, 35);
            b1.addActionListener(this);
            l3.add(b1);

            b2 = new JButton("CASH WITHDRAW");
            b2.setForeground(Color.WHITE);
            b2.setBackground(new Color(65,125,128));
            b2.setBounds(700, 274, 150, 35);
            b2.addActionListener(this);
            l3.add(b2);

            b3 = new JButton("FAST CASH");
            b3.setForeground(Color.WHITE);
            b3.setBackground(new Color(65,125,128));
            b3.setBounds(410, 318 , 150, 35);
            b3.addActionListener(this);
            l3.add(b3);

            b4 = new JButton("MINI STATEMENT");
            b4.setForeground(Color.WHITE);
            b4.setBackground(new Color(65,125,128));
            b4.setBounds(700, 318 , 150, 35);
            b4.addActionListener(this);
            l3.add(b4);

            b5 = new JButton("PIN CHANGE");
            b5.setForeground(Color.WHITE);
            b5.setBackground(new Color(65,125,128));
            b5.setBounds(410, 362 , 150, 35);
            b5.addActionListener(this);
            l3.add(b5);

            b6 = new JButton("BALANCE ENQUIRY");
            b6.setForeground(Color.WHITE);
            b6.setBackground(new Color(65,125,128));
            b6.setBounds(700, 362 , 150, 35);
            b6.addActionListener(this);
            l3.add(b6);

            b7 = new JButton("EXIT");
            b7.setForeground(Color.WHITE);
            b7.setBackground(new Color(65,125,128));
            b7.setBounds(700, 406 , 150, 35);
            b7.addActionListener(this);
            l3.add(b7);




        setSize(1550 ,1080);
        setLocation(0,0);
        setVisible(true);
        setLayout(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            new Deposit(pin);
            setVisible(false);
        }else if (e.getSource()==b7){
            showFeedbackDialog();
        }else if (e.getSource()==b2) {
            new withdraw(pin);
            setVisible(false);
        } else if (e.getSource()==b6) {
            new Balance_Enquiry(pin);
            setVisible(false);
        } else if (e.getSource()==b3) {
            new FastCash(pin);
            setVisible(false);
        } else if (e.getSource()==b5) {
            new Pin(pin);
            setVisible(false);
        } else if (e.getSource()==b4) {
            new Mini(pin);
        }
    }

    private void showFeedbackDialog() {
        JDialog feedbackDialog = new JDialog(this, "Feedback");
        feedbackDialog.setLayout(new BorderLayout());

        JPanel feedbackPanel = new JPanel();
        feedbackPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        feedbackDialog.add(feedbackPanel, BorderLayout.CENTER);

        JLabel feedbackLabel = new JLabel("How was your experience?");
        feedbackPanel.add(feedbackLabel);

        // Create star rating components (you can use any custom rating component)
        JSlider starRating = new JSlider(0, 5, 0);
        starRating.setMajorTickSpacing(1);
        starRating.setPaintTicks(true);
        starRating.setPaintLabels(true);
        feedbackPanel.add(starRating);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        feedbackDialog.add(buttonPanel, BorderLayout.SOUTH);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            // Process the feedback and submit
            feedbackDialog.dispose();
            // Show "Feedback submitted" or do other actions
            JOptionPane.showMessageDialog(this, "Feedback submitted. Thank you!");
        });

        JButton skipButton = new JButton("Skip");
        skipButton.addActionListener(e -> {
            feedbackDialog.dispose();
            // Do other actions if skipped
            System.exit(0);
        });

        buttonPanel.add(submitButton);
        buttonPanel.add(skipButton);

        // Make the dialog undecorated and size it
        feedbackDialog.setUndecorated(true);
        feedbackDialog.pack();
        feedbackDialog.setLocationRelativeTo(this);
        feedbackDialog.setVisible(true);
        
    }
    



    public static void main(String[] args) {
        new main_class("");
    }
}
