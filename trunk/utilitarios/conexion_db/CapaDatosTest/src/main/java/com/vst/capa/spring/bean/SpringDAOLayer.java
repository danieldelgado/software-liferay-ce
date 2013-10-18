package com.vst.capa.spring.bean;

import java.util.Map;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class SpringDAOLayer {

	private static Log log = LogFactoryUtil.getLog(SpringDAOLayer.class);	
	private Map<String,String> indexEntityMap = null;
	
	public SpringDAOLayer() {
		log.info(" cargando!!!!! SpringDAOLayer ");
	}

	public void completeInstance(){
		log.info("init");
		log.info(indexEntityMap);
	}
	
	public Map<String,String> getIndexEntityMap() {
		return indexEntityMap;
	}

	public void setIndexEntityMap(Map<String,String> indexEntityMap) {
		log.info("indexEntityMap");
		log.info(indexEntityMap);
		this.indexEntityMap = indexEntityMap;
	}
	
	

}
