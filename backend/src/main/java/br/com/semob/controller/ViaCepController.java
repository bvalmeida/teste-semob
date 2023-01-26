package br.com.semob.controller;

import br.com.semob.dto.request.ViaCepRequest;
import br.com.semob.dto.response.ViaCepResponse;
import br.com.semob.service.ViaCepService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/via-ceps")
@Tag(name = "Via Cep - Teste Semob", description = "Api responsável por salvar e buscar ceps pesquisados")
public class ViaCepController {

    private final ViaCepService viaCepService;

    public ViaCepController(ViaCepService viaCepService) {
        this.viaCepService = viaCepService;
    }

    @Operation(summary = "Cadastrar Pesquisa ViaCep", description = "Método responsável por cadastrar pesquisas realizadas no ViaCep")
    @ApiResponse(responseCode = "201", description = "Pesquisa cadastrada com sucesso!")
    @ApiResponse(responseCode = "400", description = "Bad Request. Algum dado está inválido, por favor revise e tente novamente")
    @ApiResponse(responseCode = "500", description = "Server Side Error. Algum error ocorreu no servidor, por favor tente novamente em alguns instantes")
    @PostMapping
    public ResponseEntity<ViaCepResponse> cadastrarPesquisaViaCep(@Valid @RequestBody ViaCepRequest viaCepRequest){
        ViaCepResponse viaCepResponse = this.viaCepService.adicionarViaCepPesquisaRealizada(viaCepRequest);
        return new ResponseEntity<>(viaCepResponse, HttpStatus.CREATED);
    }

    @Operation(summary = "Buscar Todas as Pesquisas ViaCep", description = "Método responsável por buscar todas as pesquisas realizadas do ViaCep")
    @ApiResponse(responseCode = "200", description = "Pesquisas encontradas com sucesso!")
    @ApiResponse(responseCode = "404", description = "Nenhuma pesquisa encontrada")
    @ApiResponse(responseCode = "500", description = "Server Side Error, Algum error ocorreu no servidor, por favor tente novamente em alguns instantes")
    @GetMapping
    public ResponseEntity<List<ViaCepResponse>> buscarTodasAsPesquisasViaCep(){
        List<ViaCepResponse> viaCepResponses = this.viaCepService.buscarTodasViaCepPesquisas();
        return new ResponseEntity<>(viaCepResponses, HttpStatus.OK);
    }


}
