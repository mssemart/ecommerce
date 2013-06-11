package br.com.emart.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.emart.constants.EnumTipoUsuario;
import br.com.emart.entities.Usuario;
import br.com.emart.exception.ServiceException;
import br.com.emart.exception.UsuarioExistenteException;
import br.com.emart.service.IUsuarioService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class UsuarioServiceIntegrationTest {

	@Autowired
	private IUsuarioService usuarioService;

	@Test
	public void test() throws UsuarioExistenteException,ServiceException {

		Usuario usuario = new Usuario();

		usuario.setNome("Jose");
		usuario.setEmail("jose@gmail.com");
		usuario.setSenha("123456");
		usuario.setTipoUsuario(EnumTipoUsuario.NORMAL.getCodigoTipoUsuario());

		
		usuarioService.salvarUsuario(usuario);
	}

	@Test
	public void testValidaUsuario() throws ServiceException {
		Usuario usuario = new Usuario();
		usuario.setEmail("jose@gmail.com");
		usuario.setSenha("123456");
		
		assertTrue(usuarioService.validarUsuario(usuario));
	}

	
	public IUsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(IUsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

}
