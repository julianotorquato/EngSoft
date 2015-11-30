package br.com.energia.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.energia.util.navegation.Navegation;

@Named
@SessionScoped
public class LoginController implements Serializable{
    
    private static final String USUARIO = "aluno";
    private static final String SENHA = "123";
    
//	@Inject
//	private UsuarioController usuario;
	
	private String nomeUsuario;
	private String senha;

	public String login() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		if (USUARIO.equals(this.nomeUsuario) && SENHA.equals(this.senha)) {
//			this.usuario.setNome(this.nomeUsuario);
//			this.usuario.setDataLogin(new Date());
			return Navegation.INDEX_REDIRECT;
		} else {
			FacesMessage mensagem = new FacesMessage("Usuário/Senha inválidos!");
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
		
		return null;
	}
	
	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return Navegation.LOGIN_REDIRECT;
	}
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean isLogado() {
		return nomeUsuario != null;
	}

}