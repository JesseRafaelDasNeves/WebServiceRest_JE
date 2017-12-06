package dao;

import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author jessé
 */
public class DaoCliente extends Dao {
    
    public List getAll() {
        Query consulta = this.Entity.createQuery("SELECT cliente FROM ModelCliente cliente ORDER BY cliente.Pessoa.codigo");
        return consulta.getResultList();
    }
}
