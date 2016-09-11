package br.com.sDuc.repository;

import java.util.List;

import javax.inject.Inject;

import br.com.sDuc.model.Agenda;
import br.com.sDuc.util.GenericDAO;

public class Agendas {
	
	@Inject
	private GenericDAO<Agenda> agendaDao;
	
	public Agenda obterAgenda(Integer pkagenda) {
		return agendaDao.find(Agenda.class, pkagenda);
	}
	
	public List<Agenda> listaToda(){		
		return agendaDao.query(Agenda.class,"select a from Agenda a");								
	}
}