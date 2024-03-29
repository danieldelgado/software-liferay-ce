package com.vst.util;

import static com.vst.util.DAOConexionUtil.getEntityManagerFactory;

import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

@SuppressWarnings("unchecked")
public class DAO<T extends Entidad> implements IDAO<T> {

	private static Log log = LogFactoryUtil.getLog(DAO.class);
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static EntityTransaction entityTransaction;
	private Class<Entidad> clazz;
	private String portletSC;
	protected String sqlQuery = null;
	protected Query q = null;

	static {
		emf = getEntityManagerFactory();
		em = emf.createEntityManager();
		log.info("DAO static createEntityManagerFactory");
	}

	public DAO() {
		clazz = (Class<Entidad>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		log.info("startup new DAO " + clazz.getSimpleName() + " - " + (new Date()));
	}

	public void initDAO() {
		log.info("Portlet " + portletSC + "context root " + clazz.getSimpleName() + " completeInstance " + (new Date()));
	}

	public void closeDAO() {
		log.info("Portlet " + portletSC + "context root " + clazz.getSimpleName() + " closeDAO " + (new Date()));
		if (!em.isOpen()) {
			em.flush();
			em.close();
		}
		emf = null;
		em = null;
		entityTransaction = null;
		clazz = null;
		sqlQuery = null;
		q = null;
	}

	public EntityManager getEntityManager() {
		log.info("getEntityManager em.isOpen():" + em.isOpen());
		if (!em.isOpen()) {
			em = null;
			em = emf.createEntityManager();
		}
		return em;
	}

	public T get(Integer id) {
		return (T) getEntityManager().find(clazz, id);
	}

	public List<T> getTodos() {
		Entity e = (Entity) clazz.getAnnotation(Entity.class);
		String nombre = null;
		if (e == null || e.name() == null || e.name().length() == 0)
			nombre = clazz.getSimpleName();
		else
			nombre = e.name();
		String sql = "SELECT e FROM " + nombre + " e";
		return getEntityManager().createQuery(sql).getResultList();
	}

	public void abrirConexion() throws Exception {
		if (!em.isOpen()) {
			em = null;
			em = emf.createEntityManager();
		}
		log.info("abrirConexion " + clazz.getSimpleName() + " createEntityManager:" + em);
		entityTransaction = em.getTransaction();
		entityTransaction.begin();
	}

	public void commit() throws Exception {
		log.info("commit " + clazz.getSimpleName());
		entityTransaction.commit();
	}

	public void flush() throws Exception {
		log.info("flush " + clazz.getSimpleName());
		em.flush();
	}

	public void rollback() throws Exception {
		log.info("rollback " + clazz.getSimpleName());
		entityTransaction.rollback();
	}

	public void cerrarConexion() throws Exception {
		log.info("cerrarConexion " + clazz.getSimpleName());
		em.close();
	}

	public void guardar(T objeto) {
		log.info("guardar " + clazz.getSimpleName());
		if (objeto.getId() != null)
			em.merge(objeto);
		else
			em.persist(objeto);
	}

	public void eliminar(T objeto) {
		if (objeto.getId() != null)
			em.remove(objeto);
	}

	public List<T> getTodosCampo(String campo, String value) {
		Entity e = (Entity) clazz.getAnnotation(Entity.class);
		String nombre = null;
		if (e == null || e.name() == null || e.name().length() == 0)
			nombre = clazz.getSimpleName();
		else
			nombre = e.name();
		String sql = "SELECT e FROM " + nombre + " e where e." + campo + "=:value";
		return getEntityManager().createQuery(sql).setParameter("value", value).getResultList();
	}

	public T getPorCodigo(String codigo) {
		Entity e = (Entity) clazz.getAnnotation(Entity.class);
		String nombre = null;
		if (e == null || e.name() == null || e.name().length() == 0)
			nombre = clazz.getSimpleName();
		else
			nombre = e.name();
		String sql = "SELECT e FROM " + nombre + " e  where e.codigo = :codigo";
		return (T) getEntityManager().createQuery(sql).setParameter("codigo", codigo).getSingleResult();
	}

	public List<T> getTodosActivos() {
		Entity e = (Entity) clazz.getAnnotation(Entity.class);
		String nombre = null;
		if (e == null || e.name() == null || e.name().length() == 0)
			nombre = clazz.getSimpleName();
		else
			nombre = e.name();
		String sql = "SELECT e FROM " + nombre + " e where e.activo = 'A'";
		return getEntityManager().createQuery(sql).getResultList();
	}

	public String getPortletSC() {
		return portletSC;
	}

	public void setPortletSC(String portletSC) {
		this.portletSC = portletSC;
	}

}
