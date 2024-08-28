package Model.Formating.Exceptions;

import java.io.IOException;

public class UnknownGender extends IOException {
    public UnknownGender(String message){
        super(message);
    }

    public UnknownGender(){
        this("Unknown gender");
    }
}
