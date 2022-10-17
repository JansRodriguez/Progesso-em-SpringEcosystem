package br.com.api.produtos.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.produtos.Servicos.ProdutoServicos;
import br.com.api.produtos.modelo.ProdutoModelo;

//O arquivo de controle é responsável:
//1ª Por controlar as rotas;
//2ª Ter acesso as requisições (post, get, push, delete)
@RestController //Essa annotation indica ao Spring que este é o controlador
public class ProdutoControle {
    
    @Autowired
    private ProdutoServicos ps;
    //O autowired já criar um objeto da classe ProdutoServicos, seu precisar instanciar.

    @GetMapping("/listar")
    //O ProdutoModelo é a classe que vamos manipular, pois é a classe que contém os objetos (dados) da tabela.
    public Iterable <ProdutoModelo> listar(){
        return ps.listar();
    }


    @GetMapping("/") //Essa annotation indica qual será a rota.
    //A rota GetMapping sinaliza que uma VIEW será buscada.
    public String Rota(){
        return "API de rota funcionando";
    }
}
