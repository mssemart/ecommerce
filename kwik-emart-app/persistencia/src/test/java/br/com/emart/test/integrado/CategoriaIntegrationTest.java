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

import br.com.emart.entities.Categoria;
import br.com.emart.repository.ICategoriaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class CategoriaIntegrationTest {
	@Autowired
	private ICategoriaRepository repository;

	@Test
	public void test() {
		Categoria categoria = new Categoria();

		categoria.setNome("Eletronico");
		categoria.setDescricao("Eletronicos");
		categoria.setAtivo(true);

		categoria = repository.save(categoria);

		assertEquals(categoria,
				repository.findOne(categoria.getCodigoCategoria()));
	}

	@Test
	public void testFindAll() {

		List<Categoria> categorias = (List<Categoria>) repository.findAll();

		assertNotNull(categorias);
		assertTrue(categorias.size()>0);

	}

	@Test
	public void testfindByActive() {

		List<Categoria> categorias = (List<Categoria>) repository
				.findByActive();

		assertNotNull(categorias);
		assertTrue(categorias.size() > 0);
	}

	/*
	 * Valida a falha de uma categoria inativa, pesquisandos as categorias
	 * ativas e validando se ela contem nesta lista
	 */
	@Test
	public void testfindByActiveFail() {

		Categoria categoria = new Categoria();

		categoria.setNome("Informatica");
		categoria.setDescricao("Informatica");
		categoria.setAtivo(false);

		categoria = repository.save(categoria);

		List<Categoria> categorias = (List<Categoria>) repository.findByActive();

		assertNotNull(categorias);

		// Valida que a categoria nao veio na lista
		assertTrue(!categorias.contains(categoria));
	}

}