package View;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ReceiveMedicalAttentionPage extends JFrame {
    private JButton submitButton;
    private JLabel nameLabel;
    private JTextField nameField;

    public ReceiveMedicalAttentionPage() {
        setTitle("Received Medical Attention Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        // create the labels
        nameLabel = new JLabel("Name the monkey need medical attention:");
        // create the text fields
        nameField = new JTextField(20);
        submitButton = new JButton("Move Monkey");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(submitButton);

        getContentPane().add(panel);
        pack();
        setVisible(true);
    }

    public void setSubmitButton(ActionListener listener) {
        submitButton.addActionListener(listener);
    }

    public String getName() {
        return nameField.getText();
    }

    public void resetTextArea() {
        nameField.setText("");
    }

}
