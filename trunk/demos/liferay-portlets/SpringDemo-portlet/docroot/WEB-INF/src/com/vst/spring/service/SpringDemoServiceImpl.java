package com.vst.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.vst.dao.DispositivoMovilDAO;
import com.vst.dao.UsuarioDAO;
import com.vst.dominio.DispositivoMovil;
import com.vst.dominio.Usuario;
import com.vst.util.TraductorDeExcepciones;
import com.vst.util.Util;

/**
 * Portlet implementation class SpringDemoController
 */

@Service("SpringDemoService")
public class SpringDemoServiceImpl implements SpringDemoService {

	private static Log log = LogFactoryUtil.getLog(SpringDemoServiceImpl.class);

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Autowired
	private DispositivoMovilDAO dispositivoMovilDAO;

	@Override
	public String hello() {
		System.out.println("hello usuarioDAO:" + usuarioDAO);
		System.out.println("hello dispositivoMovilDAO:" + dispositivoMovilDAO);
		int nb = 100;
		nb = Util.random();
		log.info(" SpringDemoServiceImpl ");

		try {
			Usuario u = new Usuario("chat" + nb, "chat" + nb, "chat" + nb, "chat" + nb);
			log.info("abrir conexion");
			usuarioDAO.abrirConexion();
			usuarioDAO.guardar(u);
			log.info("Usuario:" + u.getId());
			
			DispositivoMovil dispositivoMovil = new DispositivoMovil();
			dispositivoMovil.setActivo(true);
			dispositivoMovil.setKeyDevice("asdsdsadsa");
			dispositivoMovil.setNumeroMovil("asdsdsad");
			dispositivoMovil.setUsuario(u);

//			dispositivoMovilDAO.abrirConexion();
			dispositivoMovilDAO.guardar(dispositivoMovil);
			
			usuarioDAO.commit();
			log.info("commit");
			usuarioDAO.cerrarConexion();
			log.info("cerrar conexion");
//			dispositivoMovilDAO.commit();
//			log.info("commit");
//			dispositivoMovilDAO.cerrarConexion();
//			log.info("cerrar conexion");

			log.info("dispositivoMovil:" + dispositivoMovil.getId());

		} catch (Exception e) {
			TraductorDeExcepciones.traducir(e.getMessage(), e);
		}

		log.info("usuarioDAO");
		log.info(usuarioDAO.getTodos());

		return "holaaaaa :D";
	}

}
