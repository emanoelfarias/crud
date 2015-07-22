package br.com.projetoproint.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.com.projetoproint.dao.GrupoDAO;
import br.com.projetoproint.modelo.Grupo;


@FacesConverter(forClass=Grupo.class)
public class GrupoConverter implements Converter{

	public GrupoConverter() {
		
	}
	
	public String getAsString(FacesContext context, UIComponent component,
			Object object) {
		Grupo grupo = (Grupo) object;
		if (grupo == null ||grupo.getTipoGrupo() == ' ' ) return null;
		
		return String.valueOf(grupo.getCodGrupo());
		
	}
	
	public Object getAsObject(FacesContext context, UIComponent component,
			String string) {
	
		if (string == null || string.isEmpty()) return null;
		Integer id = Integer.valueOf(string);
		Grupo grupo = new GrupoDAO().porID(id);
		
		
		return grupo;
	}
	
	
	

}
