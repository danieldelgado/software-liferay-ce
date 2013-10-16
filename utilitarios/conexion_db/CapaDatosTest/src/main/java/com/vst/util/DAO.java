package com.vst.util;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

@SuppressWarnings("unchecked")
public class DAO<T extends Entidad>  implements IDAO<T> {

	protected static EntityManager em;

	private Class<Entidad> clazz;

	protected String sqlQuery = null;

	protected Query q = null;	
	
	static{
		String puName = "hsd_chat";
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
		properties.put("javax.persistence.jdbc.url", "jdbc:mysql://192.168.1.37:3306/chathsd");
		properties.put("javax.persistence.jdbc.user", "root");
		properties.put("javax.persistence.jdbc.password", "root");	
		em = Persistence.createEntityManagerFactory(puName,properties).createEntityManager();
	}	
	
	public DAO() {
		clazz = (Class<Entidad>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		
	}

	public T get(Integer id) {
		return (T) em.find(clazz, id);
	}

	public List<T> getTodos() {
		Entity e = (Entity) clazz.getAnnotation(Entity.class);
		String nombre = null;
		if (e == null || e.name() == null || e.name().length() == 0)
			nombre = clazz.getSimpleName();
		else
			nombre = e.name();
		String sql = "SELECT e FROM " + nombre + " e";
		return em.createQuery(sql).getResultList();
	}

	public void abrirConexion() {
		em.getTransaction().begin();
	}
	
	public void cerrarConexion() {
		em.close();
	}

	public void commit() {
		em.getTransaction().commit();
	}
	
	public void rollback() {
		em.getTransaction().rollback();
	}
	
	public void guardar(T objeto) {
		if (objeto.getId() != null)
			em.merge(objeto);
		else
			em.persist(objeto);
	}

	public void eliminar(T objeto) {
		if (objeto.getId() != null)
			em.remove(objeto);
	}

	public T getPorCodigo(String codigo) {
		Entity e = (Entity) clazz.getAnnotation(Entity.class);
		String nombre = null;
		if (e == null || e.name() == null || e.name().length() == 0)
			nombre = clazz.getSimpleName();
		else
			nombre = e.name();
		String sql = "SELECT e FROM " + nombre + " e  where e.codigo = :codigo";
		return (T) em.createQuery(sql).setParameter("codigo", codigo).getSingleResult();
	}

	public List<T> getTodosActivos() {
		Entity e = (Entity) clazz.getAnnotation(Entity.class);
		String nombre = null;
		if (e == null || e.name() == null || e.name().length() == 0)
			nombre = clazz.getSimpleName();
		else
			nombre = e.name();
		String sql = "SELECT e FROM " + nombre + " e where e.activo = 'A'";
		return em.createQuery(sql).getResultList();
	}

}
