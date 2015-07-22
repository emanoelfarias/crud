package br.com.projetoproint.modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


public class EquipePartidaID implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int codPartida;	
	private int codEquipe;
	
	// construtor vazio
	
	public EquipePartidaID() {
		
	}
	
	// getters e setters
	
	public int getCodPartida() {
		return codPartida;
	}
	
	public void setCodPartida(int codPartida) {
		this.codPartida = codPartida;
	}

	public int getCodEquipe() {
		return codEquipe;
	}

	public void setCodEquipe(int codEquipe) {
		this.codEquipe = codEquipe;
	}

	// override de hasgcode e equals
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codEquipe;
		result = prime * result + codPartida;
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
		EquipePartidaID other = (EquipePartidaID) obj;
		if (codEquipe != other.codEquipe)
			return false;
		if (codPartida != other.codPartida)
			return false;
		return true;
	}
	
	

	
	
	
}
