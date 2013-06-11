package br.com.emart.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.emart.entities.Usuario;

public interface IUsuarioRepository extends CrudRepository<Usuario, Long> 
{
	public Usuario findByEmail(String email);
}