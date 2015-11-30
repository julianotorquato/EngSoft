package br.com.energia.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_empresa")
public class TipoEmpresaBean implements Serializable{
	
	private Long idTipoEmpresa;
	
	private String descricao;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_empresa")
	public Long getIdTipoEmpresa() {
		return idTipoEmpresa;
	}

	public void setIdTipoEmpresa(Long idTipoEmpresa) {
		this.idTipoEmpresa = idTipoEmpresa;
	}
	
	@Column(nullable=false)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTipoEmpresa == null) ? 0 : idTipoEmpresa.hashCode());
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
		TipoEmpresaBean other = (TipoEmpresaBean) obj;
		if (idTipoEmpresa == null) {
			if (other.idTipoEmpresa != null)
				return false;
		} else if (!idTipoEmpresa.equals(other.idTipoEmpresa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TipoEmpresaBean [idTipoEmpresa=" + idTipoEmpresa + ", descricao=" + descricao + "]";
	}
	
}
