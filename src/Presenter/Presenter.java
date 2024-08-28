package Presenter;

import Model.Service;

import java.io.IOException;
import java.util.ArrayList;

public class Presenter {
    private final Service service;

    public Presenter(Service service){
        this.service = service;
    }

    public ArrayList<String> getQuestions(){
        return this.service.getQuestions();
    }

    public void sendUserInput(String userInput) throws IOException {
        this.service.parseUserInput(userInput);
    }
}
