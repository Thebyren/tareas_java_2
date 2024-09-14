package org.pre.parcial.entitys.service;

import org.pre.parcial.entitys.dao.TbDatosDAO;
import org.pre.parcial.entitys.model.TbDatos;

import java.util.List;

public class TbDatosService {
  private final TbDatosDAO tbDatosDAO;

  public TbDatosService(TbDatosDAO tbDatosDAO) {
    this.tbDatosDAO = tbDatosDAO;
  }

  public void agregarDatos(TbDatos datos) {
    tbDatosDAO.insertar(datos);
  }

  public TbDatos obtenerDatosPorId(int codigo) {
    return tbDatosDAO.obtenerPorId(codigo);
  }

  public List<TbDatos> obtenerTodosLosDatos() {
    return tbDatosDAO.obtenerTodos();
  }

  public void actualizarDatos(TbDatos datos) {
    tbDatosDAO.actualizar(datos);
  }

  public void eliminarDatos(int codigo) {
    tbDatosDAO.eliminar(codigo);
  }
}
