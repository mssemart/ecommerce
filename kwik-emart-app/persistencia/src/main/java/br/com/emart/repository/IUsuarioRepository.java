package br.com.emart.repository;

import java.util.Date;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import br.com.emart.entities.Usuario;

public interface IUsuarioRepository extends CrudRepository<Usuario, Long> 
{

}