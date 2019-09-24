package com.johan.ws.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.johan.ws.rest.vo.UsuarioVo;

@Path("/PruebaServer")
public class LoginService {
	
	@POST
	@Path("/validarEdad")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public UsuarioVo validarEdad(UsuarioVo usuarioVo){
		if(usuarioVo.getEdad() >= 18){
			usuarioVo.setMsj(usuarioVo.getNombre()+" es Mayor de Edad");
		}else{
			usuarioVo.setMsj(usuarioVo.getNombre()+" es Menor de Edad");
		}
		return usuarioVo;
	}
}
