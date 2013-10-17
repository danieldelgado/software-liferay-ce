package com.vst.dao.impl;

import java.util.List;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.vst.dao.UsuarioDAO;
import com.vst.dominio.Usuario;
import com.vst.util.DAO;
import static com.vst.util.Util.printParameterQuery;

public class UsuarioDAOImpl extends DAO<Usuario> implements UsuarioDAO {

	private static Log logger = LogFactoryUtil.getLog(UsuarioDAOImpl.class);
	
	@SuppressWarnings("unchecked")
	public Usuario buscarUsuario(Usuario usuario) {
		if(usuario!=null){
			sqlQuery = "select  new Usuario(u.id, u.userName, u.clave, u.nombre, u.apellido)  from Usuario u where u.userName=:userName";
			q = getEntityManager().createQuery(sqlQuery);
			logger.info("buscando usuario por username "+usuario.getUserName());
			logger.info("sqlQuery:"+sqlQuery);
			q.setParameter("userName", usuario.getUserName());
			printParameterQuery(q); 
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
			q = getEntityManager().createQuery(sqlQuery);
			logger.info("buscando usuario por username "+userName);
			logger.info("sqlQuery:"+sqlQuery);
			q.setParameter("userName",userName);
			printParameterQuery(q); 
			List<Usuario> lst = q.getResultList();
			if(lst!=null && lst.size()>0){
				Usuario u = lst.get(0);
				return u ;
			}
		}		
		return null;
	}

	
}
