package com.vst.util;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAOConexionUtil {

	public static EntityManagerFactory getEntityManagerFactory(){
		int context = Config.getPropiedadInt("persistence.jndi.conextion");
		EntityManagerFactory emf = null;
		if(context == Constantes.INICIAR_JDNI_CONTEXT){
			emf = entityManagerFactoryContext();
		}else
		if(context == Constantes.INICIAR_TEST){
			emf = entityManagerFactory();
		}
		return emf;
	}	
	
	public static EntityManagerFactory entityManagerFactory() {
		String puName = Config.getPropiedad("persistence.name");
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
		properties.put("javax.persistence.jdbc.url", "jdbc:mysql://192.168.1.219:3306/chathsd");
		properties.put("javax.persistence.jdbc.user", "root");
		properties.put("javax.persistence.jdbc.password", "root");			
		return Persistence.createEntityManagerFactory(puName, properties);
	}

	public static EntityManagerFactory entityManagerFactoryContext() {
		String puName = Config.getPropiedad("persistence.name");	
		return Persistence.createEntityManagerFactory(puName);
	}
	
}
