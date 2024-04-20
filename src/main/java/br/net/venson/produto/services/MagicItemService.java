package br.net.venson.produto.services;

import br.net.venson.produto.models.MagicItem;

public interface MagicItemService {
    /**
     * Retorna um item mágico aleatório de uma raridade específica
     * 
     * @param rarity Raridade do item mágico
     * @return Item mágico aleatório
     */
    public MagicItem getRandomItem(String rarity);
}
