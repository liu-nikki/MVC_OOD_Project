package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import Model.Monkey;
import Model.Sanctuary;
import View.ReceiveMedicalAttentionPage;

public class ReceiveMedicalAttentionPageController {
  private Sanctuary sanctuary;
  private ReceiveMedicalAttentionPage receiveMedicalAttentionPage;

  public ReceiveMedicalAttentionPageController(Sanctuary sanctuary) {
    this.sanctuary = sanctuary;
    this.receiveMedicalAttentionPage = new ReceiveMedicalAttentionPage();
    this.receiveMedicalAttentionPage.setVisible(true);
    receiveMedicalAttentionPage.setSubmitButton(new submitButtonListener());
  }

  private class submitButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      // activate the add monkey controller here
      receiveMedicalAttention();
    }
  }

  private void receiveMedicalAttention() {
    try {
      String name = receiveMedicalAttentionPage.getName();
      Monkey target = findCorrespondingMonkey(name);
      sanctuary.addMonkeyToIsolation(target);
      JOptionPane.showMessageDialog(receiveMedicalAttentionPage, "Monkey has been moved to isolation successfully!");
      receiveMedicalAttentionPage.resetTextArea();
    } catch (IllegalStateException e1) {
      JOptionPane.showMessageDialog(receiveMedicalAttentionPage, "Failed to move: " + e1.getMessage());
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
