package br.net.kauan.produto.models;

/**
 * Resposta de uma requisição à API Open5e
 * 
 * @param <ResultType> Tipo do item retornado pela API
 */
public class Open5eResponse<ResultType> {
    int count;
    ResultType[] results;

    /** @return Número de items encontrados */
    public int getCount() {
        return count;
    }

    /** @return Items encontrados */
    public ResultType[] getResults() {
        return results;
    }
}
