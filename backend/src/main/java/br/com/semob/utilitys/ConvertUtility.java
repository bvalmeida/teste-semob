package br.com.semob.utilitys;

public interface ConvertUtility<E, Req, Res>{

    public E converteRequestParaEntity(Req request);

    public Res converteEntityParaResponse(E entity);

}
