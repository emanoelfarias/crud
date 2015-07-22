package br.com.projetoproint.bean;
import java.util.List;

import br.com.projetoproint.dao.ModalidadeDAO;
import br.com.projetoproint.modelo.Modalidade;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@RequestScoped
public class ModalidadeBean {
	
	
	private ModalidadeDAO modalidadeDAO = new ModalidadeDAO();
	private List<Modalidade> lista = null;
	private Modalidade modalidade = new Modalidade();
	private Modalidade modalidadeSelecionada;
	 
	public ModalidadeBean() {
		
	}
	
	
	public void prepara () {
		
		lista = modalidadeDAO.Lista();
	}
	
	

	
	public void  guardar () {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		try{
		this.modalidadeDAO.guardar(modalidade);
		context.addMessage(null, new FacesMessage("Operação Realizada"));
		}catch(Exception e){
			
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
			
		}
	}
	
	// excluir
		public void excluir () {
			
			FacesContext context = FacesContext.getCurrentInstance();
			
			try {
				modalidadeDAO.excluir(modalidadeSelecionada);
				this.prepara();
				context.addMessage(null, new FacesMessage("Modalidade excluída com sucesso!"));
								
				} catch (Exception e) {
				FacesMessage mensagem = new FacesMessage(e.getMessage());
				mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
				context.addMessage(null, mensagem);
				
				}
			
		}
	
	
	
	// setters e getters
	
	
	
	public void setLista(List<Modalidade> lista) {
		this.lista = lista;
	}


	public Modalidade getModalidadeSelecionada() {
		return modalidadeSelecionada;
	}


	public void setModalidadeSelecionada(Modalidade modalidadeSelecionada) {
		this.modalidadeSelecionada = modalidadeSelecionada;
	}


	public List<Modalidade> getLista() {
		
		if(lista == null){
		this.lista = modalidadeDAO.Lista();
		}
		return lista;
		
	}
	
	public Modalidade getModalidade() {
		return modalidade;
	}


	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}
	
	
	

}
