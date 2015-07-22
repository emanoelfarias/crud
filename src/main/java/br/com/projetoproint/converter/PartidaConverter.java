package br.com.projetoproint.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.projetoproint.dao.ArbitroDAO;
import br.com.projetoproint.dao.CursoDAO;
import br.com.projetoproint.dao.PartidaDAO;
import br.com.projetoproint.modelo.Arbitro;
import br.com.projetoproint.modelo.Curso;
import br.com.projetoproint.modelo.Partida;



@FacesConverter(forClass=Partida.class)
public class PartidaConverter implements Converter{

	public PartidaConverter() {
		
	}
	
	public String getAsString(FacesContext context, UIComponent component,
			Object object) {
		Partida partida = (Partida) object;
		if (partida == null || partida.getCodPartida()== 0 ) return null;
		
		return String.valueOf(partida.getCodPartida());
		
	}
	
	public Object getAsObject(FacesContext context, UIComponent component,
			String string) {
		
		if (string == null || string.isEmpty()) return null;
		Integer id = Integer.valueOf(string);
		Partida partida = new PartidaDAO().porID(id);
		
		
		return partida;
	}
	
	
	

}
