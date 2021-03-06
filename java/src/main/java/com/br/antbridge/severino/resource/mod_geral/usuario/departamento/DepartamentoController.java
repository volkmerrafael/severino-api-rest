package com.br.antbridge.severino.resource.mod_geral.usuario.departamento;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;

import com.br.antbridge.core.rest.ControllerCRUD;
import com.br.antbridge.severino.entity.mod_geral.usuario.Departamento;

import io.swagger.annotations.Api;

@Api("Departamento")
@Path("/departamento")
public class DepartamentoController extends ControllerCRUD<Departamento, DepartamentoResource> {

	@HeaderParam("user-token")
	String userToken;
	
	@HeaderParam("session-token")
	String sessionToken;

	@Override
	public DepartamentoResource newResource() {
		return new DepartamentoResource();
	}
	
}
