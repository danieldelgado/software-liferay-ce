package com.vst.spring.service;

import static com.vst.capa.dao.DAOLayer.getInstanceDAOLayer;

import org.springframework.stereotype.Service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.vst.dao.UsuarioDAO;
import com.vst.dominio.Usuario;
import com.vst.util.TraductorDeExcepciones;
import com.vst.util.Util;

/**
 * Portlet implementation class SpringDemoController
 */

@Service("SpringDemoService")
public class SpringDemoServiceImpl implements SpringDemoService {

	private static Log log = LogFactoryUtil.getLog(SpringDemoServiceImpl.class);

	UsuarioDAO usuarioDAO = getInstanceDAOLayer().getUsuarioDAOImpl();
	
	@Override
	public String hello() {
		int nb = 100 ;
		nb = Util.random();
		log.info(" SpringDemoServiceImpl ");
		
		Usuario u = new Usuario("chat"+nb, "chat"+nb, "chat"+nb, "chat"+nb);
		try {
			log.info("abrir conexion");
			usuarioDAO.abrirConexion();
			usuarioDAO.guardar(u);
			usuarioDAO.commit();	
			log.info("commit");
			usuarioDAO.cerrarConexion();
			log.info("cerrar conexion");
		} catch (Exception e) {
			TraductorDeExcepciones.traducir(e.getMessage(), e);
		}
		u = usuarioDAO.buscarUsuario("chat"+nb);
		log.info("Usuario:"+u.getId());
		
		
		
		return "holaaaaa :D";
	}
	
	
	
	
}
