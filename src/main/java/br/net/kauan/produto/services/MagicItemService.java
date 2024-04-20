package br.net.kauan.produto.services;

import br.net.kauan.produto.models.MagicItem;

public interface MagicItemService {
    /**
     * Retorna um item mágico aleatório de uma raridade específica
     * 
     * @param rarity Raridade do item mágico
     * @return Item mágico aleatório
     */
    public MagicItem getRandomItem(String rarity);
}
