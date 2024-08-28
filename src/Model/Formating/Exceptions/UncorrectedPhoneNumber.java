package Model.Formating.Exceptions;

import java.io.IOException;

public class UncorrectedPhoneNumber extends IOException {
    public UncorrectedPhoneNumber(String message){
        super(message);
    }

    public UncorrectedPhoneNumber(){
        this("Uncorrected phone number");
    }
}
