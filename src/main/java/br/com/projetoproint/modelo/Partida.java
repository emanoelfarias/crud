package br.com.projetoproint.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Partida implements Serializable {

	public Partida() {
	}
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int codPartida;	
	@Temporal(TemporalType.TIMESTAMP)
	private Date datapartida;
	@Temporal(TemporalType.TIME)
	private Date horaInicio;
	@Temporal(TemporalType.TIME)
	private Date horaFim;
	@ManyToOne
	@JoinColumn(name = "cpfArbitro")	
	private Arbitro cpfArbitro;
	// mappedBy EquipePartida
	@OneToMany(mappedBy = "codEquipe" , fetch=FetchType.EAGER)
	private List<EquipePartida> equipes;
	
	
	
	public List<EquipePartida> getEquipes() {
		return equipes;
	}
	public void setEquipes(List<EquipePartida> equipes) {
		this.equipes = equipes;
	}
	public int getCodPartida() {
		return codPartida;
	}
	public void setCodPartida(int codPartida) {
		this.codPartida = codPartida;
	}
	public Date getDatapartida() {
		return datapartida;
	}
	public void setDatapartida(Date datapartida) {
		this.datapartida = datapartida;
	}
	public Date getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}
	public Date getHoraFim() {
		return horaFim;
	}
	public void setHoraFim(Date horaFim) {
		this.horaFim = horaFim;
	}
	public Arbitro getCpfArbitro() {
		return cpfArbitro;
	}
	public void setCpfArbitro(Arbitro cpfArbitro) {
		this.cpfArbitro = cpfArbitro;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Partida other = (Partida) obj;
		if (codPartida != other.codPartida)
			return false;
		return true;
	}
}
