package br.com.energia.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="historico")
public class Historico implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_historico")
	private Long idHistorico;
	
	@NotNull
	@Past
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_registro")
	private Date dtRegistro;
	
	@NotEmpty
	@Column(nullable = false, length = 300)
	private String observacao;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="tipo_procedimento")
	private TipoProcedimento tipoProcedimento;
	
	@NotEmpty
	@ManyToOne
	@JoinColumn(name="id_animal")
	private Animal animal;
	
	@NotNull
	@Column(name="id_funcionario", nullable = false)
	//@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;
	
	public Historico(){
	}

	public Long getIdHistorico() {
		return idHistorico;
	}

	public void setIdHistorico(Long idHistorico) {
		this.idHistorico = idHistorico;
	}

	public Date getDtRegistro() {
		return dtRegistro;
	}

	public void setDtRegistro(Date dtRegistro) {
		this.dtRegistro = dtRegistro;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public TipoProcedimento getTipoProcedimento() {
		return tipoProcedimento;
	}

	public void setTipoProcedimento(TipoProcedimento tipoProcedimento) {
		this.tipoProcedimento = tipoProcedimento;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	

}