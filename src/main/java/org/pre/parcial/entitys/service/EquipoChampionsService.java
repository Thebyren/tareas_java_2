package org.pre.parcial.entitys.service;
import org.pre.parcial.entitys.dao.EquipoChampionsDAO;
import org.pre.parcial.entitys.model.EquipoChampions;

import java.util.List;


public class EquipoChampionsService {
  private final EquipoChampionsDAO equipoChampionsDAO;

  public EquipoChampionsService(EquipoChampionsDAO equipoChampionsDAO) {
    this.equipoChampionsDAO = equipoChampionsDAO;
  }

  public void agregarEquipo(EquipoChampions equipo) {
    equipoChampionsDAO.insertar(equipo);
  }

  public EquipoChampions obtenerEquipoPorId(int idEquipo) {
    return equipoChampionsDAO.obtenerPorId(idEquipo);
  }

  public List<EquipoChampions> obtenerTodosLosEquipos() {
    return equipoChampionsDAO.obtenerTodos();
  }

  public void actualizarEquipo(EquipoChampions equipo) {
    equipoChampionsDAO.actualizar(equipo);
  }

  public void eliminarEquipo(int idEquipo) {
    equipoChampionsDAO.eliminar(idEquipo);
  }
}
