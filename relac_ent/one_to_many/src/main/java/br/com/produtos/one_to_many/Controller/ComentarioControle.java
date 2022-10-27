package br.com.produtos.one_to_many.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.produtos.one_to_many.Model.Comentario;
import br.com.produtos.one_to_many.Repository.ComentarioRepositorio;

@RestController
@RequestMapping("/comentarios")
public class ComentarioControle {

    @Autowired
    private ComentarioRepositorio comentarioRepositorio;

    @GetMapping("/listar")
    public Iterable<Comentario> listar(){
        return comentarioRepositorio.findAll();
    }

    @PostMapping("/cadastrar")
    public Comentario cadastrar(@RequestBody Comentario comentario){
        return comentarioRepositorio.save(comentario);
    }
}
