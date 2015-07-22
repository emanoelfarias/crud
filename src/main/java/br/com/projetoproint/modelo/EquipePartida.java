package br.com.projetoproint.modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(EquipePartidaID.class)
@Table(name="equipepartidarealiza")
public class EquipePartida implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne
	@JoinColumn(name="codPartida")
	private Partida codPartida;	
	@Id
	@ManyToOne
	@JoinColumn(name="codEquipe")
	private Equipe codEquipe;
	
	private int resultadoEquipe;
	
	
	public Partida getCodPartida() {
		return codPartida;
	}

	public void setCodPartida(Partida codPartida) {
		this.codPartida = codPartida;
	}

	
	public Equipe getCodEquipe() {
		return codEquipe;
	}

	public void setCodEquipe(Equipe codEquipe) {
		this.codEquipe = codEquipe;
	}

	
		
	public EquipePartida() {
		
	}

	public int getResultadoEquipe() {
		return resultadoEquipe;
	}

	public void setResultadoEquipe(int resultadoEquipe) {
		this.resultadoEquipe = resultadoEquipe;
	}

}
