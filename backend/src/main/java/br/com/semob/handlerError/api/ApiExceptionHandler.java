package br.com.semob.handlerError.api;

import br.com.semob.handlerError.exceptions.BadRequestException;
import br.com.semob.handlerError.exceptions.NotFoundEntityException;
import br.com.semob.handlerError.exceptions.ServerSideException;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;

    public ApiExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){

        List<ErrorDescription.Campo> campos = new ArrayList<ErrorDescription.Campo>();

        for(ObjectError error : ex.getBindingResult().getAllErrors()){
            String nomeCampo = ((FieldError) error).getField();
            String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());

            campos.add(new ErrorDescription.Campo(nomeCampo, mensagem));
        }

        ErrorDescription errorDescription = new ErrorDescription();
        errorDescription.setCampos(campos);
        errorDescription.setTitulo("Um ou mais campos estão inválidos, por favor revise e tente novamente");
        errorDescription.setDataHora(OffsetDateTime.now());
        errorDescription.setStatusCode(status.value());

        return handleExceptionInternal(ex, errorDescription, headers, status, request);
    }

    @ExceptionHandler(NotFoundEntityException.class)
    public ResponseEntity<Object> handleEntidadeNaoEncontrada(NotFoundEntityException ex, WebRequest request){

        HttpStatus status = HttpStatus.NOT_FOUND;

        ErrorDescription errorDescription = new ErrorDescription();
        errorDescription.setStatusCode(status.value());
        errorDescription.setTitulo(ex.getMessage());
        errorDescription.setDataHora(OffsetDateTime.now());

        return handleExceptionInternal(ex, errorDescription, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleBadRequest(BadRequestException ex, WebRequest request){

        HttpStatus status = HttpStatus.BAD_REQUEST;

        ErrorDescription errorDescription = new ErrorDescription();
        errorDescription.setTitulo(ex.getMessage());
        errorDescription.setDataHora(OffsetDateTime.now());
        errorDescription.setStatusCode(status.value());

        return handleExceptionInternal(ex, errorDescription, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(ServerSideException.class)
    public ResponseEntity<Object> handleErrorServerSide(ServerSideException ex, WebRequest request){

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        ErrorDescription errorDescription = new ErrorDescription();
        errorDescription.setTitulo(ex.getMessage());
        errorDescription.setDataHora(OffsetDateTime.now());
        errorDescription.setStatusCode(status.value());

        return handleExceptionInternal(ex, errorDescription, new HttpHeaders(), status, request);
    }

}
