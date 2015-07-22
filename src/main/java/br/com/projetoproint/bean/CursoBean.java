package br.com.projetoproint.bean;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import br.com.projetoproint.dao.CursoDAO;
import br.com.projetoproint.modelo.Curso;


@ManagedBean
@SessionScoped
public class CursoBean implements Serializable {


	private static final long serialVersionUID = 1L;
	private List<Curso> lista;

	public CursoBean() {
		
	}
	
	//inserir
	// listar
	
	public List<Curso> getLista () {
		
		
		this.lista = new CursoDAO().listar();
		return lista;
	}
	
   public void setLista (List<Curso> lista){
	  
	   this.lista = lista;
   }
	
	
	

}
