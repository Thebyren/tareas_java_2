package org.pre.parcial.entitys.dao;

import org.pre.parcial.entitys.model.TbDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TbDatosDAOImpl implements TbDatosDAO {

  private Connection connection;

  public TbDatosDAOImpl(Connection connection) {
    this.connection = connection;
  }

  @Override
  public void insertar(TbDatos datos) {
    String query = "INSERT INTO tb_datos (nombre, apellido, departamento, fecha_nacimiento) VALUES (?, ?, ?, ?)";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setString(1, datos.getNombre());
      stmt.setString(2, datos.getApellido());
      stmt.setString(3, datos.getDepartamento());
      stmt.setDate(4, new java.sql.Date(datos.getFechaNacimiento().getTime()));
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public TbDatos obtenerPorId(int codigo) {
    String query = "SELECT * FROM tb_datos WHERE codigo = ?";
    TbDatos datos = null;
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setInt(1, codigo);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        datos = new TbDatos();
        datos.setCodigo(rs.getInt("codigo"));
        datos.setNombre(rs.getString("nombre"));
        datos.setApellido(rs.getString("apellido"));
        datos.setDepartamento(rs.getString("departamento"));
        datos.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return datos;
  }

  @Override
  public List<TbDatos> obtenerTodos() {
    String query = "SELECT * FROM tb_datos";
    List<TbDatos> lista = new ArrayList<>();
    try (Statement stmt = connection.createStatement()) {
      ResultSet rs = stmt.executeQuery(query);
      while (rs.next()) {
        TbDatos datos = new TbDatos();
        datos.setCodigo(rs.getInt("codigo"));
        datos.setNombre(rs.getString("nombre"));
        datos.setApellido(rs.getString("apellido"));
        datos.setDepartamento(rs.getString("departamento"));
        datos.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
        lista.add(datos);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return lista;
  }

  @Override
  public void actualizar(TbDatos datos) {
    String query = "UPDATE tb_datos SET nombre = ?, apellido = ?, departamento = ?, fecha_nacimiento = ? WHERE codigo = ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setString(1, datos.getNombre());
      stmt.setString(2, datos.getApellido());
      stmt.setString(3, datos.getDepartamento());
      stmt.setDate(4, new java.sql.Date(datos.getFechaNacimiento().getTime()));
      stmt.setInt(5, datos.getCodigo());
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void eliminar(int codigo) {
    String query = "DELETE FROM tb_datos WHERE codigo = ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setInt(1, codigo);
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}

