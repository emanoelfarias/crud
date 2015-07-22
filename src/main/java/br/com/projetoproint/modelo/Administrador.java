package br.com.projetoproint.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "adm")
public class Administrador implements Serializable {
	
	public Administrador() {
		
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int codAdm;
	
	@Column(nullable =  false, length = 45)
	@NotEmpty
	private String nomeAdm;
	@Column(nullable =  false, length = 45)
	@NotEmpty
	private String senhaAdm;
	
	public int getCodAdm (){
		return codAdm;
	}
	
	public String getNome() {
		return nomeAdm;
	}
	
	public void setNome(String nome) {
		this.nomeAdm = nome;
	}
	public String getSenha() {
		return senhaAdm;
	}
	public void setSenha(String senha) {
		this.senhaAdm = senha;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codAdm;
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
		Administrador other = (Administrador) obj;
		if (codAdm != other.codAdm)
			return false;
		return true;
	}
	
	
	

}
