package bank.management.syst;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Mini extends JFrame implements ActionListener {
    String pin;
    JButton button, downloadButton;
    JTextArea textArea;
    Mini(String pin) {
        this.pin = pin;
        getContentPane().setBackground(new Color(255, 204, 204));
        setSize(400, 600);
        setLocation(20, 20);
        setLayout(null);

        JLabel label1 = new JLabel();
        label1.setBounds(20, 140, 400, 200);
        add(label1);

        JLabel label2 = new JLabel("SAFE AND SECURE ATM");
        label2.setFont(new Font("System", Font.BOLD, 15));
        label2.setBounds(150, 20, 200, 20);
        add(label2);

        JLabel label3 = new JLabel();
        label3.setBounds(20, 80, 300, 20);
        add(label3);

        JLabel label4 = new JLabel();
        label4.setBounds(20, 400, 300, 20);
        add(label4);

        String accountHolderName = ""; // Add a variable to store the account holder's name

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from login where pin = '" + pin + "'");
            while (resultSet.next()) {
                accountHolderName = resultSet.getString("user_name"); // Get account holder's name
                label3.setText("Account Holder: " + accountHolderName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            int balance = 0;
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from bank where pin_no = '" + pin + "'");
            textArea = new JTextArea();
            while (resultSet.next()) {
                textArea.append(resultSet.getString("date") + "\t" + resultSet.getString("type") + "\t" + resultSet.getString("amount") + "\n");

                if (resultSet.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
            textArea.append("\nYour Total Balance is Rs " + balance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        textArea.setBounds(20, 160, 340, 230);
        textArea.setEditable(false);
        add(textArea);

        button = new JButton("Exit");
        button.setBounds(20, 500, 100, 25);
        button.addActionListener(this);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        add(button);

        downloadButton = new JButton("Download");
        downloadButton.setBounds(140, 500, 100, 25);
        downloadButton.addActionListener(this);
        downloadButton.setBackground(Color.BLACK);
        downloadButton.setForeground(Color.WHITE);
        add(downloadButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            setVisible(false);
        } else if (e.getSource() == downloadButton) {
            // Implement code to download the statement, e.g., by writing the statement to a file.
            // You can use a file chooser to specify the download location.
            // Example: https://docs.oracle.com/javase/tutorial/uiswing/components/filechooser.html
            // In this example, I'm just displaying a message.
            JOptionPane.showMessageDialog(this, "Statement downloaded.");
        }
    }

    public static void main(String[] args) {
        new Mini("");
    }
}
