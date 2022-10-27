package br.com.produtos.one_to_many.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.produtos.one_to_many.Model.Comentario;

@Repository
public interface ComentarioRepositorio extends CrudRepository<Comentario, Long>{
    
}
