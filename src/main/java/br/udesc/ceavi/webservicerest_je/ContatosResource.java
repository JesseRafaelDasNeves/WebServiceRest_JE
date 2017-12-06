package br.udesc.ceavi.webservicerest_je;

import dao.DaoContato;
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
import model.ModelContato;

/**
 * REST Web Service
 *
 * @author jessé
 */
@Path("contatos")
public class ContatosResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ContatosResource
     */
    public ContatosResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<ModelContato> getCLientes() {
        ArrayList<ModelContato> contatos = new ArrayList<>();
        DaoContato oDao                  = new DaoContato();
        List listaContatos               = oDao.getAll();
        
        for (Object oPessoa : listaContatos) {
            contatos.add((ModelContato) oPessoa);
        }
        
        return contatos;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{cod_contato}")
    public ModelContato getPessoa(@PathParam("cod_contato") String codigo_contato) {
        DaoContato   dao     = new DaoContato();
        ModelContato oPessoa = (ModelContato)dao.getFromId(ModelContato.class, Integer.parseInt(codigo_contato));
        
        return oPessoa;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String salvaContato(ModelContato oContato) {
        DaoContato dao = new DaoContato();
        dao.salvar(oContato);
        
        return "Deu Boa.";
    }
    
    @DELETE
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{cod_contato}")
    public String excluiContato(@PathParam("cod_contato") String codigo_contato) {
        DaoContato   dao      = new DaoContato();
        ModelContato oContato = (ModelContato)dao.getFromId(ModelContato.class, Integer.parseInt(codigo_contato));
        
        if(oContato != null) {
            dao.excluir(oContato);
        }
        
        return "Deu Boa.";
    }
}
