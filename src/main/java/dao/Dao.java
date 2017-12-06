package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jesse Rafael
 */
public abstract class Dao {
    
    protected EntityManager Entity;
    
    public Dao() {
        this.Entity = this.getInstanceEntity();
    }
    
    private EntityManager getInstanceEntity() {
        if(this.Entity == null) {
            EntityManagerFactory oEntityFactory = Persistence.createEntityManagerFactory("WEB_SERVICE_PU");
            return oEntityFactory.createEntityManager();
        }
        
        return this.Entity;
    }
    
    public boolean salvar(Object oModel){
        this.begin();
        try {
            this.Entity.merge(oModel);
            this.commit();
            return true;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            this.rollback();
            return false;
        }
    }
    
    public boolean excluir(Object oModel) {
        this.begin();
        try {
            this.Entity.remove(oModel);
            this.commit();
            return true;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            this.rollback();
            return false;
        }
    }
    
    public void begin() {
        if(!this.Entity.getTransaction().isActive()) {
            this.Entity.getTransaction().begin();
        }
    }
    
    public void commit() {
        if(this.Entity.getTransaction().isActive()) {
            this.Entity.getTransaction().commit();
        }
    }
    
    public void rollback() {
        if(this.Entity.getTransaction().isActive()) {
            this.Entity.getTransaction().rollback();
        }
    }
    
    public Object getFromId(Class classe, int id) {
        Object obj = null;
        try{
            obj = this.Entity.find(classe, id);
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return obj;
    }
}
