package com.vst.dao.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.vst.capa.dao.DAOLayer;
import com.vst.dao.DispositivoMovilDAO;
import com.vst.dao.UsuarioDAO;
import com.vst.dao.impl.DispositivoMovilDAOImpl;
import com.vst.dominio.DispositivoMovil;
import com.vst.dominio.Usuario;
import com.vst.util.TraductorDeExcepciones;

public class DispositivoMovilDAOTest {
	
	private static Log log = LogFactoryUtil.getLog(DispositivoMovilDAOTest.class);	
	private DAOLayer daoLayer = null;
	int nb = 102 ;
	@Before
	public void beforeTest() {	
		log.info("beforeTest nb:"+nb);
		daoLayer = DAOLayer.getInstanceDAOLayer();
		log.info("daoLayer:"+daoLayer);
//		nb = Util.random();
	}
	
	@Test
	public void insertDispositivoMovilDAO() {
		DispositivoMovilDAO dispositivoMovilDAO = new DispositivoMovilDAOImpl();
		log.info("todos");
		log.info(dispositivoMovilDAO.getTodos());
		Assert.assertNotNull(dispositivoMovilDAO.getTodos());
		UsuarioDAO usuarioDAO  = daoLayer.getUsuarioDAOImpl();
		Usuario u = usuarioDAO.get(1);
		DispositivoMovil dispositivoMovil = new DispositivoMovil();
		dispositivoMovil.setActivo(true);
		dispositivoMovil.setKeyDevice("asdsdsadsa");
		dispositivoMovil.setNumeroMovil("asdsdsad");
		dispositivoMovil.setUsuario(u);
		try {
			log.info("abrir conexion");
			dispositivoMovilDAO.abrirConexion();
			dispositivoMovilDAO.guardar(dispositivoMovil);
			dispositivoMovilDAO.commit();	
			log.info("commit");
			dispositivoMovilDAO.cerrarConexion();
			log.info("cerrar conexion");
		} catch (Exception e) {
			TraductorDeExcepciones.traducir(e.getMessage(), e);
		}
			
		
		log.info("dispositivoMovil:"+dispositivoMovil.getId());
		Assert.assertNotNull(dispositivoMovil.getId());
	}
	
	
}
