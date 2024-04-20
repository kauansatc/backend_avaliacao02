package br.net.venson.produto.services;

import java.util.Random;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import br.net.venson.produto.models.Monster;
import br.net.venson.produto.models.Open5eResponse;

@Service
public class Open5eMonsterService implements MonsterService {
    private RestClient client = RestClient.create("https://api.open5e.com/");

    @Override
    public Monster getRandomMonster(int challengeRating) {
        var monsters = getMonsters(challengeRating);
        var i = (int) (Math.random() * monsters.length);
        return monsters[i];
    }

    @Override
    public Monster[] getRandomMob(int challengeRating, int nMonsters) {
        int[] parts = new int[nMonsters];
        Monster[] monsters = new Monster[nMonsters];
        Random random = new Random();

        int sum = 0;
        for (int i = 0; i < nMonsters - 1; i++) {
            parts[i] = random.nextInt(challengeRating - sum) + 1;
            monsters[i] = getRandomMonster(parts[i]);
            sum += parts[i];
        }

        parts[nMonsters - 1] = challengeRating - sum;
        monsters[nMonsters - 1] = getRandomMonster(parts[nMonsters - 1]);

        return monsters;
    }

    private Monster[] getMonsters(int challengeRating) {
        var responseTypeRef = new ParameterizedTypeReference<Open5eResponse<Monster>>() {
        };

        var res = client
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/monsters/")
                        .queryParam("cr", challengeRating)
                        .build())
                .retrieve()
                .body(responseTypeRef);

        if (res != null)
            return res.getResults();

        return new Monster[0];
    }
}
