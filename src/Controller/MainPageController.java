package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import Model.Monkey;
import Model.Sanctuary;
import View.MainPage;

public class MainPageController {

  private Sanctuary sanctuary;
  private MainPage view;

  public MainPageController(Sanctuary sanctuary) {
    this.sanctuary = sanctuary;
    this.view = new MainPage(sanctuary);
    view.setVisible(true);
    view.setAddMonkeyButton(new activateAddMonkeyPageButtonListener());
    view.setMoveMonkeyButton(new activateMoveMonkeyPageButtonListener());
    view.setListForEnclosureButton(new activateListForEnclosurePageButtonListener());
    view.setListAllMonkeyButton(new activateListAllMonkeyPageButtonListener());
    view.setReceiveMedicalAttentionButton(new activateReceiveMedicalAttentionPageButtonListener());

  }

  private class activateAddMonkeyPageButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      // activate the add monkey controller here
      AddMonkeyController addMonkeyController = new AddMonkeyController(sanctuary);
    }
  }

  private class activateMoveMonkeyPageButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      // activate the add monkey controller here
      MoveMonkeyController moveMonkeyController = new MoveMonkeyController(sanctuary);
    }
  }

  private class activateListForEnclosurePageButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      // activate the add monkey controller here
      ListForEnclosurePageController listForEnclosurePageController = new ListForEnclosurePageController(sanctuary);
    }
  }

  private class activateReceiveMedicalAttentionPageButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      // activate the add monkey controller here
      ReceiveMedicalAttentionPageController receiveMedicalAttentionPageController = new ReceiveMedicalAttentionPageController(sanctuary);
    }
  }

  private class activateListAllMonkeyPageButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      // activate the add monkey controller here
      try {
        List<Monkey> curMonkey = sanctuary.getAllMonkeys();
        if (curMonkey == null || curMonkey.size() == 0) {
          throw new IllegalStateException("There is no Monkey in this Sanctuary.");
        }
        String info = "";
        for (int i = 0; i < curMonkey.size(); i++) {
          info += curMonkey.get(i).toString() + "\n";
        }
        JOptionPane.showMessageDialog(view, info, "All monkeys in this Sanctuary ", JOptionPane.INFORMATION_MESSAGE);
      } catch (IllegalStateException e1) {
        JOptionPane.showMessageDialog(view, "Failed to add monkey: " + e1.getMessage());
      }
    }
  }


}
