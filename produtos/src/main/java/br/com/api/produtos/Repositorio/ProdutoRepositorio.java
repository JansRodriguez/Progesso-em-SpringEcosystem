package br.com.api.produtos.Repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.produtos.modelo.ProdutoModelo;

//A classe repositorio é responsavel pela ações de banco de dados, fazer o CRUD
@Repository
public interface ProdutoRepositorio extends CrudRepository<ProdutoModelo, Long>{
    //Para o crud acontecer, essa interface precisa herdar o CRUDRepository
    //O CRUDRepository, precisa ter duas informaçãoes: 
    //1ª Classe de Modelo, para saber quais atributos serão manipulados
    //2ª Tipo de Dados da chave primária. O atributo que possue o @ID (annotation)
}