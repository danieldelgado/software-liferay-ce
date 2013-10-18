//package com.vst.capa.spring.bean;
//
//import java.util.Date;
//
//import com.liferay.portal.kernel.log.Log;
//import com.liferay.portal.kernel.log.LogFactoryUtil;
//import com.vst.dao.UsuarioDAO;
//
//public class SpringDAOLayer {
//
//	private static Log log = LogFactoryUtil.getLog(SpringDAOLayer.class);	
//	private String portletSC;
//	private UsuarioDAO usuarioDAO;
//	
//	
//	public SpringDAOLayer() {
//		log.info("startup SpringDAOLayer "+(new Date()));
//	}
//
//	public void completeInstance(){
//		log.info("Portlet "+portletSC+ " completeInstance "+(new Date()));
//		if(usuarioDAO!=null){
//			log.info("startup Bean usuarioDAO "+(new Date()));
//		}
//	}
//	
//	public String getPortletSC() {
//		return portletSC;
//	}
//
//	public void setPortletSC(String portletSC) {
//		this.portletSC = portletSC;
//	}
//
//	public UsuarioDAO getUsuarioDAO() {
//		return usuarioDAO;
//	}
//
//	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
//		this.usuarioDAO = usuarioDAO;
//	}
//
//
//}
