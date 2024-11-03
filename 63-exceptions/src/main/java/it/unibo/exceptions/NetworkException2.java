package it.unibo.exceptions;

import java.io.IOException;

public class NetworkException2 extends IOException{
    public NetworkException2(){
        System.out.println("Network error: no response");
    }
    public NetworkException2(final String message){
        System.out.println("Network error while sending message: " + message);
    }
}
