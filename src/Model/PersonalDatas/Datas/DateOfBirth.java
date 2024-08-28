package Model.PersonalDatas.Datas;

import Model.Formating.Exceptions.UncorrectedDate;
import Model.PersonalDatas.Data;
import Model.PersonalDatas.DataType;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateOfBirth extends Data {
    private String date;

    public DateOfBirth(){
        super(DataType.Date_of_birth);
    }


    @Override
    public void processUserInput(String userInput) throws IOException {
        try {
            String[] splitInput = userInput.split("\\.");

            int day = Integer.parseInt(splitInput[0]);
            int month = Integer.parseInt(splitInput[1]);
            int year = Integer.parseInt(splitInput[2]);

            this.date = new SimpleDateFormat(
                    "dd.MM.yyyy"
            ).format(
                    new Date(year - 1900, month - 1, day)
            );

            if (!this.date.equals(userInput)) {
                throw new UncorrectedDate("Uncorrected date format");
            }
        } catch (UncorrectedDate exception){
            throw new UncorrectedDate(exception.getMessage());

        } catch (ArrayIndexOutOfBoundsException | NumberFormatException exception){
            throw new UncorrectedDate("Uncorrected data format");
        }
    }

    @Override
    public String getValue() {
        return this.date;
    }
}
