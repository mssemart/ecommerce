package br.com.emart.service;

import java.util.List;

import br.com.emart.entities.Categoria;
import br.com.emart.entities.Produto;
import br.com.emart.exception.ServiceException;

public interface IProdutoService {
	public List<Produto> findByShowCase()  throws ServiceException;
	public List<Categoria> listCategories()  throws ServiceException;
	public List<Produto> findByKeyWord(String keyWord)  throws ServiceException;
	public Categoria findByCategoria(Long codigoCategoria)  throws ServiceException;
	public void saveProduto(Produto produto)  throws ServiceException;
	public void removeProduto(Long codigoProduto)  throws ServiceException;
}
