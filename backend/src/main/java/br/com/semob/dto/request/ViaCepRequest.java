package br.com.semob.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ViaCepRequest {

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
