package br.net.venson.produto.models;

public class Quest {
    private Monster[] mob;
    private MagicItem loot;

    public Quest(Monster[] mob, MagicItem loot) {
        this.mob = mob;
        this.loot = loot;
    }

    public Monster[] getMob() {
        return mob;
    }

    public MagicItem getLoot() {
        return loot;
    }

    public int getChallengeRating() {
        int cr = 0;
        for (Monster monster : mob) {
            cr += monster.getCr();
        }
        return cr;
    }
}
