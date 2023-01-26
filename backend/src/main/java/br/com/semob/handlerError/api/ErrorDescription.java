package br.com.semob.handlerError.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Component
public class ErrorDescription {

    private Integer statusCode;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private OffsetDateTime dataHora;

    private String titulo;

    private List<Campo> campos;

    public static class Campo{

        private String nomeCampo;

        private String mensagem;

        public Campo(String nomeCampo, String mensagem){
            super();
            this.nomeCampo = nomeCampo;
            this.mensagem = mensagem;
        }
    }

}
