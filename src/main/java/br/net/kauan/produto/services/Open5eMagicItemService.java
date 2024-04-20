package br.net.kauan.produto.services;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import br.net.kauan.produto.models.MagicItem;
import br.net.kauan.produto.models.Open5eResponse;

@Service
public class Open5eMagicItemService implements Open5eService, MagicItemService {
    @Override
    public MagicItem getRandomItem(String rarity) {
        var items = getMagicItems(rarity);
        var i = (int) (Math.random() * items.length);
        return items[i];
    }

    private MagicItem[] getMagicItems(String rarity) {
        var responseTypeRef = new ParameterizedTypeReference<Open5eResponse<MagicItem>>() {
        };

        var res = client
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/magicitems/")
                        .queryParam("rarity__iexact", rarity)
                        .build())
                .retrieve()
                .body(responseTypeRef);

        if (res != null)
            return res.getResults();
        else
            return new MagicItem[0];
    }
}
