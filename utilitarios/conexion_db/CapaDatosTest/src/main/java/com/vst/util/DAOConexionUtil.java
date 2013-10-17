package com.vst.util;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import static com.vst.util.Config.getPropiedad;
import static com.vst.util.Config.getPropiedadInt;

public class DAOConexionUtil {

	private static Log log = LogFactoryUtil.getLog(DAO.class);
	
	public static EntityManagerFactory getEntityManagerFactory(){
		int context = getPropiedadInt("persistence.jndi.conextion");
		EntityManagerFactory emf = null;
		if(context == Constantes.INICIAR_JDNI_CONTEXT){
			emf = entityManagerFactoryContext();
			log.info("getEntityManagerFactory INICIAR_JDNI_CONTEXT");
		}else
		if(context == Constantes.INICIAR_TEST){
			emf = entityManagerFactory();
			log.info("getEntityManagerFactory INICIAR_TEST");
		}
		return emf;
	}	
	
	public static EntityManagerFactory entityManagerFactory() {
		String puName = getPropiedad("persistence.name");
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("javax.persistence.jdbc.driver", getPropiedad("javax.persistence.jdbc.driver"));
		properties.put("javax.persistence.jdbc.url", getPropiedad("javax.persistence.jdbc.url"));
		properties.put("javax.persistence.jdbc.user", getPropiedad("javax.persistence.jdbc.user"));
		properties.put("javax.persistence.jdbc.password", getPropiedad("javax.persistence.jdbc.password"));			
		return Persistence.createEntityManagerFactory(puName, properties);
	}

	public static EntityManagerFactory entityManagerFactoryContext() {
		String puName = getPropiedad("persistence.name");	
		return Persistence.createEntityManagerFactory(puName);
	}
	
}
