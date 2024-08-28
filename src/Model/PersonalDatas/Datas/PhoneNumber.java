package Model.PersonalDatas.Datas;

import Model.Formating.Exceptions.UncorrectedPhoneNumber;
import Model.PersonalDatas.Data;
import Model.PersonalDatas.DataType;

import java.io.IOException;

public class PhoneNumber extends Data {
    private static final int phoneNumberLength = 11;

    private Long value;

    public PhoneNumber(){
        super(DataType.Phone_number);
    }

    @Override
    public void processUserInput(String userInput) throws IOException {
        if (userInput.length() > phoneNumberLength){
            throw new UncorrectedPhoneNumber("The phone number is too long");

        } else if(userInput.length() < phoneNumberLength) {
            throw new UncorrectedPhoneNumber("The phone number is too small");

        } else {
            try {
                this.value = Long.parseLong(userInput);

            } catch (NumberFormatException exception){
                throw new UncorrectedPhoneNumber("Uncorrected phone number format");
            }
        }
    }

    @Override
    public String getValue() {
        return String.valueOf(this.value);
    }
}
