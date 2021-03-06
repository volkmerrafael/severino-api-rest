package com.br.antbridge.severino.resource.mod_controleponto.anomes;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.br.antbridge.core.resource.ResourceCRUD;
import com.br.antbridge.severino.entity.mod_controleponto.AnoMes;

public class AnoMesResource extends ResourceCRUD<AnoMes> {
	
	public AnoMesResource() {
	}
	
	@Override
	public Class<AnoMes> getModelClass() {
		return AnoMes.class;
	}
	
	public AnoMes buscaPorAnoMes(Integer ano, Integer mes) throws Exception {
		
		TypedQuery<AnoMes> queryAnoMes = this.getEm().createQuery("select d from AnoMes d where d.ano = :ano and d.mes = :mes", AnoMes.class);
		queryAnoMes.setParameter("ano", ano);	
		queryAnoMes.setParameter("mes", mes);
		
		AnoMes anomes = new AnoMes();
		
		try {
			anomes = queryAnoMes.getSingleResult();
		} catch (NoResultException e) {
			anomes = null;
		}
		
		return anomes;
		
	}
	
}