package br.com.api.exemplodois.Repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import br.com.api.exemplodois.Model.ProdutoModelo;

public interface ProdutoRepositorio extends CrudRepository <ProdutoModelo, Long>{

    //.Listar todos os produtos

    //Definindo o retorno: Conjunto de produtos, é uma lista:
    List<ProdutoModelo> findAll();

    //.Pesquisar por códigos

    //Definindo retorno: Um objeto/classe por critério
    ProdutoModelo findById(int id);

    //.Remover produtos

    //Defininodo Retorno: necessário passar um objeto para ele saber o que irá deletar, e seu retorno será vazio
    void delete(ProdutoModelo pm);

    //.Cadastrar-Alterar produtos (insert/update)
    
    //Definindo retorno: O objeto que foi alterado:
    //ProdutoModelo save(ProdutoModelo pm); vamos escrever conforme documentação:
    //<S(classe temporária) extends T(tipo do crudrepositorio-classe)> S save(S entity);
    <ProdMod extends ProdutoModelo> ProdMod save(ProdMod pm);
}
