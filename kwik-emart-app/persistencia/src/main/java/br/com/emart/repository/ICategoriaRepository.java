package br.com.emart.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

import br.com.emart.entities.Categoria;

public interface ICategoriaRepository extends CrudRepository<Categoria, Long> {
	@Cacheable("categorias")
	public List<Categoria> list();

}
