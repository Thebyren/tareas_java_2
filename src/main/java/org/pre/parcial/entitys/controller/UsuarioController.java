package org.pre.parcial.entitys.controller;

import org.pre.parcial.entitys.model.Usuario;
import org.pre.parcial.entitys.service.UsuarioService;

import java.util.List;

public class UsuarioController {
  public UsuarioService usuarioService;

  public UsuarioController(UsuarioService usuarioService) {
    this.usuarioService = usuarioService;
  }

  public void agregarUsuario(String carne, String nombre, String correo, String seccion, long telegramId, String activo) {
    Usuario usuario = new Usuario();
    usuario.setCarne(carne);
    usuario.setNombre(nombre);
    usuario.setCorreo(correo);
    usuario.setSeccion(seccion);
    usuario.setTelegramId(telegramId);
    usuario.setActivo(activo);

    usuarioService.agregarUsuario(usuario);
  }

  public Usuario obtenerUsuarioPorId(int idUsuario) {
    return usuarioService.obtenerUsuarioPorId(idUsuario);
  }

  public List<Usuario> obtenerTodosLosUsuarios() {
    return usuarioService.obtenerTodosLosUsuarios();
  }

  public void actualizarUsuario(int idUsuario, String carne, String nombre, String correo, String seccion, long telegramId, String activo) {
    Usuario usuario = usuarioService.obtenerUsuarioPorId(idUsuario);
    if (usuario != null) {
      usuario.setCarne(carne);
      usuario.setNombre(nombre);
      usuario.setCorreo(correo);
      usuario.setSeccion(seccion);
      usuario.setTelegramId(telegramId);
      usuario.setActivo(activo);

      usuarioService.actualizarUsuario(usuario);
    }
  }

  public void eliminarUsuario(int idUsuario) {
    usuarioService.eliminarUsuario(idUsuario);
  }
  public boolean correoDuplicado(String correo) {
    return usuarioService.obtenerUsuarioPorCorreo(correo) != null;
  }
  // Método en UsuarioController para buscar usuarios por criterio
  public List<Usuario> buscarUsuarios(String criterio) {
    return usuarioService.buscarUsuarios(criterio);
  }

}
