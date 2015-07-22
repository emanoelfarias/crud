package br.com.projetoproint.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.com.projetoproint.dao.CursoDAO;
import br.com.projetoproint.modelo.Curso;



@FacesConverter(forClass=Curso.class)
public class CursoConverter implements Converter{

	public CursoConverter() {
		
	}
	
	public String getAsString(FacesContext context, UIComponent component,
			Object object) {
		Curso curso = (Curso) object;
		if (curso == null || curso.getNome() == null ) return null;
		
		return String.valueOf(curso.getCodcurso());
		
	}
	
	public Object getAsObject(FacesContext context, UIComponent component,
			String string) {
		
		if (string == null || string.isEmpty()) return null;
		Integer id = Integer.valueOf(string);
		Curso curso = new CursoDAO().porID(id);
		
		
		return curso;
	}
	
	
	

}
