package br.net.venson.produto.models;

public class GenerateQuestRequest {
    private int challengeRating;
    private int nMonsters;
    private String rewardRarity;

    public GenerateQuestRequest(int challengeRating, int nMonsters, String rewardRarity) {
        this.challengeRating = challengeRating;
        this.nMonsters = nMonsters;
        this.rewardRarity = rewardRarity;
    }

    public int getChallengeRating() {
        return challengeRating;
    }

    public int getnMonsters() {
        return nMonsters;
    }

    public String getRewardRarity() {
        return rewardRarity;
    }
}
