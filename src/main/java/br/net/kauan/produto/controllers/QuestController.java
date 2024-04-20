package br.net.kauan.produto.controllers;

import br.net.kauan.produto.models.*;
import br.net.kauan.produto.services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

@RestController
public class QuestController {
    @Autowired
    private MonsterService monsterService = new Open5eMonsterService();
    @Autowired
    private MagicItemService magicItemService = new Open5eMagicItemService();

    private ArrayList<Quest> quests = new ArrayList<>();

    @GetMapping("/quests")
    public ResponseEntity<ArrayList<Quest>> quests(@RequestParam Optional<Integer> challengeRating,
            @RequestParam Optional<Integer> nMonsters, @RequestParam Optional<String> rewardRarity) {
        // cria uma lista de quests que atendem aos critérios
        var res = new ArrayList<Quest>();

        // para cada quest
        for (var quest : this.quests) {
            // filtro de challengeRating
            if (challengeRating.isPresent() && quest.getChallengeRating() != challengeRating.get()) {
                continue;
            }
            // filtro de nMonsters
            if (nMonsters.isPresent() && quest.getMob().length != nMonsters.get()) {
                continue;
            }
            // filtro de rewardRarity
            if (rewardRarity.isPresent() && !quest.getLoot().getRarity().equals(rewardRarity.get())) {
                continue;
            }

            // caso passe por todos os filtros, adiciona à lista de quests
            res.add(quest);
        }

        // retorna a lista de quests filtrada
        return ResponseEntity.status(200).body(res);
    }

    @PostMapping("/newQuest")
    public ResponseEntity<Quest> generateNewQuest(@RequestBody GenerateQuestRequest req) {
        // gera um novo grupo de monstros e um item mágico
        var mob = monsterService.getRandomMob(
                req.getChallengeRating(),
                req.getnMonsters());
        var loot = magicItemService.getRandomItem(req.getRewardRarity());

        // cria uma nova quest e adiciona à lista de quests
        var quest = new Quest(mob, loot);
        quests.add(quest);

        // retorna a nova quest
        return ResponseEntity.status(200).body(quest);
    }

    @GetMapping("/ajuda")
    public ResponseEntity<HashMap<String, Object>> ajuda() {
        // rota de informações sobre o desenvolvedor e o projeto
        return ResponseEntity.status(200).body(new HashMap<String, Object>() {
            {
                put("estudante", "Kauan Fontanela");
                put("projeto", "Missões para um jogo MMORPG");
            }
        });
    }
}
