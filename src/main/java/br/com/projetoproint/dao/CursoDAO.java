package br.com.projetoproint.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.projetoproint.modelo.Arbitro;
import br.com.projetoproint.modelo.Curso;
import br.com.projetoproint.modelo.Equipe;

public class CursoDAO {
	
	Session secaoHibernate;
	List<Curso> lista=null;

	public CursoDAO() {
		
	}
	
	public Curso porID (int id) {
		
		secaoHibernate=HibernateUtil.createSessionFactory().openSession();
		secaoHibernate.beginTransaction();
		return (Curso) secaoHibernate.load(Curso.class, id);
		
	}
	
	public List<Curso> listar (){
		
		if(lista == null) {
		secaoHibernate=HibernateUtil.createSessionFactory().openSession();
		secaoHibernate.beginTransaction();
		Query query = secaoHibernate.createQuery("from Curso");		
		this.lista = query.list();
		secaoHibernate.getTransaction().commit();
		
		}
		return lista;
}

}
