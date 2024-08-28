package Model.PersonalDatas;

import java.io.IOException;

public abstract class Data {
    private final String dataName;

    public Data(DataType dataType){
        this.dataName = dataType.toString();
    }

    public String getDataName() {
        return dataName;
    }

    public abstract void processUserInput(String userInput) throws IOException;

    public abstract String getValue();
}
