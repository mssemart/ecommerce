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

import br.com.emart.entities.Banner;
import br.com.emart.repository.IBannerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class BannerIntegrationTest {
	
	@Autowired
	private IBannerRepository repository;

	@Test
	public void test() {
		Banner banner = new Banner();

		banner.setTitulo("Promocao dias das maes");
		banner.setBannerUrl("4509.jpg");
		banner.setDiretorioImagem("/imagem");
		banner.setDataInicio(new java.util.Date());
		banner.setDataFim(new java.util.Date());

		banner = repository.save(banner);

		assertEquals(banner, repository.findOne(banner.getCodigoBanner()));

	}

	@Test
	public void testFindAll() {

		Banner banner = new Banner();

		banner.setTitulo("Promocao dias dos pais");
		banner.setBannerUrl("4800.jpg");
		banner.setDiretorioImagem("/imagem");
		banner.setDataInicio(new java.util.Date());
		banner.setDataFim(new java.util.Date());

		banner = repository.save(banner);
		List<Banner> banners = (List<Banner>) repository.findAll();

		assertNotNull(banners);
		assertTrue(banners.contains(banner));

	}

	public IBannerRepository getRepository() {
		return repository;
	}

	public void setRepository(IBannerRepository repository) {
		this.repository = repository;
	}
	
	
	
	
}