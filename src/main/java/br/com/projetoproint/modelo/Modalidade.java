/**
 * 
 */
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

import org.hibernate.annotations.RowId;

/**
 * @author emanoel
 *
 */
@Entity
@Table(name = "modalidade")
public class Modalidade implements Serializable {

	public Modalidade() {
	}
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int codModalidade;
	@Column(unique = true)
	private String tipo;
	
	// mappedby Aluno
	@OneToMany(mappedBy="codModalidade")
	List<Aluno> alunos;
	// mappedby Equipes
	@OneToMany(mappedBy= "codModalidade" , fetch=FetchType.EAGER)
	List<Equipe> equipes;
	
	public int getCodModalidade() {
		return codModalidade;
	}
	public void setCodModalidade(int codModalidade) {
		this.codModalidade = codModalidade;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
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
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codModalidade;
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
		Modalidade other = (Modalidade) obj;
		if (codModalidade != other.codModalidade)
			return false;
		return true;
	}
	
}
