package Model.Formating.Exceptions;

import java.io.IOException;

public class UncorrectedDate extends IOException {
    public UncorrectedDate(String message){
        super(message);
    }

    public UncorrectedDate(){
        this("Uncorrected date");
    }
}
