package com.vst.capa.dao;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.vst.dao.UsuarioDAO;
import com.vst.dao.impl.UsuarioDAOImpl;

public final class DAOLayer {

	private static Log log = LogFactoryUtil.getLog(DAOLayer.class);	
	
	private final static DAOLayer daoLayer = newInstanceDAOLayer();
	private final static UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		
	private DAOLayer() {}
	
	private static DAOLayer newInstanceDAOLayer(){
		log.info("newInstanceDAOLayer:");
		return new DAOLayer();
	}
	
	public static DAOLayer getInstanceDAOLayer(){
		log.info("obtener DAOLayer:"+daoLayer);
		return daoLayer;
	}
	
	public UsuarioDAO getUsuarioDAOImpl(){
		log.info("obtener UsuarioDAO:"+usuarioDAO);
		return usuarioDAO;
	}
	
	

}
