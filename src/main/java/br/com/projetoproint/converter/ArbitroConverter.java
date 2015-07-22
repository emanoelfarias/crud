package br.com.projetoproint.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.projetoproint.dao.ArbitroDAO;
import br.com.projetoproint.dao.CursoDAO;
import br.com.projetoproint.modelo.Arbitro;
import br.com.projetoproint.modelo.Curso;



@FacesConverter(forClass=Arbitro.class)
public class ArbitroConverter implements Converter{

	public ArbitroConverter() {
		
	}
	
	public String getAsString(FacesContext context, UIComponent component,
			Object object) {
		Arbitro arbitro = (Arbitro) object;
		if (arbitro == null || arbitro.getCpfArbitro() == null ) return null;
		
		return String.valueOf(arbitro.getCpfArbitro());
		
	}
	
	public Object getAsObject(FacesContext context, UIComponent component,
			String string) {
		
		if (string == null || string.isEmpty()) return null;
		//Integer id = Integer.valueOf(string);
		String id = string;
		Arbitro arbitro = new ArbitroDAO().porID(id);
		
		
		return arbitro;
	}
	
	
	

}
