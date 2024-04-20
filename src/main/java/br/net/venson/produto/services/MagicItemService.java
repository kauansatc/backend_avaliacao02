package br.net.venson.produto.services;

import br.net.venson.produto.models.MagicItem;

public interface MagicItemService {
    // TODO change rarity to enum
    public MagicItem getRandomItem(String rarity);
}
