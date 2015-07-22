package br.com.projetoproint.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.projetoproint.modelo.Aluno;
import br.com.projetoproint.modelo.Arbitro;


public class ArbitroDAO {

	public ArbitroDAO() {
		
	}

	private Session secaoHibernate;
	private List<Arbitro> lista=null;
	private Arbitro arbitro = new Arbitro();

	public List<Arbitro> listar (){
		
		if(lista == null) {
		secaoHibernate=HibernateUtil.createSessionFactory().openSession();
		secaoHibernate.beginTransaction();
		Query query = secaoHibernate.createQuery("from Arbitro");		
		this.lista = query.list();
		secaoHibernate.getTransaction().commit();
		
		}
		return lista;
}

	public Arbitro porID(String id) {
		secaoHibernate=HibernateUtil.createSessionFactory().openSession();
		secaoHibernate.getTransaction().begin();
		arbitro = (Arbitro) secaoHibernate.load(Arbitro.class, id);
		secaoHibernate.getTransaction().commit();
		return arbitro;
	}
}