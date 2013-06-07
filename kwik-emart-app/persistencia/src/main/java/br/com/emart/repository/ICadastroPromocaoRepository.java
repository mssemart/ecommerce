package br.com.emart.repository;

import java.util.Date;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import br.com.emart.entities.CadastroPromocao;

public interface ICadastroPromocaoRepository extends CrudRepository<CadastroPromocao, Long> 
{

}