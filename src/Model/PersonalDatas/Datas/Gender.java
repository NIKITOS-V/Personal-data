package Model.PersonalDatas.Datas;

import Model.Formating.Exceptions.UGender;
import Model.PersonalDatas.Data;
import Model.PersonalDatas.DataType;

import java.io.IOException;

public class Gender extends Data {
    private enum genderType{
        f, m
    }

    private genderType gender;

    public Gender(){
        super(DataType.Gender, "Gender");
    }

    @Override
    public void processUserInput(String userInput) throws IOException {
        if (userInput.equals(genderType.f.toString())){
            this.gender = genderType.f;

        } else if (userInput.equals(genderType.m.toString())){
            this.gender = genderType.m;

        } else {
            throw new UGender();
        }

    }

    @Override
    public String getValue() {
        return gender.toString();
    }
}
