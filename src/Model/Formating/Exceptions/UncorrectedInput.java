package Model.Formating.Exceptions;

import java.io.IOException;

public class UncorrectedInput extends IOException {
    public UncorrectedInput(String message){
        super(message);
    }

    public UncorrectedInput(){
        this("Uncorrected Input");
    }
}
