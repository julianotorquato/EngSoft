package br.com.energia.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Animal implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAnimal;
	
	@NotEmpty
	@Column(name = "nome", nullable = false, length = 100)
	private String nome;
	
	@NotNull
	@Past
	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento")
	private Calendar dataNascimento;
	
	@NotEmpty
	@Column(name = "sexo", nullable = false)
	private char sexo;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="HISTORICO_IDHISTORICO")
	private List<Historico> historicoAnimal;
	
	@NotEmpty
	@ManyToOne(cascade=CascadeType.ALL)
	private TipoAnimal tipoAnimal;
	
	@NotEmpty
	@ManyToOne(cascade=CascadeType.ALL)
	private Raca raca;
	
	@NotEmpty
	@ManyToOne(cascade=CascadeType.ALL)
	private Pessoa dono;

	public Animal(){

	}

	public Long getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(Long idAnimal) {
		this.idAnimal = idAnimal;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public List<Historico> getHistoricoAnimal() {
		return historicoAnimal;
	}

	public void setHistoricoAnimal(List<Historico> historicoAnimal) {
		this.historicoAnimal = historicoAnimal;
	}

	public TipoAnimal getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(TipoAnimal tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

	public Raca getRaca() {
		return raca;
	}

	public void setRaca(Raca raca) {
		this.raca = raca;
	}

	public Pessoa getDono() {
		return dono;
	}

	public void setDono(Pessoa dono) {
		this.dono = dono;
	}
	
}