package br.com.emart.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.emart.entities.Banner;

public interface IBannerRepository extends CrudRepository<Banner, Long> 
{

}