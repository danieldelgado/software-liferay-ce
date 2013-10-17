package com.vst.util;




public class TraductorDeExcepciones {

//	private static final Logger log = LoggerFactory.getLogger(ArchivoUtil.class);

	public static void traducir(String msg,Exception e) {	
//		log.error(msg+" "+e.getMessage() + " " + e.getLocalizedMessage() + " " +e.getCause() , e);		
		e.printStackTrace();		
	}
}
