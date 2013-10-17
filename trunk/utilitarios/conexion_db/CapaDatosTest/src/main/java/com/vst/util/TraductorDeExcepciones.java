package com.vst.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;




public class TraductorDeExcepciones {

	private static Log log = LogFactoryUtil.getLog(DAO.class);

	public static void traducir(String msg,Exception e) {	
		log.error(msg+" "+e.getMessage() + " " + e.getLocalizedMessage() + " " +e.getCause() , e);		
		e.printStackTrace();		
	}
}
