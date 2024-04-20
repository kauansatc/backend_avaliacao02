package br.net.kauan.produto.models;

/**
 * Missão que consiste em derrotar um grupo de monstros e obter um item mágico
 */
public class Quest {
    private Monster[] mob;
    private MagicItem loot;

    /**
     * Cria uma missão com um grupo de monstros e um item mágico como recompensa
     * 
     * @param mob  Grupo de monstros
     * @param loot Item mágico recompensado ao completar quest
     */
    public Quest(Monster[] mob, MagicItem loot) {
        this.mob = mob;
        this.loot = loot;
    }

    /** @return Grupo de monstros */
    public Monster[] getMob() {
        return mob;
    }

    /** @return Item mágico recompensado ao completar quest */
    public MagicItem getLoot() {
        return loot;
    }

    /**
     * @return Nível Desafio da missão (soma de todos os CR dos monstros)
     * @see Monster#getCr()
     */
    public int getChallengeRating() {
        int cr = 0;
        for (Monster monster : mob) {
            cr += monster.getCr();
        }
        return cr;
    }
}
