package br.com.projetoproint.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.projetoproint.modelo.Aluno;
import br.com.projetoproint.modelo.Curso;
import br.com.projetoproint.modelo.Equipe;

public class AlunoDAO {

	public AlunoDAO() {
		
	}

	private Session secaoHibernate;
	private List<Aluno> lista=null;
	private Aluno aluno;

	
	public List<Aluno> listar (){
		
		
		secaoHibernate=HibernateUtil.createSessionFactory().openSession();
		secaoHibernate.getTransaction().begin();
		Query query = secaoHibernate.createQuery("from Aluno");		
		this.lista = query.list();
		secaoHibernate.getTransaction().commit();
		secaoHibernate.close();
		return lista;
		}
	
	public void inserir (Aluno aluno){
		if(lista==null){
		secaoHibernate=HibernateUtil.createSessionFactory().openSession();
		secaoHibernate.persist(aluno);			
		
		}
		
		
	}
	
	public void excluir (Aluno aluno){
		
		secaoHibernate=HibernateUtil.createSessionFactory().openSession();
		secaoHibernate.getTransaction().begin();
		secaoHibernate.delete(aluno);	
		secaoHibernate.getTransaction().commit();
		secaoHibernate.close();
	}
	
	public Aluno porID (int id) {
		
		secaoHibernate=HibernateUtil.createSessionFactory().openSession();
		secaoHibernate.getTransaction().begin();
		aluno = (Aluno) secaoHibernate.load(Aluno.class, id);
		secaoHibernate.getTransaction().commit();
		secaoHibernate.close();
		return aluno;
		
	}
	
	public void guardar (Aluno aluno){
		
				
		secaoHibernate=HibernateUtil.createSessionFactory().openSession();
		secaoHibernate.getTransaction().begin();
		secaoHibernate.merge(aluno);
		secaoHibernate.getTransaction().commit();
		secaoHibernate.close();
	
				
		
	}

	
	
}