package com.cmc.rest.servicios;

import java.util.Date;

import com.cmc.rest.commons.DateUtil;
import com.cmc.rest.commons.ValidationChecked;
import com.cmc.rest.entidades.Persona;

public class ServicioPersonas {
	
	public static Persona actualizar(Persona persona) throws ValidationChecked{
		
		if(persona.getNombre().length()<=3){
			throw new ValidationChecked("El nombre es muy corto");
		}else if(persona.getApellido().length()<=3){
			throw new ValidationChecked("El apellido es muy corto");
		}else{
			persona.setNombre(persona.getNombre().toUpperCase());
			persona.setApellido(persona.getApellido().toUpperCase());
			Date date = new Date();
			persona.setFechaCreacion(DateUtil.convertir(date));
			return persona;
		}
		
		
	}

}
