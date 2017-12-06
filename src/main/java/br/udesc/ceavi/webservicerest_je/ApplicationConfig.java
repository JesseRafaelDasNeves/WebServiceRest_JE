package br.udesc.ceavi.webservicerest_je;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author jessé
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(br.udesc.ceavi.webservicerest_je.ClientesResource.class);
        resources.add(br.udesc.ceavi.webservicerest_je.ContatosResource.class);
        resources.add(br.udesc.ceavi.webservicerest_je.PessoasResource.class);
    }
    
}
