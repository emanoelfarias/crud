package br.com.projetoproint.testes;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Automovel {

	public Automovel() {
		// TODO Auto-generated constructor stub
	}
	@Id
	private String placa;
	private String modelo;
	
		
	public String getModelo() {
	return modelo;
	
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
}
