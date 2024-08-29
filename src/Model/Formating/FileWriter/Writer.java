package Model.Formating.FileWriter;

import Model.PersonalDatas.Data;

import java.io.IOException;
import java.util.ArrayList;

public interface Writer {
    void save(ArrayList<Data> personalData) throws IOException;
}
