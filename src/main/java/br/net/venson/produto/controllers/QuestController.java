package br.net.venson.produto.controllers;

import br.net.venson.produto.models.*;
import br.net.venson.produto.services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class QuestController {
    @Autowired
    private MonsterService monsterService = new Open5eMonsterService();
    @Autowired
    private MagicItemService magicItemService = new Open5eMagicItemService();

    private ArrayList<Quest> quests = new ArrayList<>() {
        {
            add(new Quest(
                    monsterService.getRandomMob(12, 3),
                    magicItemService.getRandomItem("uncommon")));
        }
    };

    @GetMapping("/getQuests")
    public ResponseEntity<ArrayList<Quest>> getRequests() {
        return ResponseEntity.status(200).body(quests);
    }

    // @PostMapping("/postar")
    // public ResponseEntity<Object> postar(@RequestBody Solicitacao solicitacao) {
    // Endereco enderecoDestinatario =
    // cepService.converteCep(solicitacao.getDestinatario());
    // Endereco enderecoRemetente =
    // cepService.converteCep(solicitacao.getRemetente());
    // Postagem postagem = new Postagem(
    // solicitacao.getProduto(),
    // enderecoDestinatario,
    // enderecoRemetente);
    // listaDePostagems.add(postagem);
    // return ResponseEntity.status(200).body(postagem);
    // }
}
