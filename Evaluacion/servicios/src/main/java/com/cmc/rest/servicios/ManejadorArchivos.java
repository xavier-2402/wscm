package com.cmc.rest.servicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.cmc.rest.commons.ArchivoException;
import com.cmc.rest.entidades.Persona;

public class ManejadorArchivos {

	//private static Logger logger = LogManager.getLogger(AdminClientes.class);

	public static ArrayList<Persona> leer() throws ArchivoException {
		File file = new File("C:\\Users\\usuario\\Downloads\\EclipseNeon\\eclipseNeon\\WSCM\\archivo.txt");
		BufferedReader br = null;
		FileReader fileReader = null;
		String linea = "";
		Persona persona=null;
		String[] partes;
		ArrayList<Persona> personas = new ArrayList<Persona>();
		try {
			fileReader = new FileReader(file.getAbsolutePath());
			System.out.println(file.getAbsolutePath());
			br = new BufferedReader(fileReader);
			while ((linea = br.readLine()) != null) {
				if (!linea.isEmpty()) {
					partes = linea.split("-");
					persona = new Persona(partes[0], partes[1], partes[2],Integer.parseInt(partes[3]));
					personas.add(persona);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("No existe el archivo"+e);
			throw new ArchivoException("No existe el archivo");
			//logger.error("No existe el archivo:", e);
		} catch (IOException e) {
			System.out.println("Error al leer el archivo"+e);
			throw new ArchivoException("Error al leer el archivo");
			//logger.error("Error al leer el archivo:", e);
		}finally{
			try {
				if (br != null) {
					br.close();
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				//logger.error("Error al cerrar BufferReader br", e);
				System.out.println("Error al cerrar el bufferReader"+e);
				throw new ArchivoException("Error al cerrar el bufferReader");
			}
			try {
				if (fileReader != null) {
					fileReader.close();
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				
				//logger.error("Error al cerrar FilerReader fr", e);
				System.out.println("Error al cerrar el fileReader"+e);
				throw new ArchivoException("Error al cerrar el fileReader");
			}
		}
		
		return personas;
		

	}
}
