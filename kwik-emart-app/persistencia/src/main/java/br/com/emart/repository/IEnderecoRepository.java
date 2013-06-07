package br.com.emart.repository;


import java.util.List;
import org.springframework.data.repository.CrudRepository;

import br.com.emart.entities.Endereco;

public interface IEnderecoRepository extends CrudRepository<Endereco, Long> 
{

}