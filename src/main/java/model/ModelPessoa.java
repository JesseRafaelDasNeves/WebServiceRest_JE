package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "sequencia_codigo", schema = "unico", sequenceName = "sequencia_pessoa", allocationSize = 1, initialValue = 1)
@Table(name = "pessoa", schema = "unico")
public class ModelPessoa implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequencia_codigo")
    @Column(name = "codigo")
    private int    codigo;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "cpfcnpj")
    private String cpfCnpj;
    
    @Column(name = "tipo")
    private int tipo;

    public ModelPessoa() {
    }

    public ModelPessoa(int codigo, String nome, String cpfCnpj, int tipo) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.tipo = tipo;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
