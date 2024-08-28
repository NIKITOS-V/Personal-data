package View.Commands.Commands;

import View.Commands.Command;
import View.ConsoleUI;

public class ExitFromApp extends Command {
    public ExitFromApp(ConsoleUI consoleUI){
        super("exit", consoleUI);
    }

    public void execute() {
        super.getConsoleUI().stopApp();
    }
}
