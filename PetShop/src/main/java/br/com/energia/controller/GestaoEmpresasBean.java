package br.com.energia.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.energia.model.Empresa;
import br.com.energia.model.TipoEmpresa;
import br.com.energia.repository.EmpresaRepository;
import br.com.energia.service.EmpresaService;
import br.com.energia.util.jsf.UtilFaces;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EmpresaRepository empresas;
	
	@Inject
	private EmpresaService cadastroEmpresa;
	
	/*@Inject
	private FacesMessages messages;*/
	
	private List<Empresa> todasEmpresas;
	private Empresa empresaEdicao = new Empresa();
	private Empresa empresaSelecionada;
	private Boolean isEdicao = false;
	
	public void prepararNovoCadastro() {
		empresaEdicao = new Empresa();
	}
	
	public void salvar() {
		cadastroEmpresa.salvar(isEdicao, empresaEdicao);
		consultar();
		
		if (isEdicao) {
			UtilFaces.addInfoMessage("Empresa editada com sucesso!");
		}else{
			UtilFaces.addInfoMessage("Empresa salva com sucesso!");
		}
		
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:msgs", "frm:empresas-table"));
	}
	
	public void excluir() {
		cadastroEmpresa.excluir(empresaSelecionada);
		empresaSelecionada = null;
		
		consultar();
		
		UtilFaces.addInfoMessage("Empresa excluída com sucesso!");
	}
	
	public void carregarEdicao(){
		isEdicao = Boolean.TRUE;
	}
	
	public void consultar() {
		todasEmpresas = empresas.getTodos();
	}

	public List<Empresa> getTodasEmpresas() {
		return todasEmpresas;
	}
	
	public TipoEmpresa[] getTiposEmpresas() {
		return TipoEmpresa.values();
	}

	public Empresa getEmpresaEdicao() {
		return empresaEdicao;
	}

	public void setEmpresaEdicao(Empresa empresaEdicao) {
		this.empresaEdicao = empresaEdicao;
	}

	public Empresa getEmpresaSelecionada() {
		return empresaSelecionada;
	}

	public void setEmpresaSelecionada(Empresa empresaSelecionada) {
		this.empresaSelecionada = empresaSelecionada;
	}

}