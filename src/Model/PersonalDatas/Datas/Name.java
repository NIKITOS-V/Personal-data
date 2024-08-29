package Model.PersonalDatas.Datas;

import Model.PersonalDatas.Data;
import Model.PersonalDatas.DataType;

public class Name extends Data {
    private String value;

    public Name(){
        super(DataType.Name, "Name");
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
