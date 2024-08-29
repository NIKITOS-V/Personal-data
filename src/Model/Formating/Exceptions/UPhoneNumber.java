package Model.Formating.Exceptions;

import java.io.IOException;

public class UPhoneNumber extends IOException {
    public UPhoneNumber(String message){
        super(message);
    }

    public UPhoneNumber(){
        this("Uncorrected phone number");
    }
}
