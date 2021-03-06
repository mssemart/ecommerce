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
}