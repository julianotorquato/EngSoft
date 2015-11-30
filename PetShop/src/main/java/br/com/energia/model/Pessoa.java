package br.com.energia.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPessoa;
	
	@NotEmpty
	@Column(name = "login", nullable = false, length = 80)
	private String login;
	
	@NotEmpty
	@Column(name = "senha", nullable = false, length = 120)
	private String senha;
	
	@NotEmpty
	@Column(name = "nr_rg", nullable = false, length = 80)
	private String nrRg;
	
	@NotEmpty
	@Column(name = "cpf",nullable = false, length = 18)
	private String cpf;
	
	@NotEmpty
	@Column(name="endereco",nullable = false, length = 18)
    @OneToOne(mappedBy = "pessoa")
	private Endereco endereco;
	
	
	@NotNull
	@Past
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_cadastro")
	private Date dtCadastro;

	
	
	public long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNrRg() {
		return nrRg;
	}

	public void setNrRg(String nrRg) {
		this.nrRg = nrRg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

}