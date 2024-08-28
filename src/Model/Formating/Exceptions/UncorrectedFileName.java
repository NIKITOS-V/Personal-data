package Model.Formating.Exceptions;

import java.io.IOException;

public class UncorrectedFileName extends IOException {
    public UncorrectedFileName(String message){
        super(message);
    }

    public UncorrectedFileName(){
        this("Uncorrected file name");
    }
}
