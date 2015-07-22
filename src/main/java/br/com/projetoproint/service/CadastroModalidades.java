package br.com.projetoproint.service;

import java.io.Serializable;

import br.com.projetoproint.modelo.Modalidade;
import br.com.projetoproint.repository.Modalidades;

public class CadastroModalidades implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Modalidades modalidades;

	public CadastroModalidades(Modalidades modalidades) {
		this.modalidades = modalidades;
	}
	
	public void adicionar (Modalidade modalidade) {
		// verificar regras de negocio e lançar excecao caso necessario
		modalidades.adicionar(modalidade);
	}

	
}
