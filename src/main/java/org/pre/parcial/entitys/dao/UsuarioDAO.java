package org.pre.parcial.entitys.dao;

import org.pre.parcial.entitys.model.Usuario;

import java.util.List;

public interface UsuarioDAO {
  void agregar(Usuario usuario);
  Usuario obtenerPorId(int idUsuario);
  List<Usuario> obtenerTodos();
  void actualizar(Usuario usuario);
  void eliminar(int idUsuario);
  Usuario obtenerUsuarioPorCorreo(String correo);
  List<Usuario> buscarUsuarios(String criterio);
}
