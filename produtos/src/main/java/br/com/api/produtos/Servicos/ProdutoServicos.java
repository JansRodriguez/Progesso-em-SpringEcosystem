package br.com.api.produtos.Servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.produtos.Repositorio.ProdutoRepositorio;
import br.com.api.produtos.modelo.ProdutoModelo;
import br.com.api.produtos.modelo.RespostaModelo;

//O objetivo dessa classe é realizar a Listagem de Produtos na camada de Serviços
@Service
//Essa annotation realiza a injeção de dependencia para criar um objeto e possibilitar o acesso aos métodos criados nessa classe.
public class ProdutoServicos {
    //Para ter acesso a ações SQL que estão na Classe Produto Repositorio, utilizaremos o AutoWired.
    @Autowired
    private ProdutoRepositorio pr;

    //Então precisamos do objeto do ProdutoModelo, por isso, o AutoWired.
    @Autowired
    //Objeto para retornar as informações incluídas ou não pelo usuário.
    private RespostaModelo rm;

    //Método para listar todos os produtos
    public Iterable <ProdutoModelo> listar(){
        //Iterable é um tipo.
        //O Iterable, retorna lista, é semente ao select * from nome_tabela, no caso produtos, através do FindAll() - método nativo de CRUDRepository
        return pr.findAll();
    }

    //Vamos ter que ter um Método responsavel para cadastrar os produtos.
    //Quando não sabemos o que teremos como resposta (ProdutoModelo ou RespostaModelo), podemos colocar um interrogação
    public ResponseEntity<?> cadastrar(ProdutoModelo pm){
        if(pm.getNome().equals("")){
            rm.setMensagem("O nome do produto é obrigatório");//set(Especificar)
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }
        else if(pm.getMarca().equals("")){
            rm.setMensagem("O nome da marca é obrigatório");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.CREATED);
        }
    }
}
