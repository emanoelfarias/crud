package br.com.projetoproint.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "curso")
public class Curso implements Serializable {

	public Curso() {
		
	}	
	
	private static final long serialVersionUID = 1L;
	@Id 
	private int Codcurso;
	@Column(nullable = false)
	private String nome;
	
	// mappedby Alunos
	
	@OneToMany(mappedBy="Codcurso")
	List<Aluno> alunos;
	// mappedby Equipes
	@OneToMany(mappedBy="Codcurso")
	List<Equipe> equipes;
	
	public int getCodcurso() {
		return Codcurso;
	}
	public void setCodcurso(int Codcurso) {
		this.Codcurso = Codcurso;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Codcurso;
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
		Curso other = (Curso) obj;
		if (Codcurso != other.Codcurso)
			return false;
		return true;
	}
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	public List<Equipe> getEquipes() {
		return equipes;
	}
	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}
	
	
}
