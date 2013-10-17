package com.vst.dao.impl;

import java.util.List;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.vst.dao.UsuarioDAO;
import com.vst.dominio.Usuario;
import com.vst.util.DAO;
//import org.springframework.stereotype.Repository;

public class UsuarioDAOImpl extends DAO<Usuario> implements UsuarioDAO {

//	private static final Logger logger = LoggerFactory.getLogger(UsuarioDAOImpl.class);
	private static Log logger = LogFactoryUtil.getLog(UsuarioDAOImpl.class);
	
	@SuppressWarnings("unchecked")
	public Usuario buscarUsuario(Usuario usuario) {
		if(usuario!=null){
			sqlQuery = "select  new Usuario(u.id, u.userName, u.clave, u.nombre, u.apellido)  from Usuario u where u.userName=:userName";
			q = em.createQuery(sqlQuery);
			logger.info("buscando usuario por username "+usuario.getUserName());
			q.setParameter("userName", usuario.getUserName());
			List<Usuario> lst = q.getResultList();
			if(lst!=null && lst.size()>0){
				Usuario u = lst.get(0);
				return u ;
			}
		}		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public Usuario buscarUsuario(String userName) {
		if(userName!=null&&userName.length()>0){
			sqlQuery = "select  new Usuario(u.id, u.userName, u.clave, u.nombre, u.apellido)  from Usuario u where u.userName=:userName";
			q = em.createQuery(sqlQuery);
			logger.info("buscando usuario por username "+userName);
			q.setParameter("userName",userName);
			List<Usuario> lst = q.getResultList();
			if(lst!=null && lst.size()>0){
				Usuario u = lst.get(0);
				return u ;
			}
		}		
		return null;
	}

	
}
