import Formulario from "./Formulario";
import Tabela from "./Tabela";
import './App.css';
import { useEffect, useState } from "react";

export default ()=>{

    //UseState para os botões do formulário
    const [btnCadastrar, setbtnCadastrar] = useState(true);
    //O useState serve para trabalhar com variáveis, elemento que quero manipular dependendo de uma resposta/ação.

    //useState para armazenamento dos dados inserido
    const [produtos, setProdutos] = useState([]);

    //useEffect tem a função de realizar a requisição ao backend para obter os dados e aplicar a uma variavel, nesse caso, ao State.
    useEffect(()=>{
        fetch('http://localhost:8080/listar')
        .then(retorno => retorno.json())
        .then(retorno_convertido => setProdutos(retorno_convertido));
        });


    return(
        <>
            <Formulario botao={btnCadastrar}/>{/*Inserindo uma propriedade no formalário e definindo sua props  no component Formulario*/}
            <Tabela vetor={produtos}/>
        </>
    )
}