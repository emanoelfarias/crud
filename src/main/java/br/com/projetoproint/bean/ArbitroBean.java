package br.com.projetoproint.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.projetoproint.dao.ArbitroDAO;
import br.com.projetoproint.modelo.Arbitro;

@ManagedBean
@SessionScoped
public class ArbitroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	public ArbitroBean() {
		
	}
	
	List<Arbitro> lista=null;
	
	public List<Arbitro> getLista () {
		
		if(lista==null){
		this.lista = new ArbitroDAO().listar();
		}
		return lista;
		
	}
	

}
