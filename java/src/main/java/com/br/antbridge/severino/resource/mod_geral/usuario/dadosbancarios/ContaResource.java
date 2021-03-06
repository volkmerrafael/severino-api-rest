package com.br.antbridge.severino.resource.mod_geral.usuario.dadosbancarios;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.br.antbridge.core.resource.ResourceCRUD;
import com.br.antbridge.severino.entity.mod_geral.usuario.Usuario;
import com.br.antbridge.severino.entity.mod_geral.usuario.dadosbancarios.Conta;
import com.br.antbridge.severino.resource.mod_geral.usuario.UsuarioResource;

public class ContaResource extends ResourceCRUD<Conta> {
	
	public ContaResource() {
	}
	
	@Override
	public Class<Conta> getModelClass() {
		return Conta.class;
	}
	
	public List<Conta> listarContasDoUsuario(String token) throws Exception {
		
		try (UsuarioResource usuRes = new UsuarioResource()) {
			Usuario usuario = usuRes.buscaUsuarioPeloToken(token);
			
			TypedQuery<Conta> queryConta = this.getEm().createQuery("select d from Conta d where d.usuario = :usuario", this.getModelClass());
			queryConta.setParameter("usuario", usuario);
			
			return queryConta.getResultList();
			
		} catch (NoResultException e) {
		}
				
		return null;
		
	}
	
}