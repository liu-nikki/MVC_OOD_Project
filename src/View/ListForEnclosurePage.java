package View;

import java.awt.event.ActionListener;

import javax.swing.*;

import Model.Species;

public class ListForEnclosurePage extends JFrame {
  private JLabel titleLabel, speciesLabel;
  private JComboBox<Species> speciesComboBox;
  private JButton submitButton;
  public ListForEnclosurePage() {
    // set the title of the window
    setTitle("Get Monkeys hosted in One Enclosure");

    // set the size of the window
    setSize(400, 300);

    // set the close operation to exit the program when the window is closed
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

    // create the labels
    titleLabel = new JLabel("Which Species do you want to check?");

    speciesComboBox = new JComboBox<>(Species.values());
    speciesComboBox.setSelectedIndex(0);

    // create the submit button
    submitButton = new JButton("Submit");

    JPanel panel = new JPanel();
    panel.add(titleLabel);
    panel.add(speciesComboBox);
    panel.add(submitButton);

    // set the panel as the content pane of the JFrame
    setContentPane(panel);

  }

  public Species getSpecies() {
    return (Species) speciesComboBox.getSelectedItem();
  }

  public void addSubmitButtonListener(ActionListener listener) {
    submitButton.addActionListener(listener);
  }
}
