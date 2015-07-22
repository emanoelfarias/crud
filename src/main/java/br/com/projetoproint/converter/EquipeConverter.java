package br.com.projetoproint.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.projetoproint.dao.EquipeDAO;
import br.com.projetoproint.modelo.Equipe;

@FacesConverter(forClass=Equipe.class)
public class EquipeConverter implements Converter {
	
	public EquipeConverter() {
		// TODO Auto-generated constructor stub
	}
	
	public String getAsString(FacesContext context, UIComponent component,
			Object object) {
		Equipe equipe = (Equipe) object;
		if (equipe == null || equipe.getNomeEquipe() == null ) return null;
		return String.valueOf(equipe.getCodEquipe());
	}
	
	public Object getAsObject(FacesContext context, UIComponent component,
			String string) {
		if (string == null || string.isEmpty()) return null;
		Integer id = Integer.valueOf(string);
		Equipe equipe = new EquipeDAO().porID(id);
		return equipe;
	}

}
