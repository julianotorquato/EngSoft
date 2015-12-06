package br.com.energia.util.navegation;


public class Navegation {
    
    public static final String LOGIN = "/login.jsf";
    public static final String LOGIN_REDIRECT = "/login.jsf?faces-redirect=true";
    
    
    public static final String INDEX_REDIRECT = "/index.jsf?faces-redirect=true";
    
    public class Cadastro{
        public static final String CLIENTE_PESQUISA_REDIRECT = "/cliente/pesquisaCliente.jsf?faces-redirect=true";
        
        public static final String CLIENTE_CADASTRO_REDIRECT = "/cliente/cadastroCliente.jsf?faces-redirect=true";
        
        public static final String EMPRESA_REDIRECT = "/gestaoEmpresas.jsf?faces-redirect=true";
    }
}
