package bin.jav;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUICalculator {

    public static void main(String[] args) {

        JFrame frame = new JFrame("GUI Calculator");
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(4, 2, 10, 10));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel l1 = new JLabel("First Number:");
        JTextField t1 = new JTextField();

        JLabel l2 = new JLabel("Second Number:");
        JTextField t2 = new JTextField();

        JButton addButton = new JButton("Add");
        JButton subButton = new JButton("Subtract");

        JLabel resultLabel = new JLabel("Result:");

        frame.add(l1);
        frame.add(t1);
        frame.add(l2);
        frame.add(t2);
        frame.add(addButton);
        frame.add(subButton);
        frame.add(resultLabel);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = Integer.parseInt(t1.getText());
                int b = Integer.parseInt(t2.getText());

                resultLabel.setText("Result: " + (a + b));
            }
        });

        subButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = Integer.parseInt(t1.getText());
                int b = Integer.parseInt(t2.getText());

                resultLabel.setText("Result: " + (a - b));
            }
        });

        frame.setVisible(true);
    }
}

