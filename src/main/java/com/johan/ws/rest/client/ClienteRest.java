package com.johan.ws.rest.client;

import javax.swing.JOptionPane;

import com.johan.ws.rest.vo.UsuarioVo;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class ClienteRest {
	
	public static void main(String[] args){
		
		String urlSever = "http://localhost:8080/RestPrueba-Arch/servicio/PruebaServer/validarEdad";
		System.out.println(urlSever);
		
		UsuarioVo usuarioVo = new UsuarioVo();
		usuarioVo.setNombre(JOptionPane.showInputDialog("Nombre: "));
		usuarioVo.setEdad(Integer.parseInt(JOptionPane.showInputDialog("Edad: ")));
		usuarioVo.setMsj("");
		
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		
		Client cliente = Client.create(clientConfig);
		
		WebResource webResource = cliente.resource(urlSever);
		
		ClientResponse respuesta = webResource.type("application/json").post(ClientResponse.class , usuarioVo);
		usuarioVo = respuesta.getEntity(UsuarioVo.class);
		
		System.out.println("Respuesta = [Nombre: " + usuarioVo.getNombre() + "]");
		System.out.println("Respuesta = [Mensaje: " + usuarioVo.getMsj() + "]");
	}
}
