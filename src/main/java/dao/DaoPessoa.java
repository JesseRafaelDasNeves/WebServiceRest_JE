package dao;

import java.util.List;
import javax.persistence.Query;

/**
 * @author jessé
 */
public class DaoPessoa extends Dao {
    
    public List getAll() {
        Query consulta = this.Entity.createQuery("select tabela from ModelPessoa tabela");
        return consulta.getResultList();
    }
}
