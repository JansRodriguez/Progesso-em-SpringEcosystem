package br.com.api.exemplodois.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.exemplodois.Model.ProdutoModelo;
import br.com.api.exemplodois.Model.ProdutoResposta;
import br.com.api.exemplodois.Repository.ProdutoRepositorio;

@RestController 
@RequestMapping("/api")
public class ProdutoControle {
    
    //- Objeto - Ações de Listar informações do BANCO
    @Autowired
    private ProdutoRepositorio acoesListar;

    //Métodos para listar
    @RequestMapping(value = "/produtos", method = RequestMethod.GET)
    public @ResponseBody List<ProdutoModelo> listar(){
        return acoesListar.findAll();
    }

    //Método para cadastrar
    @RequestMapping(value = "/produtos", method = RequestMethod.POST)
    public @ResponseBody ProdutoModelo cadastrar(@RequestBody ProdutoModelo pm){
        return acoesListar.save(pm);

    }

    //Método para filtrar valores
    @RequestMapping(value = "/produtos{id}", method = RequestMethod.GET)
    public @ResponseBody ProdutoModelo filtrar(@PathVariable Integer id){
        return acoesListar.findById(id);
    }

    //Métdo para alterar dados
    @RequestMapping(value = "/produtos", method = RequestMethod.PUT)
    public @ResponseBody ProdutoModelo alterar(@RequestBody ProdutoModelo pm){
        return acoesListar.save(pm);
    }

    //Método para remover dados
    @RequestMapping(value = "/produtos{id}", method = RequestMethod.DELETE)
    public @ResponseBody ProdutoResposta deletar(@PathVariable Integer id){
        
        ProdutoResposta pr = new ProdutoResposta();

        try {
            ProdutoModelo pm = filtrar(id);
            this.acoesListar.delete(pm);
            pr.setMensagem("Produto deletado com Sucesso!!!");
        } catch (Exception e) {
            pr.setMensagem("Falha ao remover." + e.getMessage());
        }
        return pr;
    }

   /* 
    COMENTADA PARA PODER MANIPULAR DADOS E DEIXAR ABAIXO AS ETAPAS ANTERIORES APLICADAS.
   
   //Pagina Principal
    @RequestMapping(value = "", method = RequestMethod.GET)
    public @ResponseBody String inicio(){
        return "Bem a página Inicial";
    }
  
    //Pagina Sobre
    @RequestMapping(value = "/sobre", method = RequestMethod.GET)
    public @ResponseBody String sobre(){
        return "Essa é a pagina sobre o conteudo";
    }

    //Pagina Contato
    @RequestMapping(value = "/contato", method = RequestMethod.GET)
    public @ResponseBody String contato(){
        return "Essa é a pagina de como encontrar a gente";
    } */
}
