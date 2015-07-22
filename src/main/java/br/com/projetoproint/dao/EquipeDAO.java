package br.com.projetoproint.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.projetoproint.modelo.Aluno;
import br.com.projetoproint.modelo.Equipe;
import br.com.projetoproint.modelo.Modalidade;

public class EquipeDAO {
	
	Session secaoHibernate;
	List<Equipe> lista=null;

	public EquipeDAO() {
		
	}
	
	public List<Equipe> listar (){
		
		if(lista == null) {
		secaoHibernate=HibernateUtil.createSessionFactory().openSession();
		secaoHibernate.beginTransaction();
		Query query = secaoHibernate.createQuery("from Equipe");		
		this.lista = query.list();
		secaoHibernate.getTransaction().commit();
		secaoHibernate.close();
		}
		return lista;
		
	}
	
	public Equipe porID (int id){
		
		secaoHibernate=HibernateUtil.createSessionFactory().openSession();
		secaoHibernate.beginTransaction();
		Equipe equipe = (Equipe) secaoHibernate.load(Equipe.class, id);
		System.out.println("----------"+equipe.getNomeEquipe());
		return equipe;
	}
	
	
	
	public void guardar (Equipe equipe){
		
		
		secaoHibernate=HibernateUtil.createSessionFactory().openSession();
		secaoHibernate.getTransaction().begin();
		secaoHibernate.merge(equipe);
		secaoHibernate.getTransaction().commit();
		secaoHibernate.close();
	
				
		
	}
	
	public void pontuar (Equipe equipe) {
		
		equipe.setPontuacao(equipe.getPontuacao()+1);
		
		secaoHibernate=HibernateUtil.createSessionFactory().openSession();
		secaoHibernate.getTransaction().begin();
		secaoHibernate.merge(equipe);
		secaoHibernate.getTransaction().commit();
		secaoHibernate.close();		
		
		
	}

	@SuppressWarnings("unchecked")
	public List<Equipe> ordenar () {
		
		 List<Equipe> list;
		
		secaoHibernate=HibernateUtil.createSessionFactory().openSession();
		secaoHibernate.beginTransaction();
		
		Query query = secaoHibernate.createQuery("from Equipe order by pontuacao desc");
		
		//Query query  = secaoHibernate.createQuery("select (pontuacao+saldo+vitorias) as total, nomeEquipe "
		//+ "from Equipe order by total desc");		
		
		list=query.list();
		
		secaoHibernate.getTransaction().commit();
		
		return list;
		
	}
	
	
	public List<Equipe> ListaPorModalidade (Modalidade modalidade){
		
		
		
		secaoHibernate=HibernateUtil.createSessionFactory().openSession();
		secaoHibernate.beginTransaction();
		Query query = secaoHibernate.
		createQuery("from Equipe where codModalidade ="+modalidade.getCodModalidade()+"order by pontuacao desc");		
		this.lista = query.list();
		secaoHibernate.getTransaction().commit();
		secaoHibernate.close();
		return lista;
		
	
	
				
		
	}

		public void excluir (Equipe equipe){
		
		secaoHibernate=HibernateUtil.createSessionFactory().openSession();
		secaoHibernate.getTransaction().begin();
		secaoHibernate.delete(equipe);	
		secaoHibernate.getTransaction().commit();
		secaoHibernate.close();
	}
	
	//inserir
	//excluir
	//atualizar
	//listar
	
	
	

}
