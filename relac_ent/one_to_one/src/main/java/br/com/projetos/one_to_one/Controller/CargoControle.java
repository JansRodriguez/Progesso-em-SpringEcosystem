package br.com.projetos.one_to_one.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetos.one_to_one.Model.Cargo;
import br.com.projetos.one_to_one.Repository.CargoRepositorio;

@RestController
@RequestMapping("/cargos")
public class CargoControle {
    
    @Autowired
    private CargoRepositorio cargoRepositorio;

    @GetMapping("/listar")
    public Iterable<Cargo> listar(){
        return cargoRepositorio.findAll(); 
    }

    @PostMapping("/cadastrar")
    public Cargo cadastrar(@RequestBody Cargo cargo){
        return cargoRepositorio.save(cargo);
    }
}
