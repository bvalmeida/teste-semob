package br.com.semob.handlerError.exceptions;

public class ServerSideException extends BadRequestException{
    public ServerSideException(String message) {
        super(message);
    }
}
