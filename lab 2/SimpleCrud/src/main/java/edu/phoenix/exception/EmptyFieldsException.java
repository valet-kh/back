package edu.phoenix.exception;

import java.util.ArrayList;

public class EmptyFieldsException extends Exception {
    private final ArrayList<String> emptyFieldsList;
    public ArrayList<String> getEmptyFieldsList(){return emptyFieldsList;}
    public EmptyFieldsException(String message, ArrayList<String> emptyFieldsList){

        super(message);
        this.emptyFieldsList=emptyFieldsList;
    }
}
