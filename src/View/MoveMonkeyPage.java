package View;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MoveMonkeyPage extends JFrame {
  private JLabel nameLabel;
  private JTextField nameField;
  private JButton submitButton;

  public MoveMonkeyPage() {
    setTitle("Move Monkey Form");
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    // create the labels
    nameLabel = new JLabel("Name the monkey you want to move:");
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
