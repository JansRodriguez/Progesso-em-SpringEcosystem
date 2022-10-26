package br.com.projetos.one_to_one.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projetos.one_to_one.Model.Cargo;

@Repository
public interface CargoRepositorio extends CrudRepository<Cargo, Long>{

}