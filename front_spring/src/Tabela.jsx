export default({vetor})=>{
    return(
        <table className="table">
            <thead> {/* Tag semantica de marca do cabeçalho da tabela */}
                <tr> {/* Tag de linha */}
                    <th>#</th> {/* Tag de identificação do cabeçalho */}
                    <th>Nome</th>
                    <th>Marca</th>
                    <th>Selecionar</th>
                </tr>
            </thead>
            <tbody>
                {/* <tr>
                    <td></td> Tag do corpo da tabela 
                    <td></td>
                    <td></td>
                    <td></td>
                </tr> */}
                {
                    vetor.map((objeto, indice)=>(
                    <tr key={indice}>
                        <td>{indice+1}</td>
                        <td>{objeto.nome}</td>
                        <td>{objeto.marca}</td>
                        <td><button className="btn btn-success">Selecionar</button></td>
                    </tr>
                    ))
                }

            </tbody>
        </table>
    )
}