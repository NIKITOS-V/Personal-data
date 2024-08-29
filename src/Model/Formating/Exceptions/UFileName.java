package Model.Formating.Exceptions;

import java.io.IOException;

public class UFileName extends IOException {
    public UFileName(String message){
        super(message);
    }

    public UFileName(){
        this("Uncorrected file name");
    }
}
