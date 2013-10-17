package com.vst.dao.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.vst.dao.UsuarioDAO;
import com.vst.dao.impl.UsuarioDAOImpl;
import com.vst.dominio.Usuario;

public class UsuarioDAOTest {
	
	UsuarioDAO usuarioDAO = null;
	
	@Before
	public void beforeTest() {	
		usuarioDAO = new UsuarioDAOImpl(); 
	}
	
	@Test
	public void inserUsuario() {		
		Usuario u = new Usuario("chat06", "chat06", "chat06", "chat06");
		usuarioDAO.abrirConexion();
		usuarioDAO.guardar(u);
		usuarioDAO.commit();
		usuarioDAO.cerrarConexion();
		Assert.assertNotNull(u.getId());
	}
	
	@Test
	public void buscarUsuario() {		
		Usuario u = usuarioDAO.buscarUsuario("chat06");
		System.out.println("u:"+u);
		Assert.assertNotNull(u);
	}

	
}