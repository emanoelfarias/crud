package br.com.projetoproint.testes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import org.hibernate.Session;

import br.com.projetoproint.dao.HibernateUtil;
import br.com.projetoproint.modelo.Curso;
import br.com.projetoproint.modelo.Equipe;
import br.com.projetoproint.modelo.Partida;

public class TestaManyToMany {

	public TestaManyToMany() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws ParseException {
	
	
	Equipe equipe = new Equipe();
	Partida partida = new Partida();
	Curso curso = new Curso();
	curso.setCodcurso(8000);
	
	equipe.setCodcurso(curso);	
	equipe.setNomeEquipe("INFO2015");
	equipe.setNumParticipente(7);
	equipe.setPontuacao(1);
	equipe.setPosicao(10);
	
	Session secaoHibernate = HibernateUtil.createSessionFactory().openSession();
	//secaoHibernate.beginTransaction();
	//secaoHibernate.persist(arg0);
	
	}

}
