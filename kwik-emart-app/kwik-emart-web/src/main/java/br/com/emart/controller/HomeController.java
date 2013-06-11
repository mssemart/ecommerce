package br.com.emart.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.emart.entities.Categoria;
import br.com.emart.entities.Produto;
import br.com.emart.service.IProdutoService;

@Controller
public class HomeController {
	
	private static final Logger logger = Logger.getLogger(HomeController.class);
	
	@Autowired
	private IProdutoService produtoService;

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index() {
		
		List<Categoria> categorias = null; 
		List<Produto> produtos = null;
				
		try {
			categorias = produtoService.listCategories();
		} catch (Exception e) {
			logger.error(e);
		}

		try {
			// efetua consulta de produtos em destaque ou promocao
			produtos = produtoService.findByShowCase();
			
		} catch (Exception e) {
			logger.error(e);
		}
		
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("categorias", categorias);
		mv.addObject("produtos", produtos);
		
		return mv;
	}

	
	@RequestMapping(value = "/pesquisa", method = RequestMethod.POST)
	public ModelAndView pesquisa(String palavraChave) {
		
		List<Categoria> categorias = null; 
		List<Produto> produtos = null;
				
		try {
			categorias = produtoService.listCategories();
		} catch (Exception e) {
			logger.error(e);
		}

		try {
			// traz os produtos com a palavraChave
			produtos = produtoService.findByKeyWord(palavraChave);
		} catch (Exception e) {
			logger.error(e);
		}
		
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("categorias", categorias);
		mv.addObject("produtos", produtos);
		
		return mv;
	}	
	
	@RequestMapping(value = "/produtosPorCategoria", method = RequestMethod.GET)
	public ModelAndView produtosPorCategoria(Long codigoCategoria) {
		
		List<Categoria> categorias = null; 
		List<Produto> produtos = null;
				
		try {
			categorias = produtoService.listCategories();
		} catch (Exception e) {
			logger.error(e);
		}

		try {
			Categoria categoria = produtoService.findByCategoria(codigoCategoria);
			// traz os produtos com a palavraChave
			if(categoria!=null)
				produtos = (List<Produto>) categoria.getProdutos();
		} catch (Exception e) {
			logger.error(e);
		}
		
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("categorias", categorias);
		mv.addObject("produtos", produtos);
		
		return mv;
	}	
}
