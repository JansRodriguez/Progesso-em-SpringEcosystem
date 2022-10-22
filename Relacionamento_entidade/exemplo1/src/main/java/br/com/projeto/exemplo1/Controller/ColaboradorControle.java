package br.com.projeto.exemplo1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.exemplo1.Model.Colaborador;
import br.com.projeto.exemplo1.Repository.ColaboradorRepositorio;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorControle {
    
    @Autowired
    private ColaboradorRepositorio colaboradorRepositorio;

    @GetMapping("/listar")//métodos para verificar se as informações foram armazenadas
    public Iterable<Colaborador> listar(){
        return colaboradorRepositorio.findAll();
    }

    @PostMapping("/cadastrar")
    public Colaborador cadastrar(@RequestBody Colaborador colaborador){
        return colaboradorRepositorio.save(colaborador);
    }
}
