package br.com.projetoproint.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "arbitro")
public class Arbitro implements Serializable {
	
	public Arbitro() {
		
	}
	
	
	private static final long serialVersionUID = 1L;
	@Id
	private String cpfArbitro;
	@Column(nullable = false)
	private String nome;
	// mappedby partidas
	@OneToMany(mappedBy="cpfArbitro")
	List<Partida> partidas;
	
	public String getCpfArbitro() {
		return cpfArbitro;
	}
	public void setCpfArbitro(String cpfArbitro) {
		this.cpfArbitro = cpfArbitro;
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
		result = prime * result
				+ ((cpfArbitro == null) ? 0 : cpfArbitro.hashCode());
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
		Arbitro other = (Arbitro) obj;
		if (cpfArbitro == null) {
			if (other.cpfArbitro != null)
				return false;
		} else if (!cpfArbitro.equals(other.cpfArbitro))
			return false;
		return true;
	}
	
	
	

}
