package br.com.projetoproint.bean;

import br.com.projetoproint.dao.AdministradorDAO;
import br.com.projetoproint.modelo.Administrador;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;



@ManagedBean
@SessionScoped
public class AdmBean {
	
	private boolean log=false;
	private String nome;
	private String senha;

	public AdmBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public String logar (){
		
		
		Administrador adm = new Administrador();
		adm.setNome(nome);
		adm.setSenha (senha);
		System.out.println("Senha do bean: " + adm.getSenha());
		AdministradorDAO admDAO = new AdministradorDAO();
	
		if (admDAO.procura(adm.getNome(),adm.getSenha())  ==  true){
			//logar usuario e direcionar para pagina de logado
			log = true;
			return "/index.xhtml";
		}
		else 
		{
			// dizer q usuario nao foi encontrado
			log = false;
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro - Dados incorretos!", "Dados incorretos."));
			return null;
		}
		
		
	}
	
	public String verifica() {

		
		if (log == true) {
			return "/index";
		} else {
			return "/autentica";
		}

	}
	
	// sairrrr log outttt
	
	 public String logout() {
	        
		 	System.out.println("em adm logout");
		 	if(log==true)
		 	{
	        this.log = false;
	        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	        
	        FacesMessage msg = new FacesMessage("Efetuado Logout!", "INFO MSG");
	        msg.setSeverity(FacesMessage.SEVERITY_INFO);
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        
		 	}
		 	return "/autentica?faces-redirect=true";
	    }
	
	
	

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean isLog() {
		return log;
	}



	public void setLog(boolean log) {
		this.log = log;
	}

	

}
