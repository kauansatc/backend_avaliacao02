package br.net.venson.produto.services;

import br.net.venson.produto.models.Monster;

public interface MonsterService {
    /**
     * Retorna um monstro aleatório de um nível de desafio específico
     * 
     * @param challengeRating Nível de desafio do monstro
     * @return Monstro aleatório
     */
    public Monster getRandomMonster(int challengeRating);

    /**
     * Cria um grupo de monstros de CR aleatório
     * 
     * @param challengeRating Nível de desafio dos monstros (todos somados)
     * @param nMonsters       Número de monstros no grupo
     * @return Grupo de monstros aleatórios
     */
    public Monster[] getRandomMob(int challengeRating, int nMonsters);
}
