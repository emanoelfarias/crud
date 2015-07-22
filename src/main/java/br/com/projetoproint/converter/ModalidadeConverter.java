package br.com.projetoproint.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.projetoproint.dao.CursoDAO;
import br.com.projetoproint.dao.EquipeDAO;
import br.com.projetoproint.dao.ModalidadeDAO;
import br.com.projetoproint.modelo.Curso;
import br.com.projetoproint.modelo.Equipe;
import br.com.projetoproint.modelo.Modalidade;


@FacesConverter(forClass=Modalidade.class)
public class ModalidadeConverter implements Converter{

	public ModalidadeConverter() {
		
	}
	
	public String getAsString(FacesContext context, UIComponent component,
			Object object) {
		Modalidade modalidade = (Modalidade) object;
		if (modalidade == null || modalidade.getTipo() == null ) return null;
		return String.valueOf(modalidade.getCodModalidade());
	}
	
	public Object getAsObject(FacesContext context, UIComponent component,
			String string) {
		if (string == null || string.isEmpty()) return null;
		Integer id = Integer.valueOf(string);
		Modalidade modalidade = new ModalidadeDAO().porID(id);
		System.out.println("------MODALIDADE="+modalidade.getTipo());
		return modalidade;
	}
	
	

}
