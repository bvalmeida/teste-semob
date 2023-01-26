package br.com.semob.handlerError.exceptions;

public class NotFoundEntityException extends BadRequestException{
    public NotFoundEntityException(String message) {
        super(message);
    }
}
