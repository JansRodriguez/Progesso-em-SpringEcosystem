package br.com.projetos.one_to_one.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetos.one_to_one.Model.Colaborador;
import br.com.projetos.one_to_one.Repository.ColaboradorRepositoio;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorControle {
    
    @Autowired
    private ColaboradorRepositoio colaboradorRepositoio;

    @GetMapping("/listar")
    public Iterable<Colaborador> listar(){
        return colaboradorRepositoio.findAll();
    }

    @PostMapping("/cadastrar")
    public Colaborador cadastrar(@RequestBody Colaborador colaborador){
        return colaboradorRepositoio.save(colaborador);
    }


}
