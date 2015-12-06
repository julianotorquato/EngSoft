package br.com.energia.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.energia.model.Endereco;
import br.com.energia.model.Pessoa;
import br.com.energia.repository.PessoaRepository;
import br.com.energia.repository.filter.PessoaFilter;
import br.com.energia.service.PessoaService;
import br.com.energia.util.jsf.UtilFaces;

@Named
@ViewScoped
public class ClienteController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PessoaRepository pessoaRepository;
	
	@Inject
	private PessoaService pessoaService;
	
	private PessoaFilter clienteFiltro;
	private List<Pessoa> clientesFiltrados;
	private Pessoa cliente;
	private Pessoa clienteSelecionado;
	private Boolean isEdicao = false;

	public ClienteController(){
			limpar();
	}
	
	private void limpar(){
		clienteFiltro = new PessoaFilter();
		cliente = new Pessoa();
		cliente.setEndereco(new Endereco());
	}
	
	public void inicializar(){
		if (UtilFaces.isNotPostback()) {
			limpar();
		}
	}
	
	public void salvar() {
		
		try {
			pessoaService.salvar(isEdicao, cliente);
			
			if (isEdicao) {
				UtilFaces.addInfoMessage("Cliente editada com sucesso!");
			}else{
				UtilFaces.addInfoMessage("Cliente salva com sucesso!");
			}
			
			limpar();
			
			RequestContext.getCurrentInstance().update(
					Arrays.asList("frm:msgs", "frm:clientes-table"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void pesquisar() {
		clientesFiltrados = pessoaRepository.filtrados(clienteFiltro);
	}
	
	public void excluir() {
		pessoaService.excluir(clienteSelecionado);
		limpar();
		pesquisar();
		
		
		
		UtilFaces.addInfoMessage("Cliente excluída com sucesso!");
	}
	
	public void carregarEdicao(){
		isEdicao = Boolean.TRUE;
	}

	public Pessoa getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Pessoa clienteSelecionada) {
		this.clienteSelecionado = clienteSelecionada;
	}

	public Boolean getIsEdicao() {
		return isEdicao;
	}

	public void setIsEdicao(Boolean isEdicao) {
		this.isEdicao = isEdicao;
	}

	public List<Pessoa> getClientesFiltrados() {
		return clientesFiltrados;
	}

	public PessoaFilter getClienteFiltro() {
		return clienteFiltro;
	}
	
	public Pessoa getCliente() {
		return cliente;
	}
	
	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}
	
	public boolean isEditando() {
		return this.cliente.getIdPessoa() != null;
	}

}