package Model;

import Model.Formating.Exceptions.UInput;
import Model.Formating.FileWriter.Writer;
import Model.PersonalDatas.Data;
import Model.PersonalDatas.Datas.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Service {
    private final Writer writer;

    private final ArrayList<Data> personalData = new ArrayList<>();

    public Service(Writer writer){
        this.writer = writer;

        fillQuestionsList();
    }

    private void fillQuestionsList(){
        this.personalData.clear();

        this.personalData.add(new Name());
        this.personalData.add(new Surname());
        this.personalData.add(new Patronymic());
        this.personalData.add(new DateOfBirth());
        this.personalData.add(new PhoneNumber());
        this.personalData.add(new Gender());
    }

    public ArrayList<String> getQuestions(){
        ArrayList<String> questions = new ArrayList<>();

        Collections.shuffle(this.personalData);

        for (Data data: this.personalData){
            questions.add(data.getQuestion());
        }

        return questions;
    }

    public void parseUserInput(String userInput) throws IOException {
        ArrayList<String> splitInput = new ArrayList<>(List.of(userInput.split(" ")));

        if (splitInput.size() > this.personalData.size()){
            throw new UInput("The input is too long");

        } else if (splitInput.size() < this.personalData.size()){
            throw new UInput("The input is too small");

        } else {
            ArrayList<Data> dataForSave = new ArrayList<>();

            for (int index = 0; index < splitInput.size(); index++){
                Data data = this.personalData.get(index);
                String value = splitInput.get(index);

                data.processUserInput(value);

                dataForSave.add(data);
            }

            writer.save(dataForSave);
        }
    }
}
