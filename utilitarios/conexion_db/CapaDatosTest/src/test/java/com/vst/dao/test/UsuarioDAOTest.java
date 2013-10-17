package com.vst.dao.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.vst.capa.dao.DAOLayer;
import com.vst.dao.UsuarioDAO;
import com.vst.dominio.Usuario;
import com.vst.util.TraductorDeExcepciones;

public class UsuarioDAOTest {
	
	private static Log log = LogFactoryUtil.getLog(UsuarioDAOTest.class);	
	private DAOLayer daoLayer = null;
	int nb = 102 ;
	@Before
	public void beforeTest() {	
		log.info("beforeTest nb:"+nb);
		daoLayer = DAOLayer.getInstanceDAOLayer();
		log.info("daoLayer:"+daoLayer);
//		nb = Util.random();
	}
	
//	@Test
//	public void insertUsuario() {
//		Usuario u = null;
//		try {	
//			UsuarioDAO usuarioDAO  = daoLayer.getUsuarioDAOImpl();
//			log.info("usuarioDAO:"+usuarioDAO);
//			log.info("insertUsuario");
//			int n = Util.random();
//			u = new Usuario("chat"+n, "chat"+n, "chat"+n, "chat"+n);
//			usuarioDAO.abrirConexion();
//			usuarioDAO.guardar(u);
//			log.info("nuevo Usuario:"+u.getId());
//			usuarioDAO.commit();
//			usuarioDAO.cerrarConexion();
//			Assert.assertNotNull(u.getId());
//		} catch (Exception e) {
//			TraductorDeExcepciones.traducir(e.getMessage(), e);
//		}
//	}
//	
	@Test
	public void insertUsuario2() {
		Usuario u = null;
		try {	
			UsuarioDAO usuarioDAO  = daoLayer.getUsuarioDAOImpl();
			log.info("usuarioDAO:"+usuarioDAO);
			log.info("insertUsuario2  nb:"+nb);			
			u = new Usuario("chat"+nb, "chat"+nb, "chat"+nb, "chat"+nb);
			usuarioDAO.abrirConexion();
			usuarioDAO.guardar(u);
			log.info("nuevo Usuario:"+u.getId());
			usuarioDAO.commit();
			usuarioDAO.cerrarConexion();
			Assert.assertNotNull(u.getId());
		} catch (Exception e) {
			TraductorDeExcepciones.traducir(e.getMessage(), e);
		}
	}
	
	@Test
	public void buscarUsuario() {	
		try {	
		UsuarioDAO usuarioDAO  = daoLayer.getUsuarioDAOImpl();
		log.info("buscarUsuario:"+usuarioDAO + " - chat"+nb +"  nb:"+nb);
		Usuario u = usuarioDAO.buscarUsuario("chat"+nb);
		log.info("Usuario:"+u.getId());
		Assert.assertNotNull(u);
		} catch (Exception e) {
			TraductorDeExcepciones.traducir(e.getMessage(), e);
		}
	}

	
}