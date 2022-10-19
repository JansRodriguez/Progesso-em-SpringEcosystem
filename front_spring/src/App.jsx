import Formulario from "./Formulario";
import Tabela from "./Tabela";
import './App.css';
import { useEffect, useState } from "react";

export default ()=>{

    //Objeto que é correspondente aos atributos da classe e logo as campos da tabela.
    const produto = {
        codigo : 0,
        nome : '',
        marca : ''
    };

    //UseState para os botões do formulário
    const [btnCadastrar, setbtnCadastrar] = useState(true);
    //O useState serve para trabalhar com variáveis, elemento que quero manipular dependendo de uma resposta/ação.

    //useState para armazenamento dos dados inserido
    const [produtos, setProdutos] = useState([]);

    //useState para manipular o objetoProduto, para deixa-lo dinamico.
    //Esse useState que fará a ligação entre o formulário e o back-end, utilizando o objeto como meio.
    const[objProduto, setObjProduto] = useState(produto);

    //useEffect tem a função de realizar a requisição ao backend para obter os dados e aplicar a uma variavel, nesse caso, ao State.
    useEffect(()=>{
        fetch('http://localhost:8080/listar')
        .then(retorno => retorno.json())
        .then(retorno_convertido => setProdutos(retorno_convertido));
        });
    //Função para Obtendo dados do Formulário
    const aoDigitar =(element)=>{
        setObjProduto({...objProduto, [element.target.name]: element.target.value})
    }

    return(
        <>
            <p>{JSON.stringify(objProduto)}</p>
            <Formulario botao={btnCadastrar}    eventoAoDigitar={aoDigitar} />{/*Inserindo uma propriedade no formalário e definindo sua props  no component Formulario*/}
            <Tabela vetor={produtos}/>
        </>
    )
}