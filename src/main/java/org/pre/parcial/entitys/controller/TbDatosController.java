package org.pre.parcial.entitys.controller;
import org.pre.parcial.entitys.model.TbDatos;
import org.pre.parcial.entitys.service.TbDatosService;

import java.util.List;

public class TbDatosController {
  private static TbDatosService tbDatosService = null;

  public TbDatosController(TbDatosService tbDatosService) {
    this.tbDatosService = tbDatosService;
  }

  public static void crearDatos(TbDatos datos) {
    tbDatosService.agregarDatos(datos);
  }

  public static TbDatos obtenerDatosPorId(int codigo) {
    return tbDatosService.obtenerDatosPorId(codigo);
  }

  public static List<TbDatos> obtenerTodosLosDatos() {
    return tbDatosService.obtenerTodosLosDatos();
  }

  public static void actualizarDatos(TbDatos datos) {
    tbDatosService.actualizarDatos(datos);
  }

  public static void eliminarDatos(int codigo) {
    tbDatosService.eliminarDatos(codigo);
  }
}

