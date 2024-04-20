package br.net.venson.produto.controllers;

import br.net.venson.produto.models.*;
import br.net.venson.produto.services.*;

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
        var res = new ArrayList<Quest>();

        for (var quest : this.quests) {
            if (challengeRating.isPresent() && quest.getChallengeRating() != challengeRating.get()) {
                continue;
            }
            if (nMonsters.isPresent() && quest.getMob().length != nMonsters.get()) {
                continue;
            }
            if (rewardRarity.isPresent() && !quest.getLoot().getRarity().equals(rewardRarity.get())) {
                continue;
            }

            res.add(quest);
        }

        return ResponseEntity.status(200).body(res);
    }

    @PostMapping("/newQuest")
    public ResponseEntity<Quest> generateNewQuest(@RequestBody GenerateQuestRequest req) {
        var mob = monsterService.getRandomMob(
                req.getChallengeRating(),
                req.getnMonsters());
        var loot = magicItemService.getRandomItem(req.getRewardRarity());

        var quest = new Quest(mob, loot);
        quests.add(quest);

        return ResponseEntity.status(200).body(quest);
    }

    @GetMapping("/ajuda")
    public ResponseEntity<HashMap<String, Object>> ajuda() {
        return ResponseEntity.status(200).body(new HashMap<String, Object>() {
            {
                put("estudante", "Kauan Fontanela");
                put("projeto", "Missões para um jogo MMORPG");
            }
        });
    }
}
