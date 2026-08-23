package bin.jav;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankBalanceCalculator {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Bank Balance Calculator");
        frame.setSize(450, 300);
        frame.setLayout(new GridLayout(4, 2, 10, 10));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel l1 = new JLabel("Initial Balance:");
        JTextField balanceField = new JTextField();

        JLabel l2 = new JLabel("Transaction Amount:");
        JTextField amountField = new JTextField();

        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");

        JLabel resultLabel = new JLabel("Updated Balance:");

        frame.add(l1);
        frame.add(balanceField);
        frame.add(l2);
        frame.add(amountField);
        frame.add(depositButton);
        frame.add(withdrawButton);
        frame.add(resultLabel);

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                double balance =
                        Double.parseDouble(balanceField.getText());

                double amount =
                        Double.parseDouble(amountField.getText());

                balance = balance + amount;

                resultLabel.setText("Updated Balance: " + balance);
                balanceField.setText(String.valueOf(balance));
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                double balance =
                        Double.parseDouble(balanceField.getText());

                double amount =
                        Double.parseDouble(amountField.getText());

                balance = balance - amount;

                resultLabel.setText("Updated Balance: " + balance);
                balanceField.setText(String.valueOf(balance));
            }
        });

        frame.setVisible(true);
    }
}