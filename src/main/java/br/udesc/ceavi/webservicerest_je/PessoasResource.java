package br.udesc.ceavi.webservicerest_je;

import dao.DaoPessoa;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.ModelPessoa;

/**
 * REST Web Service
 *
 * @author jessé
 */
@Path("pessoas")
public class PessoasResource {

    @Context
    private UriInfo context;
    
    public PessoasResource() {}
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<ModelPessoa> getPessoas() {
        ArrayList<ModelPessoa> pessoas = new ArrayList<>();
        DaoPessoa oDao                 = new DaoPessoa();
        List listaPessoas              = oDao.getAll();
        
        for (Object oPessoa : listaPessoas) {
            pessoas.add((ModelPessoa) oPessoa);
        }
        
        return pessoas;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{cod_pessoa}")
    public ModelPessoa getPessoa(@PathParam("cod_pessoa") String codigo_pessoa) {
        DaoPessoa   dao     = new DaoPessoa();
        ModelPessoa oPessoa = (ModelPessoa)dao.getFromId(ModelPessoa.class, Integer.parseInt(codigo_pessoa));
        
        return oPessoa;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String salvaPessoa(ModelPessoa oPessoa) {
        DaoPessoa dao = new DaoPessoa();
        dao.salvar(oPessoa);
        
        return "Deu Boa.";
    }
    
    @DELETE
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{cod_pessoa}")
    public String excluiPessoa(@PathParam("cod_pessoa") String codigo_pessoa) {
        DaoPessoa   dao     = new DaoPessoa();
        ModelPessoa oPessoa = (ModelPessoa)dao.getFromId(ModelPessoa.class, Integer.parseInt(codigo_pessoa));
        
        if(oPessoa != null) {
            dao.excluir(oPessoa);
        }
        
        return "Deu Boa.";
    }
}
