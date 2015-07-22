package br.com.projetoproint.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.projetoproint.dao.EquipeDAO;
import br.com.projetoproint.modelo.Equipe;
import br.com.projetoproint.modelo.Modalidade;

@ManagedBean
@SessionScoped
public class RankView implements Serializable {

	private static final long serialVersionUID = 1L;
	private Equipe equipe;
	private List<Equipe> lista;
	private Modalidade modalidadeSelecionada;
	
	@PostConstruct
	public void incia (){
		
	}
	
	public RankView() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String prepara () {
		
		this.lista = new EquipeDAO().ListaPorModalidade(modalidadeSelecionada);
		return "/listaRanking?faces-redirect=true";
		
		
	}
	
	
	
	
	

	public Modalidade getModalidadeSelecionada() {
		return modalidadeSelecionada;
	}

	public void setModalidadeSelecionada(Modalidade modalidadeSelecionada) {
		this.modalidadeSelecionada = modalidadeSelecionada;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public List<Equipe> getLista() {
		return lista;
	}

	public void setLista(List<Equipe> lista) {
		this.lista = lista;
	}
	
	

}
