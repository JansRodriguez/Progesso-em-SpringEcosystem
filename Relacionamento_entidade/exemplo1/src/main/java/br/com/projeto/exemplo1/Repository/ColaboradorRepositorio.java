package br.com.projeto.exemplo1.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.exemplo1.Model.Colaborador;

@Repository
public interface ColaboradorRepositorio extends CrudRepository<Colaborador, Long> {
    
}
