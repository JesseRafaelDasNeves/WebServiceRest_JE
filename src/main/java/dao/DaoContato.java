package dao;

import java.util.List;
import javax.persistence.Query;

/**
 * @author jessé
 */
public class DaoContato extends Dao {
    
    public List getAll() {
        Query consulta = this.Entity.createQuery("SELECT contato FROM ModelContato contato ORDER BY contato.Pessoa.codigo");
        return consulta.getResultList();
    }
}
