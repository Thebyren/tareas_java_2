package org.pre.parcial.entitys.dao;

import org.pre.parcial.entitys.model.Usuario;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {
  private Connection connection;

  public UsuarioDAOImpl(Connection connection) {
    this.connection = connection;
  }

  @Override
  public void agregar(Usuario usuario) {
    String sql = "INSERT INTO tb_usuarios (carne, nombre, correo, seccion, telegramid, activo) VALUES (?, ?, ?, ?, ?, ?)";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
      statement.setString(1, usuario.getCarne());
      statement.setString(2, usuario.getNombre());
      statement.setString(3, usuario.getCorreo());
      statement.setString(4, usuario.getSeccion());
      statement.setLong(5, usuario.getTelegramId());
      statement.setString(6, Boolean.toString(usuario.getActivo()));
      statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Usuario obtenerPorId(int idUsuario) {
    String sql = "SELECT * FROM tb_usuarios WHERE idusuario = ?";
    Usuario usuario = null;
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
      statement.setInt(1, idUsuario);
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next()) {
        usuario = new Usuario();
        usuario.setIdUsuario(resultSet.getInt("idusuario"));
        usuario.setCarne(resultSet.getString("carne"));
        usuario.setNombre(resultSet.getString("nombre"));
        usuario.setCorreo(resultSet.getString("correo"));
        usuario.setSeccion(resultSet.getString("seccion"));
        usuario.setTelegramId(resultSet.getLong("telegramid"));
        usuario.setActivo(resultSet.getString("activo"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return usuario;
  }

  @Override
  public List<Usuario> obtenerTodos() {
    String sql = "SELECT * FROM tb_usuarios";
    List<Usuario> usuarios = new ArrayList<>();
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(resultSet.getInt("idusuario"));
        usuario.setCarne(resultSet.getString("carne"));
        usuario.setNombre(resultSet.getString("nombre"));
        usuario.setCorreo(resultSet.getString("correo"));
        usuario.setSeccion(resultSet.getString("seccion"));
        usuario.setTelegramId(resultSet.getLong("telegramid"));
        usuario.setActivo(resultSet.getString("activo"));
        usuarios.add(usuario);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return usuarios;
  }

  @Override
  public void actualizar(Usuario usuario) {
    String sql = "UPDATE tb_usuarios SET carne = ?, nombre = ?, correo = ?, seccion = ?, telegramid = ?, activo = ? WHERE idusuario = ?";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
      statement.setString(1, usuario.getCarne());
      statement.setString(2, usuario.getNombre());
      statement.setString(3, usuario.getCorreo());
      statement.setString(4, usuario.getSeccion());
      statement.setLong(5, usuario.getTelegramId());
      statement.setString(6, String.valueOf(Boolean.valueOf(usuario.getActivo())));
      statement.setInt(7, usuario.getIdUsuario());
      statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void eliminar(int idUsuario) {
    String sql = "DELETE FROM tb_usuarios WHERE idusuario = ?";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
      statement.setInt(1, idUsuario);
      statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  // Método en UsuarioDAOImpl para obtener un usuario por correo
  @Override
  public Usuario obtenerUsuarioPorCorreo(String correo) {
    String query = "SELECT * FROM tb_usuarios WHERE correo = ?";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
      statement.setString(1, correo);
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next()) {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(resultSet.getInt("idusuario"));
        usuario.setCarne(resultSet.getString("carne"));
        usuario.setNombre(resultSet.getString("nombre"));
        usuario.setCorreo(resultSet.getString("correo"));
        usuario.setSeccion(resultSet.getString("seccion"));
        usuario.setTelegramId(resultSet.getLong("telegramid"));
        usuario.setActivo(resultSet.getString("activo"));
        return usuario;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  // Método en UsuarioDAOImpl para buscar usuarios por nombre o correo
  @Override
  public List<Usuario> buscarUsuarios(String criterio) {
    List<Usuario> usuarios = new ArrayList<>();
    String query = "SELECT * FROM tb_usuarios WHERE nombre LIKE ? OR correo LIKE ?";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
      statement.setString(1, "%" + criterio + "%");
      statement.setString(2, "%" + criterio + "%");
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(resultSet.getInt("idusuario"));
        usuario.setCarne(resultSet.getString("carne"));
        usuario.setNombre(resultSet.getString("nombre"));
        usuario.setCorreo(resultSet.getString("correo"));
        usuario.setSeccion(resultSet.getString("seccion"));
        usuario.setTelegramId(resultSet.getLong("telegramid"));
        usuario.setActivo(resultSet.getString("activo"));
        usuarios.add(usuario);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return usuarios;
  }

}
