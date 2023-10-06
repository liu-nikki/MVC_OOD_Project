package View;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import Model.Food;
import Model.Sex;
import Model.Species;

public class AddMonkeyPage extends JFrame {
  private JLabel nameLabel, speciesLabel, sexLabel, sizeLabel, weightLabel, ageLabel, foodLabel;
  private JTextField nameField, sizeField, weightField, ageField;
  private JComboBox<Species> speciesComboBox;
  private JComboBox<Sex> sexComboBox;
  private JComboBox<Food> favouriteFoodComboBox;
  private JButton submitButton;

  public AddMonkeyPage() {
    setTitle("Add Monkey Form");
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    // create the labels
    nameLabel = new JLabel("Name:");
    speciesLabel = new JLabel("Species:");
    sexLabel = new JLabel("Sex:");
    sizeLabel = new JLabel("Size:");
    weightLabel = new JLabel("Weight:");
    ageLabel = new JLabel("Age:");
    foodLabel = new JLabel("Favourite Food:");
    // create the text fields
    nameField = new JTextField(20);
    sizeField = new JTextField(10);
    weightField = new JTextField(10);
    ageField = new JTextField(10);
    // create the combo box for species selection
    speciesComboBox = new JComboBox<>(Species.values());
    speciesComboBox.setSelectedIndex(0);
    // create the combo box for sex selection
    sexComboBox = new JComboBox<>(Sex.values());
    sexComboBox.setSelectedIndex(0);
    // create the combo box for favourite food selection
    favouriteFoodComboBox = new JComboBox<>(Food.values());
    favouriteFoodComboBox.setSelectedIndex(0);
    submitButton = new JButton("Add Monkey");

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(8, 2));
    panel.add(nameLabel);
    panel.add(nameField);
    panel.add(speciesLabel);
    panel.add(speciesComboBox);
    panel.add(sexLabel);
    panel.add(sexComboBox);
    panel.add(sizeLabel);
    panel.add(sizeField);
    panel.add(weightLabel);
    panel.add(weightField);
    panel.add(ageLabel);
    panel.add(ageField);
    panel.add(foodLabel);
    panel.add(favouriteFoodComboBox);
    panel.add(submitButton);
    // add the panel to the window
    setContentPane(panel);
  }

  public void resetFields() {
    nameField.setText("");
    speciesComboBox.setSelectedIndex(0);
    sexComboBox.setSelectedIndex(0);
    sizeField.setText("");
    weightField.setText("");
    ageField.setText("");
    favouriteFoodComboBox.setSelectedIndex(0);
  }

  public String getName() {
    if (nameField.getText().isEmpty()) {
      throw new IllegalStateException("Name cannot be empty");
    }
    return nameField.getText();
  }

  public Species getSpecies() {
    return (Species) speciesComboBox.getSelectedItem();
  }

  public Sex getSex() {
    return (Sex) sexComboBox.getSelectedItem();
  }
  public String getMonkeySize() {
    if (sizeField.getText().isEmpty()) {
      throw new IllegalStateException("Size Field cannot be Empty.");
    }
    return sizeField.getText();
  }

  public String getWeight() {
    if (weightField.getText().isEmpty()) {
      throw new IllegalStateException("Weight Field cannot be Empty.");
    }
    return weightField.getText();
  }

  public String getAge() {
    if (ageField.getText().isEmpty()) {
      throw new IllegalStateException("Age Field cannot be Empty.");
    }
    return ageField.getText();
  }

  public Food getFavouriteFood() {
    return (Food) favouriteFoodComboBox.getSelectedItem();
  }

  public void setSubmitButton(ActionListener listener) {
    submitButton.addActionListener(listener);
  }


}
