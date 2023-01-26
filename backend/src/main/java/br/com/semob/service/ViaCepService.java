package br.com.semob.service;

import br.com.semob.dto.request.ViaCepRequest;
import br.com.semob.dto.response.ViaCepResponse;

import java.util.List;

public interface ViaCepService {

    ViaCepResponse adicionarViaCepPesquisaRealizada(ViaCepRequest viaCepRequest);

    List<ViaCepResponse> buscarTodasViaCepPesquisas();

}
