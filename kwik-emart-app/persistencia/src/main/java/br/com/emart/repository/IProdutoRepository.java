package br.com.emart.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

import br.com.emart.entities.Produto;

public interface IProdutoRepository extends CrudRepository<Produto, Long> {
	public List<Produto> findByActive();
	public List<Produto> findByShowCase();
	@Cacheable("produtos")
	public List<Produto> findByKeyWord(String palavraChave);
}