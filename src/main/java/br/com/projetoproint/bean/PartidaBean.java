package br.com.projetoproint.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.projetoproint.dao.EquipeDAO;
import br.com.projetoproint.dao.EquipePartidaDAO;
import br.com.projetoproint.dao.PartidaDAO;
import br.com.projetoproint.modelo.Arbitro;
import br.com.projetoproint.modelo.Equipe;
import br.com.projetoproint.modelo.EquipePartida;
import br.com.projetoproint.modelo.Partida;

@ManagedBean
@SessionScoped
public class PartidaBean implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private List<Partida> lista;
	private Partida partida = new Partida();
	private Arbitro arbitro;
	private PartidaDAO daoPartida = new PartidaDAO();
	private EquipePartidaDAO daoEquipePartida = new EquipePartidaDAO();
	private EquipePartida equipepartida = new EquipePartida();
	private Equipe equipe1,equipe2;
	private int pontos1, pontos2,id;
	private Partida partidaRetornada;
	private Partida partidaparam, partidaEditada;
	private List<EquipePartida> listaPORID;
	// construtor
	
	
	public PartidaBean() {
		
	}
	

	@PostConstruct
	public void inicia (){
	this.lista = new PartidaDAO().listar();
	}
	
	
	public String guardar () {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		try{
		
		
		partida.setCpfArbitro(arbitro);
		partidaRetornada = daoPartida.guardar(partida);
		this.inicia();
		context.addMessage(null, new FacesMessage("Operação Realizada"));
		return "/cadastroResultado.xhtml?faces-redirect=trueid="+partidaRetornada.getCodPartida();
		}catch(Exception e){
		
		System.out.println(e.getMessage());
		FacesMessage mensagem = new FacesMessage(e.getMessage());
		mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
		context.addMessage(null, mensagem);
			
		}
		return null;
	}
	
	public void resultado () {
	
	FacesContext context = FacesContext.getCurrentInstance();
	
	
	try {
		
		
		
		
		
	
	equipepartida.setResultadoEquipe(pontos1);
	equipepartida.setCodEquipe(equipe1);
	equipepartida.setCodPartida(partidaparam);
	
	daoEquipePartida.guardar(equipepartida);
	
	equipepartida.setResultadoEquipe(pontos2);
	equipepartida.setCodEquipe(equipe2);
	equipepartida.setCodPartida(partidaparam);
	daoEquipePartida.guardar(equipepartida);
	
	if(equipe1.getCodEquipe()!=equipe2.getCodEquipe())
	{
	if(pontos1 > pontos2)
	{
		equipe1.setPontuacao(equipe1.getPontuacao()+1);
		equipe1.setSaldo(equipe1.getSaldo()+pontos1);
		equipe1.setVitorias(equipe1.getVitorias()+1);
		
	}
	else if (pontos1 < pontos2){
		equipe2.setPontuacao(equipe2.getPontuacao()+1);
		equipe1.setSaldo(equipe2.getSaldo()+pontos2);
		equipe1.setVitorias(equipe2.getVitorias()+2);
		
	}
	else{
		 
		equipe1.setEmpates(equipe1.getEmpates()+1);		 
		equipe1.setEmpates(equipe2.getEmpates()+1);
		
		
	    }
	
	new EquipeDAO().guardar(equipe1);
	new EquipeDAO().guardar(equipe2);
	
	context.addMessage(null, new FacesMessage("Operação Realizada"));
	
	} 
	else{
		FacesMessage mensagem = new FacesMessage("As equipes devem ser diferentes");
		mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
		context.addMessage(null, mensagem);
			
	}
		
	
	
	

	}catch(Exception e){
		
		System.out.println(e.getMessage());
		FacesMessage mensagem = new FacesMessage(e.getMessage());
		mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
		context.addMessage(null, mensagem);
		
	}
	
	}
	
		
	
	public void atualiza () {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		try{
		
		
		daoPartida.guardar(partidaEditada);
		this.inicia();
		context.addMessage(null, new FacesMessage("Operação Realizada"));
		}catch(Exception e){
		
		System.out.println(e.getMessage());
		FacesMessage mensagem = new FacesMessage(e.getMessage());
		mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
		context.addMessage(null, mensagem);
			
		}	
	}
	// get and set
	
	
	
	public List<Partida> getLista () {
			
		return lista;
	}
	
   public Partida getPartidaEditada() {
		return partidaEditada;
	}


	public void setPartidaEditada(Partida partidaEditada) {
		this.partidaEditada = partidaEditada;
	}


public List<EquipePartida> getListaPORID() {
	  return  daoEquipePartida.listaPORID(id);
	}


	public void setListaPORID(List<EquipePartida> listaPORID) {
		this.listaPORID = listaPORID;
	}


public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


public Partida getPartidaparam() {
		return partidaparam;
	}


	public void setPartidaparam(Partida partidaparam) {
		this.partidaparam = partidaparam;
	}


public int getPontos1() {
		return pontos1;
	}


	public void setPontos1(int pontos1) {
		this.pontos1 = pontos1;
	}


	public int getPontos2() {
		return pontos2;
	}


	public void setPontos2(int pontos2) {
		this.pontos2 = pontos2;
	}


public EquipePartida getEquipepartida() {
		return equipepartida;
	}


	public void setEquipepartida(EquipePartida equipepartida) {
		this.equipepartida = equipepartida;
	}


	public Equipe getEquipe1() {
		return equipe1;
	}


	public void setEquipe1(Equipe equipe1) {
		this.equipe1 = equipe1;
	}


	public Equipe getEquipe2() {
		return equipe2;
	}


	public void setEquipe2(Equipe equipe2) {
		this.equipe2 = equipe2;
	}


public Partida getPartida() {
		return partida;
	}


	public void setPartida(Partida partida) {
		this.partida = partida;
	}


	public Arbitro getArbitro() {
		return arbitro;
	}


	public void setArbitro(Arbitro arbitro) {
		this.arbitro = arbitro;
	}


public void setLista (List<Partida> lista){
	  
	   this.lista = lista;
   }
	
	
	

}
