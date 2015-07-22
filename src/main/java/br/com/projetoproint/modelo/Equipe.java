package br.com.projetoproint.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "equipe")
public class Equipe implements Serializable {

	public Equipe() {
		
	}
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int codEquipe;
	private String nomeEquipe;
	private int numParticipante;
	@Column(nullable=true)
	private int pontuacao;
	private int vitorias;
	private int saldo;
	private int posicao;
	private int empates;
	@ManyToOne
	@JoinColumn(name = "Codcurso")	
	private Curso Codcurso;
	@ManyToOne
	@JoinColumn(name = "codModalidade")	
	private Modalidade codModalidade;
	@ManyToOne
	@JoinColumn(name = "codGrupo")	
	private Grupo  codGrupo;
	
	
	// mappedby Aluno
	@OneToMany(mappedBy="codEquipe")
	private List<Aluno> alunos;
	
	// mappedby EquipePartida
	@OneToMany(mappedBy="codPartida")
	private List<EquipePartida> partidas;
	
	
	
	
	public int getEmpates() {
		return empates;
	}
	public void setEmpates(int empates) {
		this.empates = empates;
	}
	public int getVitorias() {
		return vitorias;
	}
	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}
	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	public String getNomeEquipe() {
		return nomeEquipe;
	}
	public void setNomeEquipe(String nomeEquipe) {
		this.nomeEquipe = nomeEquipe;
	}
	public int getNumParticipente() {
		return numParticipante;
	}
	public void setNumParticipente(int numParticipente) {
		this.numParticipante = numParticipente;
	}
	public int getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	public int getPosicao() {
		return posicao;
	}
	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
	public Curso getCodcurso() {
		return Codcurso;
	}
	public void setCodcurso(Curso codcurso) {
		Codcurso = codcurso;
	}
	public Modalidade getCodModalidade() {
		return codModalidade;
	}
	public void setCodModalidade(Modalidade codModalidade) {
		this.codModalidade = codModalidade;
	}
	public Grupo getCodGrupo() {
		return codGrupo;
	}
	public void setCodGrupo(Grupo codGrupo) {
		this.codGrupo = codGrupo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codEquipe;
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
		Equipe other = (Equipe) obj;
		if (codEquipe != other.codEquipe)
			return false;
		return true;
	}
	public int getCodEquipe() {
		return codEquipe;
	}
	public void setCodEquipe(int codEquipe) {
		this.codEquipe = codEquipe;
	}
	public int getNumParticipante() {
		return numParticipante;
	}
	public void setNumParticipante(int numParticipante) {
		this.numParticipante = numParticipante;
	}
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	public List<EquipePartida> getPartidas() {
		return partidas;
	}
	public void setPartidas(List<EquipePartida> partidas) {
		this.partidas = partidas;
	}
	
	
	

}
