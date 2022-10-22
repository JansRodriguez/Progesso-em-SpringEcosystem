package br.com.projeto.exemplo1.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "colaboradores")
@Data
public class Colaborador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nome;
    @OneToOne
    @JoinColumn(name = "codigoCargo", referencedColumnName = "codigo")
    private Cargo cargo; //Criando um objeto que recebe todas as informações da classe Cargo.
}
