import Model.Formating.FileWriter.FileHandler;
import Model.Formating.FileWriter.Writer;
import Model.Service;
import Presenter.Presenter;
import View.View;
import View.ConsoleUI;


public class Main {
    public static void main(String[] args) {
        Writer writer = new FileHandler();

        Service service = new Service(writer);

        Presenter presenter = new Presenter(service);

        View view = new ConsoleUI(presenter);

        view.mainLoop();
    }
}