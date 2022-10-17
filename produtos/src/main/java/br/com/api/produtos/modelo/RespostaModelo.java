package br.com.api.produtos.modelo;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

//Responsável por retornar um feedback, caso aconteça alguma falha na API, em um dos momentos do CRUD.

@Component //Essa annotation é responsavel pela injeção de dependência, ficando por conta do Spring a criação de um objeto relacionado com essa classe.
//Com essa annotation, o desenvolvedor não precisa mais instanciar um objeto do tipo RespostaModelo, mas o Spring.
//Por isso que as anotações são importantes, pois sinaliza o tipo/serviço das classes.
@Getter
@Setter
public class RespostaModelo {
    
    private String mensagem;
}
