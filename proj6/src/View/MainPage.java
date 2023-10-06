package View;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;

import Model.Sanctuary;

public class MainPage extends JFrame {
  private final Sanctuary sanctuary;

  private JButton addMonkeyButton, moveMonkeyButton, listForEnclosureButton, listAllMonkeyButton, receiveMedicalTreatmentButton;


  public MainPage(Sanctuary sanctuary) {
    this.sanctuary = sanctuary;

    setTitle("Monkey Sanctuary");
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel mainPanel = new JPanel();

    addMonkeyButton = new JButton("Add Monkey");
    moveMonkeyButton = new JButton("Move Monkey");
    listForEnclosureButton = new JButton("List for Enclosure");
    listAllMonkeyButton = new JButton("List All Monkeys in Sanctuary");
    receiveMedicalTreatmentButton = new JButton("Receive Medical Treatment");

    mainPanel.add(addMonkeyButton);
    mainPanel.add(moveMonkeyButton);
    mainPanel.add(listForEnclosureButton);
    mainPanel.add(listAllMonkeyButton);
    mainPanel.add(receiveMedicalTreatmentButton);

//    setContentPane(mainPanel);
    getContentPane().add(mainPanel, BorderLayout.CENTER);
    setVisible(true);
  }

  public void setAddMonkeyButton(ActionListener listener) {
    addMonkeyButton.addActionListener(listener);
  }

  public void setMoveMonkeyButton(ActionListener listener) {
    moveMonkeyButton.addActionListener(listener);
  }

  public void setListForEnclosureButton(ActionListener listener) {
    listForEnclosureButton.addActionListener(listener);
  }

  public void setListAllMonkeyButton(ActionListener listener) {
    listAllMonkeyButton.addActionListener(listener);
  }

  public void setReceiveMedicalAttentionButton(ActionListener listener) {
    receiveMedicalTreatmentButton.addActionListener(listener);
  }

}