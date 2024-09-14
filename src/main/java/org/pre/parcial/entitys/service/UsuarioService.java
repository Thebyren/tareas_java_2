package org.pre.parcial.entitys.service;


import org.pre.parcial.entitys.dao.UsuarioDAO;
import org.pre.parcial.entitys.model.Usuario;

import java.util.List;

public class UsuarioService {
  private UsuarioDAO usuarioDAO;

  public UsuarioService(UsuarioDAO usuarioDAO) {
    this.usuarioDAO = usuarioDAO;
  }

  public void agregarUsuario(Usuario usuario) {
    usuarioDAO.agregar(usuario);
  }

  public Usuario obtenerUsuarioPorId(int idUsuario) {
    return usuarioDAO.obtenerPorId(idUsuario);
  }

  public List<Usuario> obtenerTodosLosUsuarios() {
    return usuarioDAO.obtenerTodos();
  }

  public void actualizarUsuario(Usuario usuario) {
    usuarioDAO.actualizar(usuario);
  }

  public void eliminarUsuario(int idUsuario) {
    usuarioDAO.eliminar(idUsuario);
  }
  public Usuario obtenerUsuarioPorCorreo(String correo) {
    return usuarioDAO.obtenerUsuarioPorCorreo(correo); // Asume que ya existe en DAO
  }
  // Método en UsuarioService para buscar usuarios por criterio (nombre o correo)
  public List<Usuario> buscarUsuarios(String criterio) {
    return usuarioDAO.buscarUsuarios(criterio);
  }

}
