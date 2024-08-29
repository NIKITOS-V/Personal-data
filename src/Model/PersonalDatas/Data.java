package Model.PersonalDatas;

import java.io.IOException;

public abstract class Data {
    private final DataType type;
    private final String question;

    public Data(DataType type, String question){
        this.type = type;
        this.question = question;
    }

    public DataType getType() {
        return type;
    }

    public String getQuestion(){
        return this.question;
    }

    public abstract void processUserInput(String userInput) throws IOException;

    public abstract String getValue();
}
