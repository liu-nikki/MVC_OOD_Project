package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import Model.Sanctuary;
import Model.Species;
import View.ListForEnclosurePage;

public class ListForEnclosurePageController {
  private ListForEnclosurePage listForEnclosurePage;
  private Sanctuary sanctuary;

  public ListForEnclosurePageController(Sanctuary sanctuary) {
    this.listForEnclosurePage = new ListForEnclosurePage();
    this.listForEnclosurePage.setVisible(true);
    this.sanctuary = sanctuary;
    listForEnclosurePage.addSubmitButtonListener(new ListForEnclosurePageController.SubmitButtonListener());
  }

  private class SubmitButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      showList();
    }
  }

  private void showList() {
    try {
      Species species = listForEnclosurePage.getSpecies();
      List<String> list = sanctuary.produceEnclosureList(species);
      if (list == null || list.size() == 0) {
        throw new IllegalStateException("This Enclosure is empty.");
      }
      String info = String.join("\n", list);
      JOptionPane.showMessageDialog(listForEnclosurePage, info);
    } catch (IllegalStateException e1) {
      JOptionPane.showMessageDialog(listForEnclosurePage, "Failed to show: " + e1.getMessage());
    } catch (Exception e1) {
      JOptionPane.showMessageDialog(listForEnclosurePage, "Failed to show: " + e1.getMessage());
    }
  }
}
