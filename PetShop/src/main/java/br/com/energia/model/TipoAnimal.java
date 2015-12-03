package br.com.energia.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="tipo_animal")
public class TipoAnimal implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_animal")
	private Long idTipoAnimal;
	
	@NotEmpty
	@Column(nullable = false, length = 150)
	private String descricao;
	
	@OneToMany(mappedBy = "tipoAnimal", cascade = CascadeType.ALL)
	private Set<Raca> racas;

	public TipoAnimal(){}

	public Long getIdTipoAnimal() {
		return idTipoAnimal;
	}

	public void setIdTipoAnimal(Long idTipoAnimal) {
		this.idTipoAnimal = idTipoAnimal;
	}

	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<Raca> getRacas() {
		return racas;
	}

	public void setRacas(Set<Raca> racas) {
		this.racas = racas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTipoAnimal == null) ? 0 : idTipoAnimal.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoAnimal other = (TipoAnimal) obj;
		if (idTipoAnimal == null) {
			if (other.idTipoAnimal != null)
				return false;
		} else if (!idTipoAnimal.equals(other.idTipoAnimal))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TipoAnimal [idTipoAnimal=" + idTipoAnimal + ", descricao=" + descricao + ", racas=" + racas + "]";
	}
	
}