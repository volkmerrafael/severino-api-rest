package com.br.antbridge.severino.resource.mod_geral.usuario.departamento;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.br.antbridge.core.resource.ResourceCRUD;
import com.br.antbridge.severino.entity.mod_geral.usuario.Departamento;

public class DepartamentoResource extends ResourceCRUD<Departamento> {
	
	public DepartamentoResource() {
	}
	
	@Override
	public Class<Departamento> getModelClass() {
		return Departamento.class;
	}
	
	public Departamento buscaPorNome(String nomeDepartamento) throws Exception {
		
		TypedQuery<Departamento> queryDepartamento = this.getEm().createQuery("select d from Departamento d where d.nome = :nomeDepartamento", Departamento.class);
		queryDepartamento.setParameter("nomeDepartamento", nomeDepartamento);	
		
		Departamento departamento = new Departamento();
		
		try {
			departamento = queryDepartamento.getSingleResult();
		} catch (NoResultException e) {
			departamento = null;
		}
		
		return departamento;
		
	}
	
}