package it.unibo.exceptions;

import java.io.IOException;

public class NetworkException extends IOException{
    public NetworkException(){
        super();
    }

    public NetworkException(final String message){
        super(message);
    }
}
