package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import Model.Monkey;
import Model.Sanctuary;
import View.MoveMonkeyPage;

public class MoveMonkeyController {
  private MoveMonkeyPage moveMonkeyPage;
  private Sanctuary sanctuary;
  public MoveMonkeyController(Sanctuary sanctuary) {
    this.moveMonkeyPage = new MoveMonkeyPage();
    this.moveMonkeyPage.setVisible(true);
    this.sanctuary = sanctuary;
    moveMonkeyPage.setSubmitButton(new SubmitButtonListener());
  }

  private class SubmitButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      MoveMonkey();
    }
  }

  private void MoveMonkey() {
    try {
      String name = moveMonkeyPage.getName();
      Monkey target = findCorrespondingMonkey(name);
      sanctuary.moveMonkeyToEnclosure(target);
      JOptionPane.showMessageDialog(moveMonkeyPage, "Monkey has been moved to enclosure successfully!");
      moveMonkeyPage.resetTextArea();
    } catch (IllegalStateException e1) {
      JOptionPane.showMessageDialog(moveMonkeyPage, "Failed to move: " + e1.getMessage());
    }
  }

  private Monkey findCorrespondingMonkey(String name) {
    List<Monkey> allMonkey = sanctuary.getAllMonkeys();
    for (int i = 0; i < allMonkey.size(); i++) {
      Monkey cur = allMonkey.get(i);
      if (cur.getName().equals(name)) {
        return cur;
      }
    }
    throw new IllegalStateException("This monkey doesn't exist! Please check again.");
  }

}
