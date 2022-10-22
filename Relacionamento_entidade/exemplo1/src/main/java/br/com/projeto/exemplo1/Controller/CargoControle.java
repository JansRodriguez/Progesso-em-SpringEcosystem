package br.com.projeto.exemplo1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.exemplo1.Model.Cargo;
import br.com.projeto.exemplo1.Repository.CargoRepositorio;

//Classe responsável pelas rotas das páginas.
@RestController
@RequestMapping("/cargos")//rota que ira axibir a informação
public class CargoControle {

    @Autowired
    private CargoRepositorio cargoRepositorio;

    @GetMapping("/listar")
    public Iterable<Cargo> listar(){
        return cargoRepositorio.findAll();
    }

    @PostMapping("/cadastrar")
    public Cargo cadastrar(@RequestBody Cargo cargo){//Nessa linha se espera os atributos da classe Cargo// Se cria um objeto para manipular melhor a classe
        return cargoRepositorio.save(cargo);
    }

   
}
