package Model.PersonalDatas.Datas;

import Model.PersonalDatas.Data;
import Model.PersonalDatas.DataType;

public class Surname extends Data {
    private String value;

    public Surname(){
        super(DataType.Surname, "Surname");
    }

    @Override
    public void processUserInput(String userInput){
        this.value = userInput;
    }

    @Override
    public String getValue() {
        return value;
    }
}
