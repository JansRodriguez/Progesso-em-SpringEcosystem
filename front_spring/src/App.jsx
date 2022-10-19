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
    const aoDigitar = (element)=>{
        setObjProduto({...objProduto, [element.target.name]: element.target.value})//Os 3 ptinhos, ..., está pegando os valores de objProduto.
        //Após, as informações que serão alteradas, no caso nome e marca. Os que possuem atributos "name".
    }
    //Função para cadastrar - 
    const cadastrar =()=>{
        //Por padrão, o fetch realizada requisição do tipo GET, precisa ser configurado para o tipo POST, pois será enviado um dado para o BD.
        fetch('http://localhost:8080/cadastrar', {
            //Características completares para realizar o POST
            method:'post',
            body:JSON.stringify(objProduto),//O corpo/body sendo convertido para texto.
            headers:{
                'Content-type':'application/json',
                'Accept':'application/json'
            }
        })
        .then(retorno => retorno.json())  //O .then retorna uma promise, uma promessa: O then só executada, quando o fetch fizer a requisitação. No caso, promessa que vaiser convertida para JSON.
        .then(retorno_convertido =>{
            console.log(retorno_convertido);
        })//Esse segundo then só vai ser executado quando o 'retorno' da api for convertido para json
    }
    return(
        <>
            {/* <p>{JSON.stringify(objProduto)}</p> //Linha para teste*/}
            <Formulario botao={btnCadastrar}    eventoAoDigitar={aoDigitar} aoCadastrar={cadastrar}/>{/*Inserindo uma propriedade no formalário e definindo sua props  no component Formulario*/}
            <Tabela vetor={produtos}/>
        </>
    )
}