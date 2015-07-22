package br.com.projetoproint.dao;
import java.util.List;

import br.com.projetoproint.modelo.*;

public class IterarModalidadeDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Modalidade> lista = new ModalidadeDAO().Lista();
		
		Modalidade modalidade = new Modalidade();
		modalidade.setTipo("CORRIDA 2KM MASCULINA");
		
		new ModalidadeDAO().guardar(modalidade);
		
		System.out.println(lista.size());
		
		for(int i = 0 ; i < lista.size(); i++)
		{ 
			System.out.println("\n---------------------------------------");
			System.out.println("Codigo:"+lista.get(i).getCodModalidade());
			System.out.println("\nTipo:"+lista.get(i).getTipo());
		
		}
		
		

		
		
	}

}
