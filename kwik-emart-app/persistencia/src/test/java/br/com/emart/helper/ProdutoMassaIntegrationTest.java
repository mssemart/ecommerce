package br.com.emart.helper;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

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
public class ProdutoMassaIntegrationTest {
	@Autowired
	private IProdutoRepository repository;

	@Autowired
	private ICategoriaRepository repoCategoria;

	@Test
	public void testInsertCategoria() {

		Categoria categoria = repoCategoria.findOne(1L);

		for (int i = 1; i < 15; i++) {
			
			Produto produto = new Produto();
	
			produto.setTitulo("Eletrodomesticos "+i);
			produto.setNome("Lavadora de Roupas "+i);
			produto.setDescricao("Lavadora de Roupas 15 Kg Blue Touch Ultra Clean LBU15 - Electrolux "+i);
			produto.setValorUnitario(new BigDecimal(1700.00));
			produto.setValorCusto(new BigDecimal(1000.00));
			produto.setValorPromocao(new BigDecimal(0.00));
			produto.setImagem("4066.jpg");
			produto.setAtivo(true);
			produto.setDestaque(true);
			produto.setPromocao(false);
			produto.setDataCriacao(new java.util.Date());
			produto.setDataUltimaAtualizacao(new java.util.Date());
			
			produto.setCategoria(categoria);
			
			produto = repository.save(produto);
					
			assertEquals(produto, repository.findOne(produto.getCodigoProduto()));
		}

	}
	
	
}