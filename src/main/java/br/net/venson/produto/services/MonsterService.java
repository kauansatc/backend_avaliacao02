package br.net.venson.produto.services;

import br.net.venson.produto.models.Monster;

public interface MonsterService {
    public Monster getRandomMonster(int challengeRating);

    public Monster[] getRandomMob(int challengeRating, int nMonsters);
}
