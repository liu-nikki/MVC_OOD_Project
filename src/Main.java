import Controller.MainPageController;
import Model.Sanctuary;

public class Main {
  public static void main(String[] args) {

    Sanctuary sanctuary = new Sanctuary();
    MainPageController  mainPageController = new MainPageController(sanctuary);

  }
}