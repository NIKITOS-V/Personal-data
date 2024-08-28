package View.Commands;

import View.ConsoleUI;

public abstract class Command {
    private final ConsoleUI consoleUI;
    private final String key;

    public Command(String key, ConsoleUI consoleUI){
        this.consoleUI = consoleUI;
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }

    public ConsoleUI getConsoleUI() {
        return consoleUI;
    }

    public abstract void execute();
}
