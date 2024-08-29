package Model.Formating.FileWriter;

import Model.Formating.Exceptions.UFileName;
import Model.PersonalDatas.Data;
import Model.PersonalDatas.DataType;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandler implements Writer {
    private final ArrayList<DataType> sequenceForSave = new ArrayList<>();

    private final String dirName = "src\\Database";
    private final String fileExtension = ".txt";

    public FileHandler(){
        this.sequenceForSave.add(DataType.Surname);
        this.sequenceForSave.add(DataType.Name);
        this.sequenceForSave.add(DataType.Patronymic);
        this.sequenceForSave.add(DataType.Date_of_birth);
        this.sequenceForSave.add(DataType.Phone_number);
        this.sequenceForSave.add(DataType.Gender);
    }

    private String createName(String name){
        return dirName + "\\" + name + this.fileExtension ;
    }

    private String createSequence(ArrayList<Data> personalData){
        StringBuilder info = new StringBuilder();

        for (DataType necessaryType: this.sequenceForSave){
            for (Data data: personalData){
                if (data.getType().equals(necessaryType)){
                    info.append(data.getValue()).append(" ");

                    break;
                }
            }
        }

        return info.toString();
    }

    private String getFileName(ArrayList<Data> personalData) throws UFileName {
        for (Data data: personalData){
            if (data.getType().equals(DataType.Surname)) {
                return data.getValue();
            }
        }

        throw new UFileName("Surname was not found");
    }

    @Override
    public void save(ArrayList<Data> personalData) throws IOException {
        String listForSave = createSequence(personalData);

        String fileName = getFileName(personalData);

        try (
                FileWriter fileWriter = new FileWriter(createName(fileName), true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
        ){

            bufferedWriter.write(listForSave);
            bufferedWriter.newLine();

        } catch (FileNotFoundException exception){
            throw new UFileName();
        }
    }
}
