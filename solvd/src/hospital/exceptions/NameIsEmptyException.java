package hospital.exceptions;

public class NameIsEmptyException extends Exception{
    public NameIsEmptyException(String message){
        super(message);
    }
    public NameIsEmptyException(){

    }
}
