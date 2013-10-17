package com.vst.capa.dao;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.vst.dao.UsuarioDAO;
import com.vst.dao.impl.UsuarioDAOImpl;

public final class DAOLayer {

	private final static Log logger = LogFactoryUtil.getLog(DAOLayer.class);	
	
	private final static DAOLayer daoLayer = newInstanceDAOLayer();
	private final static UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
	
	private DAOLayer() {}
	
	private static DAOLayer newInstanceDAOLayer(){
		logger.info("new DAOLayer:"+daoLayer);
		return new DAOLayer();
	}
	
	public static DAOLayer getInstanceDAOLayer(){
		logger.info("obtener DAOLayer:"+daoLayer);
		return daoLayer;
	}
	
	public UsuarioDAO getUsuarioDAOImpl(){
		logger.info("obtener UsuarioDAO:"+usuarioDAO);
		return usuarioDAO;
	}
	
	

}
