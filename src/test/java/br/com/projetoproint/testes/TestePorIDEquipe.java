package br.com.projetoproint.testes;

import br.com.projetoproint.dao.EquipeDAO;

public class TestePorIDEquipe {

	public TestePorIDEquipe() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		System.out.println(new EquipeDAO().porID(1000).getNomeEquipe());

	}

}
