package br.com.energia.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;
			
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idEndereco;
	
	@NotEmpty
	@Column(name = "logradouro", nullable = false, length = 80)
	private String logradouro;
	
	@NotEmpty
	@Column(name = "numero", nullable = false, length = 50)
	private String numero;
	
	@NotEmpty
	@Column(name = "complemento", nullable = false, length = 100)
	private String complemento;
	
	@NotEmpty
	@Column(name = "cidade", nullable = false, length = 80)
	private String cidade;
	
	@NotEmpty
	@Column(name = "uf", nullable = false, length = 2)
	private String uf;
	
	@OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
    @PrimaryKeyJoinColumn
	private Pessoa pessoa;

	public Endereco(){

	}

	public Long getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	

}