package org.pre.parcial.entitys.controller;

import org.pre.parcial.entitys.model.EquipoChampions;
import org.pre.parcial.entitys.service.EquipoChampionsService;

import java.util.List;

public class EquipoChampionsController {
  private final EquipoChampionsService equipoChampionsService;

  public EquipoChampionsController(EquipoChampionsService equipoChampionsService) {
    this.equipoChampionsService = equipoChampionsService;
  }

  public void agregarEquipo(String nombre, String pais, String ciudad, String estadio, int fundacion, String entrenador, String webOficial, String facebook, String twitter, String instagram, String patrocinadorPrincipal) {
    EquipoChampions equipo = new EquipoChampions();
    equipo.setNombre(nombre);
    equipo.setPais(pais);
    equipo.setCiudad(ciudad);
    equipo.setEstadio(estadio);
    equipo.setFundacion(fundacion);
    equipo.setEntrenador(entrenador);
    equipo.setWebOficial(webOficial);
    equipo.setFacebook(facebook);
    equipo.setTwitter(twitter);
    equipo.setInstagram(instagram);
    equipo.setPatrocinadorPrincipal(patrocinadorPrincipal);

    equipoChampionsService.agregarEquipo(equipo);
  }

  public EquipoChampions obtenerEquipoPorId(int idEquipo) {
    return equipoChampionsService.obtenerEquipoPorId(idEquipo);
  }

  public List<EquipoChampions> obtenerTodosLosEquipos() {
    return equipoChampionsService.obtenerTodosLosEquipos();
  }

  public void actualizarEquipo(int idEquipo, String nombre, String pais, String ciudad, String estadio, int fundacion, String entrenador, String webOficial, String facebook, String twitter, String instagram, String patrocinadorPrincipal) {
    EquipoChampions equipo = equipoChampionsService.obtenerEquipoPorId(idEquipo);
    if (equipo != null) {
      equipo.setNombre(nombre);
      equipo.setPais(pais);
      equipo.setCiudad(ciudad);
      equipo.setEstadio(estadio);
      equipo.setFundacion(fundacion);
      equipo.setEntrenador(entrenador);
      equipo.setWebOficial(webOficial);
      equipo.setFacebook(facebook);
      equipo.setTwitter(twitter);
      equipo.setInstagram(instagram);
      equipo.setPatrocinadorPrincipal(patrocinadorPrincipal);

      equipoChampionsService.actualizarEquipo(equipo);
    }
  }

  public void eliminarEquipo(int idEquipo) {
    equipoChampionsService.eliminarEquipo(idEquipo);
  }
}
