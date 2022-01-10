package com.cmc.rest.commons;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
public static final  String patron="MM/dd/yyyy HH:mm:ss";
	
	public static String convertir(Date date) {
		DateFormat formato = new SimpleDateFormat(patron);
		String fecha = formato.format(date);
		return fecha;

	}

}
