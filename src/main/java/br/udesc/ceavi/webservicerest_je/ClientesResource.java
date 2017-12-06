package br.udesc.ceavi.webservicerest_je;

import dao.DaoCliente;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.ModelCliente;

/**
 * REST Web Service
 *
 * @author jessé
 */
@Path("clientes")
public class ClientesResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ClientesResource
     */
    public ClientesResource() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<ModelCliente> getCLientes() {
        ArrayList<ModelCliente> clientes = new ArrayList<>();
        DaoCliente oDao                  = new DaoCliente();
        List listaClientes               = oDao.getAll();
        
        for (Object oPessoa : listaClientes) {
            clientes.add((ModelCliente) oPessoa);
        }
        
        return clientes;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{cod_cliente}")
    public ModelCliente getPessoa(@PathParam("cod_cliente") String codigo_cliente) {
        DaoCliente   dao     = new DaoCliente();
        ModelCliente oPessoa = (ModelCliente)dao.getFromId(ModelCliente.class, Integer.parseInt(codigo_cliente));
        
        return oPessoa;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String salvaCliente(ModelCliente oCliente) {
        DaoCliente dao = new DaoCliente();
        dao.salvar(oCliente);
        
        return "Deu Boa.";
    }
    
    @DELETE
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{cod_cliente}")
    public String excluiCliente(@PathParam("cod_cliente") String codigo_cliente) {
        DaoCliente   dao      = new DaoCliente();
        ModelCliente oCliente = (ModelCliente)dao.getFromId(ModelCliente.class, Integer.parseInt(codigo_cliente));
        
        if(oCliente != null) {
            dao.excluir(oCliente);
        }
        
        return "Deu Boa.";
    }
}
