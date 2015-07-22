package br.com.projetoproint.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import br.com.projetoproint.dao.GrupoDAO;
import br.com.projetoproint.modelo.Grupo;


@ManagedBean
@RequestScoped
public class GrupoBean implements Serializable {


	private static final long serialVersionUID = 1L;
	private List<Grupo> lista;

	public GrupoBean() {
		
	}
	
	@PostConstruct
	public void inicia (){
	this.lista = new GrupoDAO().listar();
	}
	
	public List<Grupo> getLista () {	
			
			this.inicia();
			return lista;
	}
	
   public void setLista (List<Grupo> lista){
	  
	   this.lista = lista;
   }
	
	
	

}
