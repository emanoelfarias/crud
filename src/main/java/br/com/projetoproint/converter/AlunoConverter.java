package br.com.projetoproint.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.projetoproint.dao.AlunoDAO;
import br.com.projetoproint.modelo.Aluno;



@FacesConverter(forClass=Aluno.class)
public class AlunoConverter implements Converter{

	public AlunoConverter() {
		
	}
	
	public String getAsString(FacesContext context, UIComponent component,
			Object object) {
		Aluno aluno = (Aluno) object;
		if (aluno == null || aluno.getNome() == null ) return null;
		return String.valueOf(aluno.getCodAluno());
	}
	
	public Object getAsObject(FacesContext context, UIComponent component,
			String string) {
		if (string == null || string.isEmpty()) return null;
		Integer id = Integer.valueOf(string);
		Aluno aluno = new AlunoDAO().porID(id);
		System.out.println("-----ALUNO="+aluno.getNome());
		return aluno;
	}
	
	

}
