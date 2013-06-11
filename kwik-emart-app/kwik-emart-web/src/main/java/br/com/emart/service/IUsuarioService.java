package br.com.emart.service;

import br.com.emart.entities.Usuario;
import br.com.emart.exception.ServiceException;
import br.com.emart.exception.UsuarioExistenteException;

public interface IUsuarioService {
	public boolean validarUsuario(Usuario usuario) throws ServiceException;
	public void salvarUsuario(Usuario usuario) throws UsuarioExistenteException,ServiceException;
	public Usuario buscarUsuario(Usuario usuario) throws ServiceException;
}
