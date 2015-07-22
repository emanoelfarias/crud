package br.com.projetoproint.testes;

import br.com.projetoproint.dao.ModalidadeDAO;
import br.com.projetoproint.modelo.Modalidade;

public class TesteDeletaModalidade {

	public TesteDeletaModalidade() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Modalidade modalidade = new Modalidade();
		modalidade.setCodModalidade(308);
		
		ModalidadeDAO dao = new ModalidadeDAO();
		dao.excluir(modalidade);

	}
	
	
	

}
