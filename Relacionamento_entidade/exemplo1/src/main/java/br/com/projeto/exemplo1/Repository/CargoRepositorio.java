package br.com.projeto.exemplo1.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.exemplo1.Model.Cargo;

@Repository
public interface CargoRepositorio extends CrudRepository<Cargo, Long>{
    
}
