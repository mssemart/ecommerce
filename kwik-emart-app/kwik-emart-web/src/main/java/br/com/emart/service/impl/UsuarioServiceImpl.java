package br.com.emart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.emart.entities.Usuario;
import br.com.emart.exception.ServiceException;
import br.com.emart.exception.UsuarioExistenteException;
import br.com.emart.repository.IUsuarioRepository;
import br.com.emart.service.IUsuarioService;
import br.com.emart.util.Utils;

@Service("usuarioService")
@Transactional
public class UsuarioServiceImpl implements IUsuarioService {
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@Override
	public boolean validarUsuario(Usuario usuario) throws ServiceException {
		
		try {
			Usuario u = usuarioRepository.findByEmail(usuario.getEmail());
			
			if(u==null)
				return false;
			
			usuario.setNome(u.getNome());
			usuario.setTelefone(u.getTelefone());
			usuario.setCelular(u.getCelular());
			
			return (u.getEmail().equalsIgnoreCase(usuario.getEmail()) && u.getSenha().equals(Utils.encripta(usuario.getSenha())));
			
		}  catch (Exception e) {
			throw new ServiceException(e);
		}
		

	}

	@Override
	public void salvarUsuario(Usuario usuario)
			throws UsuarioExistenteException,ServiceException {

		try {
			Usuario u = usuarioRepository.findByEmail(usuario.getEmail());
			if(u!=null && u.getEmail().equalsIgnoreCase(usuario.getEmail()))
				throw new UsuarioExistenteException();
			
			usuario.setSenha(Utils.encripta(usuario.getSenha()));
			
			usuarioRepository.save(usuario);			
		} catch (UsuarioExistenteException e) {
			throw e;
		} catch (Exception e) {
			throw new ServiceException(e);
		}

		
	}

	public IUsuarioRepository getUsuarioRepository() {
		return usuarioRepository;
	}

	public void setUsuarioRepository(IUsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public Usuario buscarUsuario(Usuario usuario) throws ServiceException {
		try {
			Usuario u = usuarioRepository.findByEmail(usuario.getEmail());
			
			return u;
			
		}  catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	
	
}
