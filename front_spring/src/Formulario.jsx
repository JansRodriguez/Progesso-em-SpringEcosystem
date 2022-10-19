export default({botao, eventoAoDigitar, aoCadastrar})=>{
    return(
        <form action="#">
            <input type="text" onChange={eventoAoDigitar} name= 'nome' placeholder="Nome" className="form-control"/>
            <input type="text" onChange={eventoAoDigitar} name='marca' placeholder="Marca" className="form-control"/>

            {
                botao
                ?
                <input type="button" value="Cadastrar" onClick={aoCadastrar} className="btn btn-primary"/>
                :
                <>
                    <input type="button" value="Alterar" className="btn btn-warning"/>
                    <input type="button" value="Remover" className="btn btn-danger"/>
                    <input type="button" value="Cancelar" className="btn btn-success"/>
                </>
            }
            
        </form>
    )
}