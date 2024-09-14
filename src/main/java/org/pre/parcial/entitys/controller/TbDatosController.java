package org.pre.parcial.entitys.controller;
import org.pre.parcial.entitys.model.TbDatos;
import org.pre.parcial.entitys.service.TbDatosService;

import java.util.List;

public class TbDatosController {
  private final TbDatosService tbDatosService;

  public TbDatosController(TbDatosService tbDatosService) {
    this.tbDatosService = tbDatosService;
  }

  public void crearDatos(TbDatos datos) {
    tbDatosService.agregarDatos(datos);
  }

  public TbDatos obtenerDatosPorId(int codigo) {
    return tbDatosService.obtenerDatosPorId(codigo);
  }

  public List<TbDatos> obtenerTodosLosDatos() {
    return tbDatosService.obtenerTodosLosDatos();
  }

  public void actualizarDatos(TbDatos datos) {
    tbDatosService.actualizarDatos(datos);
  }

  public void eliminarDatos(int codigo) {
    tbDatosService.eliminarDatos(codigo);
  }
}

