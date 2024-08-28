package Model.Formating.FileWriter;

import Model.Formating.Exceptions.UncorrectedFileName;
import Model.PersonalDatas.Data;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface Writer {
    String getDirName();

    void save(ArrayList<Data> personalData) throws UncorrectedFileName, IOException;
}
