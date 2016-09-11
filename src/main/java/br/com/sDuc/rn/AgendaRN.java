package br.com.sDuc.rn;

import java.util.List;

import javax.inject.Inject;

import br.com.sDuc.model.Agenda;
import br.com.sDuc.repository.Agendas;
import br.com.sDuc.util.GenericDAO;

public class AgendaRN {

	@Inject
	private GenericDAO<Agenda> agendaDao;
	
	@Inject
	private Agendas repAgendas;
	
	public void salvar(Agenda agenda){
		agendaDao.inserir(agenda);
	}
	
	public void atualizar(Agenda agenda){
		agendaDao.salvar(agenda);
	}
	
	public void deletar(Agenda agenda){
		agendaDao.excluir(agenda);
	}
	
	public List<Agenda> listaTudo(){
		return repAgendas.listaToda();
	}
	
	public Agenda obterAgenda(Integer pk){
		return repAgendas.obterAgenda(pk);
	}
}