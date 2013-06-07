package br.com.emart.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.emart.entities.Produto;

public interface IProdutoRepository extends CrudRepository<Produto, Long> {
	public List<Produto> findByActive();
}