package org.pre.parcial.entitys.dao;

import org.pre.parcial.entitys.model.EquipoChampions;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipoChampionsDAOImpl implements EquipoChampionsDAO {

  private final Connection connection;

  public EquipoChampionsDAOImpl(Connection connection) {
    this.connection = connection;
  }

  @Override
  public void insertar(EquipoChampions equipo) {
    String query = "INSERT INTO equipos_champions (nombre, pais, ciudad, estadio, fundacion, entrenador, web_oficial, facebook, twitter, instagram, patrocinador_principal) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setString(1, equipo.getNombre());
      stmt.setString(2, equipo.getPais());
      stmt.setString(3, equipo.getCiudad());
      stmt.setString(4, equipo.getEstadio());
      stmt.setInt(5, equipo.getFundacion());
      stmt.setString(6, equipo.getEntrenador());
      stmt.setString(7, equipo.getWebOficial());
      stmt.setString(8, equipo.getFacebook());
      stmt.setString(9, equipo.getTwitter());
      stmt.setString(10, equipo.getInstagram());
      stmt.setString(11, equipo.getPatrocinadorPrincipal());
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public EquipoChampions obtenerPorId(int idEquipo) {
    String query = "SELECT * FROM equipos_champions WHERE id_equipo = ?";
    EquipoChampions equipo = null;
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setInt(1, idEquipo);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        equipo = new EquipoChampions();
        equipo.setIdEquipo(rs.getInt("id_equipo"));
        equipo.setNombre(rs.getString("nombre"));
        equipo.setPais(rs.getString("pais"));
        equipo.setCiudad(rs.getString("ciudad"));
        equipo.setEstadio(rs.getString("estadio"));
        equipo.setFundacion(rs.getInt("fundacion"));
        equipo.setEntrenador(rs.getString("entrenador"));
        equipo.setWebOficial(rs.getString("web_oficial"));
        equipo.setFacebook(rs.getString("facebook"));
        equipo.setTwitter(rs.getString("twitter"));
        equipo.setInstagram(rs.getString("instagram"));
        equipo.setPatrocinadorPrincipal(rs.getString("patrocinador_principal"));
        equipo.setCreadoEn(rs.getTimestamp("creado_en"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return equipo;
  }

  @Override
  public List<EquipoChampions> obtenerTodos() {
    String query = "SELECT * FROM equipos_champions";
    List<EquipoChampions> lista = new ArrayList<>();
    try (Statement stmt = connection.createStatement()) {
      ResultSet rs = stmt.executeQuery(query);
      while (rs.next()) {
        EquipoChampions equipo = new EquipoChampions();
        equipo.setIdEquipo(rs.getInt("id_equipo"));
        equipo.setNombre(rs.getString("nombre"));
        equipo.setPais(rs.getString("pais"));
        equipo.setCiudad(rs.getString("ciudad"));
        equipo.setEstadio(rs.getString("estadio"));
        equipo.setFundacion(rs.getInt("fundacion"));
        equipo.setEntrenador(rs.getString("entrenador"));
        equipo.setWebOficial(rs.getString("web_oficial"));
        equipo.setFacebook(rs.getString("facebook"));
        equipo.setTwitter(rs.getString("twitter"));
        equipo.setInstagram(rs.getString("instagram"));
        equipo.setPatrocinadorPrincipal(rs.getString("patrocinador_principal"));
        equipo.setCreadoEn(rs.getTimestamp("creado_en"));
        lista.add(equipo);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return lista;
  }

  @Override
  public void actualizar(EquipoChampions equipo) {
    String query = "UPDATE equipos_champions SET nombre = ?, pais = ?, ciudad = ?, estadio = ?, fundacion = ?, entrenador = ?, web_oficial = ?, facebook = ?, twitter = ?, instagram = ?, patrocinador_principal = ? WHERE id_equipo = ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setString(1, equipo.getNombre());
      stmt.setString(2, equipo.getPais());
      stmt.setString(3, equipo.getCiudad());
      stmt.setString(4, equipo.getEstadio());
      stmt.setInt(5, equipo.getFundacion());
      stmt.setString(6, equipo.getEntrenador());
      stmt.setString(7, equipo.getWebOficial());
      stmt.setString(8, equipo.getFacebook());
      stmt.setString(9, equipo.getTwitter());
      stmt.setString(10, equipo.getInstagram());
      stmt.setString(11, equipo.getPatrocinadorPrincipal());
      stmt.setInt(12, equipo.getIdEquipo());
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void eliminar(int idEquipo) {
    String query = "DELETE FROM equipos_champions WHERE id_equipo = ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setInt(1, idEquipo);
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
