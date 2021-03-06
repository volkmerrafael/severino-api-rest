package com.br.antbridge.severino.resource.mod_controleponto.diasemana;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.br.antbridge.core.resource.ResourceCRUD;
import com.br.antbridge.severino.entity.mod_controleponto.DiaSemana;

public class DiaSemanaResource extends ResourceCRUD<DiaSemana> {
	
	public DiaSemanaResource() {
	}
	
	@Override
	public Class<DiaSemana> getModelClass() {
		return DiaSemana.class;
	}
	
	public DiaSemana buscaPorNome(String nomeDiaSemana) throws Exception {
		
		TypedQuery<DiaSemana> queryDiaSemana = this.getEm().createQuery("select d from DiaSemana d where d.nome = :nomeDiaSemana", DiaSemana.class);
		queryDiaSemana.setParameter("nomeDiaSemana", nomeDiaSemana);	
		
		DiaSemana daisemana = new DiaSemana();
		
		try {
			daisemana = queryDiaSemana.getSingleResult();
		} catch (NoResultException e) {
			daisemana = null;
		}
		
		return daisemana;
		
	}

}