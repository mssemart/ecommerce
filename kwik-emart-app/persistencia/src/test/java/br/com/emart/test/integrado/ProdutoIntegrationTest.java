package br.com.emart.test.integrado;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.emart.entities.Categoria;
import br.com.emart.entities.Produto;
import br.com.emart.repository.ICategoriaRepository;
import br.com.emart.repository.IProdutoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class ProdutoIntegrationTest {
	@Autowired
	private IProdutoRepository repository;

	@Autowired
	private ICategoriaRepository repoCategoria;
	
	@Test
	public void test() {
		Produto produto = new Produto();

		produto.setTitulo("Eletronicos");
		produto.setNome("Nokia Lumia 620 Preto");
		produto.setDescricao("Nokia Lumia 620 Preto, Processador Dual Core 1GHz, Windows Phone, 3G, Wi-Fi, Camera 5.0MP, MP3/MP4 Player, Fone de Ouvido, Memoria Interna 8GB");
		produto.setValorUnitario(new BigDecimal(900.00));
		produto.setValorCusto(new BigDecimal(850.00));
		produto.setValorPromocao(new BigDecimal(0.00));
		produto.setImagem("4077.jpg");
		produto.setAtivo(true);
		produto.setDestaque(true);
		produto.setPromocao(false);
		produto.setDataCriacao(new java.util.Date());
		produto.setDataUltimaAtualizacao(new java.util.Date());

		produto = repository.save(produto);

		assertEquals(produto, repository.findOne(produto.getCodigoProduto()));

	}

	@Test
	public void testFindAll() {

		Produto produto = new Produto();

		produto.setTitulo("Eletronicos");
		produto.setNome("TV LED 39'' SAMSUNG");
		produto.setDescricao("TV LED 39'' SAMSUNG UN39EH5003 Full HD Preta - Conversor Digital Interno, HDMI, 120 Hz ");
		produto.setValorUnitario(new BigDecimal(1500.00));
		produto.setValorCusto(new BigDecimal(1300.00));
		produto.setValorPromocao(new BigDecimal(1450.00));
		produto.setImagem("4075.jpg");
		produto.setAtivo(true);
		produto.setDestaque(true);
		produto.setPromocao(true);
		produto.setDataCriacao(new java.util.Date());
		produto.setDataUltimaAtualizacao(new java.util.Date());

		produto = repository.save(produto);
		List<Produto> produtos = (List<Produto>) repository.findAll();

		assertNotNull(produtos);
		assertTrue(produtos.contains(produto));

	}

	@Test
	public void testfindByActive() {

		List<Produto> produtos = (List<Produto>) repository.findByActive();

		assertNotNull(produtos);
		assertTrue(produtos.size() > 0);
	}

	/*
	 * Valida a falha de um produto inativo, pesquisandos os produtos
	 * ativos e validando se ela contem nesta lista
	 */
	@Test
	public void testfindByActiveFail() {

		Produto produto = new Produto();

		produto.setTitulo("Eletrodomesticos");
		produto.setNome("Lavadora de Roupas");
		produto.setDescricao("Lavadora de Roupas 15 Kg Blue Touch Ultra Clean LBU15 - Electrolux");
		produto.setValorUnitario(new BigDecimal(1700.00));
		produto.setValorCusto(new BigDecimal(1000.00));
		produto.setValorPromocao(new BigDecimal(0.00));
		produto.setImagem("4066.jpg");
		produto.setAtivo(false);
		produto.setDestaque(false);
		produto.setPromocao(true);
		produto.setDataCriacao(new java.util.Date());
		produto.setDataUltimaAtualizacao(new java.util.Date());

		produto = repository.save(produto);

		List<Produto> produtos = (List<Produto>) repository.findByActive();

		assertNotNull(produtos);

		// Valida que a categoria nao veio na lista
		assertTrue(!produtos.contains(produto));
	}

	@Test
	public void testInsertCategoria() {
		
		Categoria categoria = repoCategoria.findOne(1L);
		
		Produto produto = new Produto();

		produto.setTitulo("Eletrodomesticos");
		produto.setNome("Lavadora de Roupas");
		produto.setDescricao("Lavadora de Roupas 15 Kg Blue Touch Ultra Clean LBU15 - Electrolux");
		produto.setValorUnitario(new BigDecimal(1700.00));
		produto.setValorCusto(new BigDecimal(1000.00));
		produto.setValorPromocao(new BigDecimal(0.00));
		produto.setImagem("4066.jpg");
		produto.setAtivo(false);
		produto.setDestaque(false);
		produto.setPromocao(true);
		produto.setDataCriacao(new java.util.Date());
		produto.setDataUltimaAtualizacao(new java.util.Date());
		
		produto.setCategoria(categoria);
		
		produto = repository.save(produto);
				
		assertEquals(produto, repository.findOne(produto.getCodigoProduto()));

	}

	@Test
	public void findByKeyWord() {

		List<Produto> produtos = (List<Produto>) repository.findByKeyWord("%15 Kg%");

		assertNotNull(produtos);
		assertTrue(produtos.size() > 0);
	}
	
	
}