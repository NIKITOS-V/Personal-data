package Model.Formating.Exceptions;

import java.io.IOException;

public class UGender extends IOException {
    public UGender(String message){
        super(message);
    }

    public UGender(){
        this("Unknown gender");
    }
}
