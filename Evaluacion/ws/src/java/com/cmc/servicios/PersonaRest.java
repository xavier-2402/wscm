package com.cmc.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.process.internal.RequestScoped;

import com.cmc.rest.commons.ArchivoException;
import com.cmc.rest.commons.ValidationChecked;
import com.cmc.rest.entidades.Persona;
import com.cmc.rest.servicios.ManejadorArchivos;
import com.cmc.rest.servicios.ServicioPersonas;

@Path("/personas")
public class PersonaRest {
	@Path("/cambiar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Persona modificar(Persona persona) {
		System.out.println(persona);
		Persona personamodificada = null;
	    //personamodificada = ServicioPersonas.actualizar(persona);
		return personamodificada;
	}

	@Path("/cambio")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public static Response cambiar(Persona persona) {
		System.out.println(persona);
		Persona personamodificada = null;
		try {
			personamodificada = ServicioPersonas.actualizar(persona);
			return Response.status(200).entity(personamodificada).build();
		} catch (ValidationChecked e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(200).entity(e).build();
		}

	}
	
	@Path("/restws")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public static Response consultarPersonas() {
		ArrayList<Persona>personas=null;
		try {
			personas=ManejadorArchivos.leer();
			return Response.status(200).entity(personas).build();
		} catch (ArchivoException e) {
			// TODO Auto-generated catch block
			return Response.status(200).entity(e).build();
		}

	}
	
}
