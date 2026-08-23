package bin.jav;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentRegistrationForm {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Student Registration Form");
        frame.setSize(400, 350);
        frame.setLayout(new GridLayout(6, 2, 10, 10));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel l1 = new JLabel("Student ID:");
        JTextField t1 = new JTextField();

        JLabel l2 = new JLabel("Name:");
        JTextField t2 = new JTextField();

        JLabel l3 = new JLabel("Course:");
        JTextField t3 = new JTextField();

        JLabel l4 = new JLabel("Email:");
        JTextField t4 = new JTextField();

        JButton button = new JButton("Register");

        frame.add(l1);
        frame.add(t1);

        frame.add(l2);
        frame.add(t2);

        frame.add(l3);
        frame.add(t3);

        frame.add(l4);
        frame.add(t4);

        frame.add(new JLabel(""));
        frame.add(button);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String details =
                        "Student ID: " + t1.getText() +
                        "\nName: " + t2.getText() +
                        "\nCourse: " + t3.getText() +
                        "\nEmail: " + t4.getText();

                JOptionPane.showMessageDialog(frame, details);
            }
        });

        frame.setVisible(true);
    }
}

