package br.com.energia.controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import br.com.energia.util.navegation.Navegation;

@Named
@ViewScoped
public class MenuController implements Serializable{
    
	private static final long serialVersionUID = 1L;

	public String chamarEmpresa(){
        return Navegation.Cadastro.EMPRESA_REDIRECT;
    }
    
    public String chamarClientePesquisa(){
        return Navegation.Cadastro.CLIENTE_PESQUISA_REDIRECT;
    }
    
    public String chamarClienteCadastro(){
    	return Navegation.Cadastro.CLIENTE_CADASTRO_REDIRECT;
    }
}
