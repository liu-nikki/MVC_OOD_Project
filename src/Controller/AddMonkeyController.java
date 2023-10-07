package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Model.Food;
import Model.Monkey;
import Model.Sanctuary;
import Model.Sex;
import Model.Species;
import View.AddMonkeyPage;

public class AddMonkeyController {
  private AddMonkeyPage addMonkeyPage;
  private Sanctuary sanctuary;

  public AddMonkeyController(Sanctuary sanctuary) {
    this.sanctuary = sanctuary;
    this.addMonkeyPage = new AddMonkeyPage();
    addMonkeyPage.setVisible(true);
    addMonkeyPage.setSubmitButton(new SubmitButtonListener());
  }

  private class SubmitButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      createMonkey();
    }
  }

  private void createMonkey() {
    try {
      String name = addMonkeyPage.getName();
      Species species = addMonkeyPage.getSpecies();
      Sex sex = addMonkeyPage.getSex();
      String size = addMonkeyPage.getMonkeySize();
      double weight = Double.parseDouble(addMonkeyPage.getWeight());
      int age = Integer.parseInt(addMonkeyPage.getAge());
      Food favoriteFood = addMonkeyPage.getFavouriteFood();
      Monkey monkey = new Monkey(name, species, sex, size, weight, age, favoriteFood);
      sanctuary.addMonkeyToIsolation(monkey);
      JOptionPane.showMessageDialog(addMonkeyPage, "Monkey added successfully!","Success",JOptionPane.INFORMATION_MESSAGE);
      addMonkeyPage.resetFields();
    } catch (IllegalStateException e) {
      JOptionPane.showMessageDialog(addMonkeyPage, "Failed to add monkey: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(addMonkeyPage, "Failed to add monkey: " + e.getMessage() , "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
      JOptionPane.showMessageDialog(addMonkeyPage, "An error occurred while adding the monkey: " + e.getMessage() , "Error", JOptionPane.ERROR_MESSAGE);
    }
  }

}
