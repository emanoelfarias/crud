package br.com.projetoproint.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.projetoproint.dao.EquipePartidaDAO;
import br.com.projetoproint.modelo.EquipePartida;


@ManagedBean
@SessionScoped
public class EquipePartidaBean implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public EquipePartidaBean() {
		
	}
	
	List<EquipePartida> lista=null;
	
	public List<EquipePartida> getLista () {
		
		if(lista==null){
		this.lista = new EquipePartidaDAO().listar();
		}
		return lista;
		
	}
	
		
   public void setLista (List<EquipePartida> lista){
	  
	   this.lista = lista;
   }
	

}
