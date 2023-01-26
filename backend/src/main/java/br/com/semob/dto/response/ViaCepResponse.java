package br.com.semob.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class ViaCepResponse {

    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private OffsetDateTime dataHoraPesquisa;

    private String cep;

    private String logradouro;

    private String complemento;

    private String bairro;

    private String localidade;

    private String uf;

    private String ibge;

    private String gia;

    private String ddd;

    private String siafi;
}
