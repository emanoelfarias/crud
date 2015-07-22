package br.com.projetoproint.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.projetoproint.dao.EquipeDAO;
import br.com.projetoproint.modelo.Curso;
import br.com.projetoproint.modelo.Equipe;
import br.com.projetoproint.modelo.Grupo;
import br.com.projetoproint.modelo.Modalidade;

@ManagedBean
@RequestScoped
public class EquipeBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Equipe> lista;
	private Equipe equipe = new Equipe();
	private Curso curso;
	private Modalidade modalidade;
	private Grupo grupo;
	private EquipeDAO dao = new EquipeDAO();
	private Equipe equipeSelecionada;
	


	// construtor
	public EquipeBean() {}
	
	@PostConstruct
	public void inicia (){
	this.lista = new EquipeDAO().listar();
	}
	
	
   
   public void guardar () {
	   
	    FacesContext context = FacesContext.getCurrentInstance();
		
		try{
		
		equipe.setCodcurso(curso);		
		equipe.setCodModalidade(modalidade);
		equipe.setCodGrupo(grupo);
			
		this.dao.guardar(equipe);
		context.addMessage(null, new FacesMessage("Operação Realizada"));
		}catch(Exception e){
		
		System.out.println(e.getMessage());
		FacesMessage mensagem = new FacesMessage(e.getMessage());
		mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
		context.addMessage(null, mensagem);
			
		}	   
   }

   public void excluir () {
		
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			this.dao.excluir(this.equipeSelecionada);
			this.inicia();
			context.addMessage(null, new FacesMessage("Equipe excluída com sucesso!"));
			
			} catch (Exception e) {
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		
			}
		
	}
   // pojo
   
   
   
   public List<Equipe> getLista () {
		
		return lista;
	}
	
  public Equipe getEquipeSelecionada() {
	return equipeSelecionada;
}

public void setEquipeSelecionada(Equipe equipeSelecionada) {
	this.equipeSelecionada = equipeSelecionada;
}

public void setLista (List<Equipe> lista){
	  
	   this.lista = lista;
  }
   
   public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Modalidade getModalidade() {
		return modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
   
}
