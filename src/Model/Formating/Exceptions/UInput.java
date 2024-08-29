package Model.Formating.Exceptions;

import java.io.IOException;

public class UInput extends IOException {
    public UInput(String message){
        super(message);
    }

    public UInput(){
        this("Uncorrected Input");
    }
}
