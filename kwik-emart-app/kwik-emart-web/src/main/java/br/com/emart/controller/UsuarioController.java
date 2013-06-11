package br.com.emart.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.emart.constants.EnumTipoUsuario;
import br.com.emart.entities.Usuario;
import br.com.emart.exception.ServiceException;
import br.com.emart.exception.UsuarioExistenteException;
import br.com.emart.service.IUsuarioService;

@Controller
public class UsuarioController {
	
	private static final Logger logger = Logger.getLogger(UsuarioController.class);
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		
		ModelAndView mv = new ModelAndView("usuario-login");
		
		return mv;
	}
	
	@RequestMapping(value = "/criarUsuario", method = RequestMethod.GET)
	public ModelAndView criarUsuario() {
		
		ModelAndView mv = new ModelAndView("usuario-novo");
		
		return mv;
	}

	@RequestMapping(value = "/salvarUsuario", method = RequestMethod.POST)
	public @ResponseBody ModelAndView salvarUsuario(Usuario usuario) {
		String info="";
		try {
			usuario.setTipoUsuario(EnumTipoUsuario.NORMAL.getCodigoTipoUsuario());
			usuarioService.salvarUsuario(usuario);
			info =  "Usu&aacute;rio cadastrado com sucesso";
		} catch (UsuarioExistenteException e) {
			info = "Usu&aacute;rio j&aacute; existe!";
		} catch (ServiceException e) {
			logger.error(e);
			info =  "Erro ao tentar salvar Usu&aacute;rio!";
		} 
		
		ModelAndView mv = new ModelAndView("msg");
		mv.addObject("info", info);
		return mv;
	}
	
	@RequestMapping(value = "/validarUsuario", method = RequestMethod.POST)
	public @ResponseBody ModelAndView validarUsuario(Usuario usuario) {
		String info="";
		try {
			if(usuarioService.validarUsuario(usuario))
				info =  "Seja bem vindo,  Sr(a) "+usuario.getNome();
			else
				info =  "Usu&aacute;rio inv&aacute;lido!";
		} catch (ServiceException e) {
			logger.error(e);
			info =  "Erro ao tentar salvar Usu&aacute;rio!";
		} 
		
		ModelAndView mv = new ModelAndView("msg");
		mv.addObject("info", info);
		return mv;
	}	
	
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public @ResponseBody String test() {
		return "Testando retorno String";
	}	

	public IUsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(IUsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
}
