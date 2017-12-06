package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author jessé
 */
@Entity
@Table(name = "tbcliente", schema = "unico")
public class ModelCliente implements Serializable {

    @Column(name = "clidiafaturamento")
    private int diaFaturamento;

    @Id
    @OneToOne
    @JoinColumn(name = "pescodigo", referencedColumnName = "codigo")
    private ModelPessoa Pessoa;

    public int getDiaFaturamento() {
        return diaFaturamento;
    }

    public void setDiaFaturamento(int diaFaturamento) {
        this.diaFaturamento = diaFaturamento;
    }
    
    public ModelPessoa getPessoa() {
        if(this.Pessoa == null) {
            this.Pessoa = new ModelPessoa();
        }
        return Pessoa;
    }

    public void setPessoa(ModelPessoa Pessoa) {
        this.Pessoa = Pessoa;
    }
}
