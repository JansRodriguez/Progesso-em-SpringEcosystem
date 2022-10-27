package br.com.produtos.one_to_many.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.produtos.one_to_many.Model.Postagem;
import br.com.produtos.one_to_many.Repository.PostagemRepositotio;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/postagens")
public class PostagemControle {

    @Autowired
    private PostagemRepositotio postagemRepositotio;

    @GetMapping("/listar")
    public Iterable<Postagem> listar(){
        return postagemRepositotio.findAll();
    }

    @PostMapping(value="/cadastrar")
    public Postagem cadastrar(@RequestBody Postagem postagem) {        
        return postagemRepositotio.save(postagem);
    }
    
}
