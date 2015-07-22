package br.com.projetoproint.testes;

import br.com.projetoproint.dao.ArbitroDAO;
import br.com.projetoproint.dao.PartidaDAO;
import br.com.projetoproint.modelo.Arbitro;
import br.com.projetoproint.modelo.Partida;

public class ArbitroPorId {

	public ArbitroPorId() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		Arbitro arbitro = new Arbitro();
		Partida partida = new Partida();
		partida = new PartidaDAO().porID(1);
		
		
		System.out.println("NOME ARBITRO:"+partida.getDatapartida());

	}

}
