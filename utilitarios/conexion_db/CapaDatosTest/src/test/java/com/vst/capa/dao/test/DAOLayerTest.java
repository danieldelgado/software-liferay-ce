package com.vst.capa.dao.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.vst.capa.dao.DAOLayer;
import com.vst.dao.UsuarioDAO;

public class DAOLayerTest {

	private static Log log = LogFactoryUtil.getLog(DAOLayerTest.class);	
	private DAOLayer daoLayer = null;
	
	@Before
	public void beforeTest() {	
		log.info("beforeTest");
		daoLayer = DAOLayer.getInstanceDAOLayer();
		log.info("daoLayer:"+daoLayer);
		Assert.assertNotNull(daoLayer);
	}
	
	@Test
	public void instanciaUsuarioDao() {		
		UsuarioDAO usuarioDAO = daoLayer.getUsuarioDAOImpl();
		log.info("usuarioDAO:"+usuarioDAO);
		Assert.assertNotNull(usuarioDAO);				
	}
	
	
	
}