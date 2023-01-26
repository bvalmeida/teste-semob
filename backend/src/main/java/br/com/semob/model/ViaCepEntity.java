package br.com.semob.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tb_via_cep_entity")
public class ViaCepEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private OffsetDateTime dataHoraPesquisa;

    @NotNull
    private String cep;

    @NotNull
    private String logradouro;

    @NotNull
    private String complemento;

    @NotNull
    private String bairro;

    @NotNull
    private String localidade;

    @NotNull
    private String uf;

    @NotNull
    private String ibge;

    @NotNull
    private String gia;

    @NotNull
    private String ddd;

    @NotNull
    private String siafi;

}
