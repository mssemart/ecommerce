package br.com.emart.test.integrado;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.emart.entities.CadastroPromocao;
import br.com.emart.repository.ICadastroPromocaoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class CadastroPromocaoIntegrationTest {
	@Autowired
	private ICadastroPromocaoRepository repository;

	@Test
	public void test() {
		CadastroPromocao cadastroPromocao = new CadastroPromocao();

		cadastroPromocao.setNome("jose");
		cadastroPromocao.setEmail("jose@gmail.com");
		cadastroPromocao.setDataCadastro(new java.util.Date());
		cadastroPromocao.setAtivo(true);

		cadastroPromocao = repository.save(cadastroPromocao);

		assertEquals(cadastroPromocao, repository.findOne(cadastroPromocao
				.getCodigoCadastroPromocao()));

	}

	@Test
	public void testFindAll() {

		CadastroPromocao cadastroPromocao = new CadastroPromocao();

		cadastroPromocao.setNome("maria");
		cadastroPromocao.setEmail("maria@gmail.com");
		cadastroPromocao.setDataCadastro(new java.util.Date());
		cadastroPromocao.setAtivo(true);

		cadastroPromocao = repository.save(cadastroPromocao);
		List<CadastroPromocao> cadastroPromocaos = (List<CadastroPromocao>) repository
				.findAll();

		assertNotNull(cadastroPromocaos);
		assertTrue(cadastroPromocaos.contains(cadastroPromocao));

	}
}