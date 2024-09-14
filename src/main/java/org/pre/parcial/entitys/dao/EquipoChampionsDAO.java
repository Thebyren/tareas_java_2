package org.pre.parcial.entitys.dao;
import java.util.List;
import org.pre.parcial.entitys.model.EquipoChampions;

public interface EquipoChampionsDAO {
  void insertar(EquipoChampions equipo);
  EquipoChampions obtenerPorId(int idEquipo);
  List<EquipoChampions> obtenerTodos();
  void actualizar(EquipoChampions equipo);
  void eliminar(int idEquipo);
}
