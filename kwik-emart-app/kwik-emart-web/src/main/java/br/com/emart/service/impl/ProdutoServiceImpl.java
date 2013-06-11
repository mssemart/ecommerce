package br.com.emart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.emart.entities.Categoria;
import br.com.emart.entities.Produto;
import br.com.emart.exception.ServiceException;
import br.com.emart.repository.ICategoriaRepository;
import br.com.emart.repository.IProdutoRepository;
import br.com.emart.service.IProdutoService;

@Service("produtoService")
@Transactional
public class ProdutoServiceImpl implements IProdutoService {

	@Autowired
	private ICategoriaRepository repoCategoria;
	
	@Autowired
	private IProdutoRepository repoProduto;	
	
	@Override
	public List<Produto> findByShowCase() throws ServiceException {
		try {
			List<Produto> produtos = repoProduto.findByShowCase();
			
			// Se nao tiver produtos na condicao anterior traz os cincos primeiros produtos
			if(produtos==null || produtos.size()==0)
			{
				produtos = repoProduto.findByActive();
				if(produtos!=null && produtos.size()>0)
				{
					produtos = produtos.subList(0, 4);
				}
			}
			
			return produtos;
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<Categoria> listCategories() throws ServiceException {
		try {
			return repoCategoria.list();
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<Produto> findByKeyWord(String keyWord) throws ServiceException {
		try {
			return repoProduto.findByKeyWord("%"+keyWord+"%");
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Categoria findByCategoria(Long codigoCategoria)
			throws ServiceException {
		try {
			return repoCategoria.findOne(codigoCategoria);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void saveProduto(Produto produto) throws ServiceException {
		try {
			repoProduto.save(produto);
		} catch (Exception e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public void removeProduto(Long codigoProduto) throws ServiceException {
		try {
			repoProduto.delete(codigoProduto);
		} catch (Exception e) {
			throw new ServiceException(e);
		}

	}

}
