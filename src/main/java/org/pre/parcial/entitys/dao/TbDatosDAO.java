package org.pre.parcial.entitys.dao;

import org.pre.parcial.entitys.model.TbDatos;

import java.util.List;

public interface TbDatosDAO {
  void insertar(TbDatos datos);
  TbDatos obtenerPorId(int codigo);
  List<TbDatos> obtenerTodos();
  void actualizar(TbDatos datos);
  void eliminar(int codigo);
}
