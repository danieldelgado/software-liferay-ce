package com.vst.util;

import java.util.List;

public interface IDAO<T extends Entidad> {

	public T get(Integer id);
	
	public T getPorCodigo(String codigo);

	public List<T> getTodos();
	
	public List<T> getTodosActivos() ;
	
	public void guardar(T objeto);

	public void eliminar(T objeto);

	public void abrirConexion();
	
	public void cerrarConexion();

	public void commit() ;

}
