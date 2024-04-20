package br.net.venson.produto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.net.venson.produto.models.Monster;
import br.net.venson.produto.services.Open5eMonsterService;

@SpringBootTest
class ProdutoApplicationTests {
	@Test
	void contextLoads() {
		Open5eMonsterService service = new Open5eMonsterService();
		var monsters = service.getRandomMob(12, 1);

		for (Monster monster : monsters) {
			System.out.printf(
					"Monster: %s, CR: %f\n",
					monster.getName(),
					monster.getCr());
		}
	}
}
