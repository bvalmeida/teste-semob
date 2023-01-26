package br.com.semob.service;

import br.com.semob.dto.request.ViaCepRequest;
import br.com.semob.dto.response.ViaCepResponse;
import br.com.semob.handlerError.exceptions.BadRequestException;
import br.com.semob.handlerError.exceptions.NotFoundEntityException;
import br.com.semob.handlerError.exceptions.ServerSideException;
import br.com.semob.model.ViaCepEntity;
import br.com.semob.repository.ViaCepRepository;
import br.com.semob.utilitys.ConvertUtility;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ViaCepServiceImpl implements ViaCepService, ConvertUtility<ViaCepEntity, ViaCepRequest, ViaCepResponse> {

    private final ViaCepRepository viaCepRepository;

    private final ModelMapper modelMapper;

    public ViaCepServiceImpl(ViaCepRepository viaCepRepository, ModelMapper modelMapper) {
        this.viaCepRepository = viaCepRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public ViaCepResponse adicionarViaCepPesquisaRealizada(ViaCepRequest viaCepRequest) {

        if(viaCepRequest == null || viaCepRequest.toString().isEmpty()){
            throw new BadRequestException("Bad Request, algum dado está inválido ou nulo, por favor revise e tente novamente");
        }

        try{
            return this.converteEntityParaResponse(this.viaCepRepository.save(this.converteRequestParaEntity(viaCepRequest)));
        }catch (Exception ex){
            throw new ServerSideException("Algum error ocorreu, tente novamente em alguns instantes. Error: " + ex.getMessage());
        }

    }

    @Override
    public List<ViaCepResponse> buscarTodasViaCepPesquisas() {

        List<ViaCepEntity> all = this.viaCepRepository.findAll();

        if(all.isEmpty() || all == null){
            throw new NotFoundEntityException("Not Found, nenhuma pesquisa do ViaCep realizada até o momento");
        }

        try{
            return all.stream().map(this::converteEntityParaResponse).collect(Collectors.toList());
        }catch (Exception ex){
            throw new ServerSideException("Algum error ocorreu, tente novamente em alguns instantes. Error: " + ex.getMessage());
        }

    }

    @Override
    public ViaCepEntity converteRequestParaEntity(ViaCepRequest request) {
        return modelMapper.map(request, ViaCepEntity.class);
    }

    @Override
    public ViaCepResponse converteEntityParaResponse(ViaCepEntity entity) {
        return modelMapper.map(entity, ViaCepResponse.class);
    }
}
