package View;

import Presenter.Presenter;
import View.Commands.Command;
import View.Commands.Commands.ExitFromApp;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleUI implements View{
    private static final Scanner scanner = new Scanner(System.in);

    private final ArrayList<Command> commands = new ArrayList<>();

    private boolean isRun;
    private final Presenter presenter;
    private final String consoleName;

    public ConsoleUI(Presenter presenter){
        this.commands.add(new ExitFromApp(this));

        this.presenter = presenter;
        this.consoleName = "Input";
    }


    public void stopApp() {
        this.isRun = false;
    }

    private void startApp(){
        this.isRun = true;
    }

    public void mainLoop() {
        startApp();

        while (this.isRun){
            String userInput = input(this.consoleName);

            execute(userInput);
        }
    }

    private void printEmptyLine(){
        System.out.println();
    }

    private String input(String message){
        System.out.printf("%s: ", message);

        String userInput = scanner.nextLine();

        printEmptyLine();

        return userInput;
    }

    private void execute(String userInput){
        boolean isCommand = false;

        for (Command command: this.commands){
            if (command.getKey().equalsIgnoreCase(userInput)){
                command.execute();

                isCommand = true;
            }
        }

        if (!isCommand){
            sendUserInput(userInput);
        }
    }

    private void printError(Exception exception){
        System.out.printf("\t%s: %s\n", exception.getClass().getSimpleName(), exception.getMessage());
    }

    private void sendUserInput(String userInput){
        try {

        } catch (Exception exception){
            printError(exception);
        }
    }
}
