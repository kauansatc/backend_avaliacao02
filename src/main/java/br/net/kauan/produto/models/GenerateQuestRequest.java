package br.net.kauan.produto.models;

public class GenerateQuestRequest {
    private int challengeRating;
    private int nMonsters;
    private String rewardRarity;

    /**
     * Cria uma requisição para gerar uma missão
     * 
     * @param challengeRating Nível de Desafio da missão
     * @param nMonsters       Número de monstros na missão
     * @param rewardRarity    Raridade do item mágico recompensado ao completar a
     *                        missão
     */
    public GenerateQuestRequest(int challengeRating, int nMonsters, String rewardRarity) {
        this.challengeRating = challengeRating;
        this.nMonsters = nMonsters;
        this.rewardRarity = rewardRarity;
    }

    /** @return Nível de Desafio da missão */
    public int getChallengeRating() {
        return challengeRating;
    }

    /** @return Número de monstros da missão */
    public int getnMonsters() {
        return nMonsters;
    }

    /** @return Raridade do item mágico recompensado ao completar */
    public String getRewardRarity() {
        return rewardRarity;
    }
}
