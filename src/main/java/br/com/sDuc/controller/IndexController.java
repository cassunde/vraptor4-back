package br.com.sDuc.controller;

import static br.com.caelum.vraptor.view.Results.status;

import javax.inject.Inject;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.serialization.gson.WithoutRoot;
import br.com.caelum.vraptor.view.Results;
import br.com.sDuc.model.Agenda;
import br.com.sDuc.rn.AgendaRN;

@Controller
public class IndexController {

	@Inject
	private Result result;
	
	@Inject
	private AgendaRN rnAgendas;	

	@Get
	@Path(value = {"/agenda", ""})
	@Consumes(value = "application/json", options = WithoutRoot.class)
	public void todos() {
		result.use(Results.json()).withoutRoot().from(rnAgendas.listaTudo()).serialize();
	}
	
	@Post
	@Path(value = {"/agenda", ""})
	@Consumes(value = "application/json", options = WithoutRoot.class)
	public void novo( Agenda agenda ) {		
		if(agenda.getId() != null){
			rnAgendas.atualizar(agenda);
		}else {
			System.out.println("Objeto "+agenda.getNumero());
			rnAgendas.salvar(agenda);
		}
		result.use(status()).created();
	}
	
	@Delete
	@Path(value = "/agenda/{id}")
	public void remove( Integer id ) {
		Agenda agendaDel = rnAgendas.obterAgenda(id);				
		rnAgendas.deletar(agendaDel);		
		result.use(status()).ok();
	}		
}