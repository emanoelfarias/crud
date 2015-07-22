package br.com.projetoproint.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "aluno")
public class Aluno implements Serializable {
	
	public Aluno() {
		
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int codAluno;
	@Column(nullable =  false  )
	@NotEmpty

	private String nome;
	@Column(nullable =  false)
	@NotEmpty
	private String matricula;
	
	private char sexo;
	@Column(nullable =  false)
	private float peso;
	@Column(nullable =  false)
	private float altura;
	@ManyToOne
	@JoinColumn(name = "codEquipe")
	private Equipe codEquipe;
	@ManyToOne
	@JoinColumn(name = "codModalidade")
	private Modalidade codModalidade;
	@ManyToOne
	@JoinColumn ( name = "Codcurso")
	private Curso Codcurso;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public Modalidade getCodModalidade() {
		return codModalidade;
	}
	public void setCodModalidade(Modalidade codModalidade) {
		this.codModalidade = codModalidade;
	}
	public Equipe getCodEquipe() {
		return codEquipe;
	}
	public void setCodEquipe(Equipe codEquipe) {
		this.codEquipe = codEquipe;
	}
	public Curso getCodCurso() {
		return Codcurso;
	}
	public void setCodCurso(Curso Codcurso) {
		this.Codcurso = Codcurso;
	}
	
	public int getCodAluno() {
		return codAluno;
	}
	public void setCodAluno(int codAluno) {
		this.codAluno = codAluno;
	}
	
	// comparacao
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codAluno;
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
		Aluno other = (Aluno) obj;
		if (codAluno != other.codAluno)
			return false;
		return true;
	}
	public Curso getCodcurso() {
		return Codcurso;
	}
	public void setCodcurso(Curso codcurso) {
		Codcurso = codcurso;
	}
	
	
	
	
	
	
}
