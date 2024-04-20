package br.net.venson.produto.models;

public class Open5eResponse<ResultType> {
    int count;
    ResultType[] results;

    public int getCount() {
        return count;
    }

    public ResultType[] getResults() {
        return results;
    }
}
