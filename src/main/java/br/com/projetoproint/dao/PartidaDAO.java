package br.com.projetoproint.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.projetoproint.modelo.Aluno;
import br.com.projetoproint.modelo.Equipe;
import br.com.projetoproint.modelo.Partida;

public class PartidaDAO {
	
	private Session secaoHibernate;
	private List<Partida> lista=null;
	private Partida partida;

	public PartidaDAO() {
		
	}
	
// listar
public List<Partida> listar (){
		
		if(lista == null) {
		secaoHibernate=HibernateUtil.createSessionFactory().openSession();
		secaoHibernate.beginTransaction();
		Query query = secaoHibernate.createQuery("from Partida");		
		this.lista = query.list();
		secaoHibernate.getTransaction().commit();		
		}
		return lista;
		
	}

	public Partida guardar (Partida partida){
	
	Partida partidaRetornada;
	
	secaoHibernate=HibernateUtil.createSessionFactory().openSession();
	secaoHibernate.getTransaction().begin();
	
	partidaRetornada = (Partida) secaoHibernate.merge(partida);
	secaoHibernate.getTransaction().commit();
	secaoHibernate.close();
	return partidaRetornada;
			
	
}
	
	
	
	
	
	public void insere (Partida partida) {
		
		secaoHibernate=HibernateUtil.createSessionFactory().openSession();
		secaoHibernate.getTransaction().begin();
		secaoHibernate.save(partida);
		secaoHibernate.getTransaction().commit();
		secaoHibernate.close();
		
		
	}
	
	
		public Partida porID (int id) {
		
		secaoHibernate=HibernateUtil.createSessionFactory().openSession();
		secaoHibernate.getTransaction().begin();
		partida = (Partida) secaoHibernate.load(Partida.class, id);
		secaoHibernate.getTransaction().commit();
		return partida;
		
	}

}
