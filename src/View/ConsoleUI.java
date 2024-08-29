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
            askQuestions(this.presenter.getQuestions());

            String userInput = input(this.consoleName);

            execute(userInput);
        }
    }

    private void askQuestions(ArrayList<String> questions){
        System.out.print("\nPlease enter the following: ");

        for (int index = 0; index < questions.size() - 1; index++){
            System.out.printf("%s, ", questions.get(index));
        }

        System.out.println(questions.getLast() + ".");
    }

    private void printEmptyLine(){
        System.out.println();
    }

    private String input(String message){
        System.out.printf("\n%s: ", message);

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
        System.out.printf("\tERROR: %s\n", exception.getMessage());
    }

    private void printSuccessful(){
        System.out.println("\tSuccessful");
    }

    private void sendUserInput(String userInput){
        try {
            this.presenter.sendUserInput(userInput);

            printSuccessful();

        } catch (Exception exception){
            printError(exception);
        }
    }
}
