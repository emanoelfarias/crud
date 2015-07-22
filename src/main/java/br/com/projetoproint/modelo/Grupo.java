package br.com.projetoproint.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="grupo")
public class Grupo implements Serializable{

	public Grupo() {
	}
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int codGrupo;
	@Column(nullable = false)
	private char tipoGrupo;
	// mappedby Equipes
	@OneToMany(mappedBy="codGrupo", fetch=FetchType.EAGER)
	private List<Equipe> equipes;

	
	
	public List<Equipe> getEquipes() {
		return equipes;
	}
	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}
	public int getCodGrupo() {
		return codGrupo;
	}
	public void setCodGrupo(int codGrupo) {
		this.codGrupo = codGrupo;
	}


	
	public char getTipoGrupo() {
		return tipoGrupo;
	}
	public void setTipoGrupo(char tipoGrupo) {
		this.tipoGrupo = tipoGrupo;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codGrupo;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		if (codGrupo != other.codGrupo)
			return false;
		return true;
	}
		

}
