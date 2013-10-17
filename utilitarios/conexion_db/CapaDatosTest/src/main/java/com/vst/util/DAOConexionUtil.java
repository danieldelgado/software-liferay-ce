package com.vst.util;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class DAOConexionUtil {

	private static Integer context ;
	private static String persistence_name ;
	private static Log log = LogFactoryUtil.getLog(DAO.class);
	
	static{
		context = Config.getPropiedadInt("conectar.jdni.database");
		persistence_name = Config.getPropiedad("persistence.name");
		log.info(" DAOConexionUtil context:"+context+" persistence_name:"+persistence_name);
	}
	
	public static EntityManagerFactory entityManagerFactory() {		
		if(context == Constantes.INICIAR_JDNI_CONTEXT){
			return Persistence.createEntityManagerFactory(persistence_name);
		}else{
			Map<String, Object> properties = new HashMap<String, Object>();
			properties.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
			properties.put("javax.persistence.jdbc.url", "jdbc:mysql://192.168.1.219:3306/chathsd");
			properties.put("javax.persistence.jdbc.user", "root");
			properties.put("javax.persistence.jdbc.password", "root");			
			return Persistence.createEntityManagerFactory(persistence_name, properties);
		}
		
	}

	
}
