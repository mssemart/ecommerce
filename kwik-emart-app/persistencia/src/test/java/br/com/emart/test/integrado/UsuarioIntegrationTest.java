package br.com.emart.test.integrado;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.emart.entities.Endereco;
import br.com.emart.entities.Usuario;
import br.com.emart.repository.IEnderecoRepository;
import br.com.emart.repository.IUsuarioRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class UsuarioIntegrationTest {
	
	@Autowired
	private IUsuarioRepository repository;

	@Autowired
	private IEnderecoRepository repoEndereco;
	
	
	@Test
	public void test() {
		Usuario usuario = new Usuario();

		usuario.setNome("Jose");
		usuario.setEmail("jose@gmail.com");
		usuario.setSenha("123456");
		usuario.setTipoUsuario(1);
		
		Endereco endereco = new Endereco();

		endereco.setLogradouro("RUA DA PAZ");
		endereco.setNumeroLogradouro("55");
		endereco.setBairro("CENTRO");
		endereco.setSigla("SP");
		endereco.setCep("04501-100");
		endereco.setTipoEndereco(1);		

		List<Endereco> enderecos = new ArrayList<Endereco>();
		enderecos.add(endereco);
		
		usuario = repository.save(usuario);
		
		endereco.setUsuario(usuario);
		endereco = repoEndereco.save(endereco);

		assertEquals(usuario, repository.findOne(usuario.getCodigoUsuario()));

	}
	
	@Test
	public void testInsertEndereco() {
		List<Usuario> usuarios = (List<Usuario>) repository.findAll();
		
		if(usuarios.size()>0)
		{
			Usuario usuario = usuarios.get(0);
			
			Endereco endereco = new Endereco();

			endereco.setLogradouro("AV PAULISTA");
			endereco.setNumeroLogradouro("35");
			endereco.setBairro("BELA VISTA");
			endereco.setSigla("SP");
			endereco.setCep("04501-100");
			endereco.setTipoEndereco(2);		

			endereco.setUsuario(usuario);
			endereco = repoEndereco.save(endereco);

			assertEquals(endereco, repoEndereco.findOne(endereco.getCodigoEndereco()));
		}
		else
			fail("Tabela de usuarios fazia");
	}

	@Test
	public void testFindAll() {

		Usuario usuario = new Usuario();

		usuario.setNome("maria");
		usuario.setEmail("maria@gmail.com");
		usuario.setSenha("59685");
		usuario.setTipoUsuario(1);


		usuario = repository.save(usuario);
		List<Usuario> usuarios = (List<Usuario>) repository.findAll();

		assertNotNull(usuarios);
		assertTrue(usuarios.contains(usuario));

	}
}