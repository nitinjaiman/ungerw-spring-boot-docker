package com.trading.flarebot.serializationutils.exceptions;

public class SerializationException extends RuntimeException {
    public SerializationException(String message, Exception e){
        super(message, e);
    }
}
