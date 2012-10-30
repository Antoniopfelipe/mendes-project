package br.com.mendes.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Pedro
 */
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codCliente;
    
    private String nome;
    
    private String sobrenome;
    
    private Long codEndereco;
      
    private String telefone;
    
    private String celular;
    
    private String rg;
    
    private String cpf;
    
    private String cnpj;
    
    private Calendar data_nascimento;
    
    private Calendar data_cadastro;

    public Cliente() {
    }

    public Cliente(Long codCliente, String nome, String sobrenome, Long codEndereco, String telefone, String celular, String rg, String cpf, String cnpj, Calendar data_nascimento, Calendar data_cadastro) {
        this.codCliente = codCliente;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.codEndereco = codEndereco;
        this.telefone = telefone;
        this.celular = celular;
        this.rg = rg;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.data_nascimento = data_nascimento;
        this.data_cadastro = data_cadastro;
    }
    
    public Cliente(Long codCliente, String nome, String sobrenome) {
       
    	this.codCliente = codCliente;
        this.nome = nome;
        this.sobrenome = sobrenome;
      
    }

    public Long getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Long codCliente) {
        this.codCliente = codCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Long getCodEndereco() {
        return codEndereco;
    }

    public void setCodEndereco(Long codEndereco) {
        this.codEndereco = codEndereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Calendar getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Calendar data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public Calendar getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(Calendar data_cadastro) {
        this.data_cadastro = data_cadastro;
    }
}

