package Model.Formating.Exceptions;

import java.io.IOException;

public class UDate extends IOException {
    public UDate(String message){
        super(message);
    }

    public UDate(){
        this("Uncorrected date");
    }
}
