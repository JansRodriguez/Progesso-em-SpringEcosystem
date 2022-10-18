package br.com.api.produtos.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.produtos.Servicos.ProdutoServicos;
import br.com.api.produtos.modelo.ProdutoModelo;
import br.com.api.produtos.modelo.RespostaModelo;

//O arquivo de controle é responsável:
//1ª Por controlar as rotas;
//2ª Ter acesso as requisições (post, get, push, delete)
@RestController //Essa annotation indica ao Spring que este é o controlador
@CrossOrigin(origins = "*")
public class ProdutoControle {
    
    @Autowired
    private ProdutoServicos ps;
    //O autowired já criar um objeto da classe ProdutoServicos, seu precisar instanciar.

    //Rota para cadastrar dados
    @PostMapping("/cadastrar")
    //Como não sei se virá um erro ou os dados cadastrados, coloco a interrogação.
    public ResponseEntity<?> cadastrar(@RequestBody ProdutoModelo pm){
        return ps.cadastrarAlterar(pm, "cadastrar");
    }

    @GetMapping("/listar")
    //O ProdutoModelo é a classe que vamos manipular, pois é a classe que contém os objetos (dados) da tabela.
    public Iterable <ProdutoModelo> listar(){
        return ps.listar();
    }

    //Rota e método para alterar informação do banco. A classe Serviços já está adaptável para tratar essa informação.
    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody ProdutoModelo pm){
        return ps.cadastrarAlterar(pm, "alterar");
    }

    @GetMapping("/") //Essa annotation indica qual será a rota.
    //A rota GetMapping sinaliza que uma VIEW será buscada.
    public String Rota(){
        return "API de rota funcionando";
    }

    //Rota para exclusão de arquivos
    @DeleteMapping("/remover{identificador}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable long identificador){
        return ps.remover(identificador);
    }
}
