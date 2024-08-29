package Model.PersonalDatas.Datas;

import Model.PersonalDatas.Data;
import Model.PersonalDatas.DataType;

public class Patronymic extends Data {
    private String value;

    public Patronymic(){
        super(DataType.Patronymic, "Patronymic");
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
