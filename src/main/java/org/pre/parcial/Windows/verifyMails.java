package org.pre.parcial.Windows;

import org.pre.parcial.entitys.controller.UsuarioController;
import org.pre.parcial.entitys.model.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Objects;

public class verifyMails {
  private JPanel MainVerifyMails;
  private JTable TableUsers;
  private JTextField textTelegramId;
  private JTextField textSection;
  private JTextField textMail;
  private JTextField textName;
  private JTextField textCarnet;
  private JTextField textId; // Este parece un campo que no se usa, puedes eliminarlo si no es necesario.
  private JButton insertBtn;
  private JButton updateBtn;
  private JButton deleteBtn;
  private JRadioButton rtBtnActive;
  private JButton searchBtn;
  private JTextField textSearch;

  // Añadimos el controlador de usuarios
  private final UsuarioController usuarioController;

  public verifyMails(UsuarioController usuarioController) {
    this.usuarioController = usuarioController;

    // Configurar el modelo de la tabla con columnas específicas
    String[] columnNames = {"ID", "Carnet", "Nombre", "Correo", "Sección", "Telegram ID", "Activo"};
    DefaultTableModel model = new DefaultTableModel(null, columnNames);
    TableUsers.setModel(model);

    // Cargar los datos iniciales en la tabla
    cargarUsuariosEnTabla();

    // Definir los listeners para los botones
    insertBtn.addActionListener(e -> agregarUsuario());
    updateBtn.addActionListener(e -> actualizarUsuario());
    deleteBtn.addActionListener(e -> eliminarUsuario());
    searchBtn.addActionListener(e -> buscarUsuarios());

    // Listener para cargar datos en los campos al seleccionar una fila
    TableUsers.getSelectionModel().addListSelectionListener(e -> llenarCamposConDatosSeleccionados());
  }

  // Método para agregar un usuario con validación
  private void agregarUsuario() {
    try {
      String carnet = textCarnet.getText();
      String nombre = textName.getText();
      String correo = textMail.getText();
      String seccion = textSection.getText();
      long telegramId = Long.parseLong(textTelegramId.getText());
      String activo = rtBtnActive.isSelected() ? "Y" : "N";

      // Validar formato de correo
      if (validarFormatoCorreo(correo)) {
        JOptionPane.showMessageDialog(null, "El formato del correo es inválido.");
        return;
      }

      // Verificar si el correo ya existe
      if (usuarioController.correoDuplicado(correo)) {
        JOptionPane.showMessageDialog(null, "El correo ya existe en la base de datos.");
        return;
      }

      // Si todo es válido, agregar el usuario
      usuarioController.agregarUsuario(carnet, nombre, correo, seccion, telegramId, activo);

      // Recargar la tabla
      cargarUsuariosEnTabla();
      limpiarCampos();
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(null, "Error al agregar usuario: " + ex.getMessage());
    }
  }

  // Método para actualizar un usuario con validación
  private void actualizarUsuario() {
    try {
      int selectedRow = TableUsers.getSelectedRow();
      if (selectedRow >= 0) {
        int idUsuario = (int) TableUsers.getValueAt(selectedRow, 0); // Obtener el ID de la fila seleccionada
        String carnet = textCarnet.getText();
        String nombre = textName.getText();
        String correo = textMail.getText();
        String seccion = textSection.getText();
        long telegramId = Long.parseLong(textTelegramId.getText());
        String activo = rtBtnActive.isSelected() ? "Y" : "N";

        // Validar formato de correo
        if (validarFormatoCorreo(correo)) {
          JOptionPane.showMessageDialog(null, "El formato del correo es inválido.");
          return;
        }

        // Verificar si el correo ya existe en otro usuario
        Usuario usuarioConMismoCorreo = usuarioController.usuarioService.obtenerUsuarioPorCorreo(correo);
        if (usuarioConMismoCorreo != null && !Objects.equals(usuarioConMismoCorreo.getIdUsuario(), String.valueOf(idUsuario))) {
          JOptionPane.showMessageDialog(null, "El correo ya está en uso por otro usuario.");
          return;
        }

        // Si todo es válido, actualizar el usuario
        usuarioController.actualizarUsuario(idUsuario, carnet, nombre, correo, seccion, telegramId, activo);

        // Recargar la tabla
        cargarUsuariosEnTabla();
        limpiarCampos();
      } else {
        JOptionPane.showMessageDialog(null, "Selecciona un usuario para actualizar.");
      }
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(null, "Error al actualizar usuario: " + ex.getMessage());
    }
  }


  // Método para eliminar un usuario
  private void eliminarUsuario() {
    try {
      int selectedRow = TableUsers.getSelectedRow();
      if (selectedRow >= 0) {
        int idUsuario = (int) TableUsers.getValueAt(selectedRow, 0); // Obtener el ID de la fila seleccionada

        // Usar el controlador para eliminar el usuario
        usuarioController.eliminarUsuario(idUsuario);

        // Recargar la tabla
        cargarUsuariosEnTabla();
        limpiarCampos();
      } else {
        JOptionPane.showMessageDialog(null, "Selecciona un usuario para eliminar.");
      }
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(null, "Error al eliminar usuario: " + ex.getMessage());
    }
  }

  // Método para cargar usuarios en la tabla
  private void cargarUsuariosEnTabla() {
    List<Usuario> usuarios = usuarioController.obtenerTodosLosUsuarios();
    DefaultTableModel model = (DefaultTableModel) TableUsers.getModel();
    model.setRowCount(0); // Limpiar tabla
    for (Usuario usuario : usuarios) {
      model.addRow(new Object[]{
              usuario.getIdUsuario(),
              usuario.getCarne(),
              usuario.getNombre(),
              usuario.getCorreo(),
              usuario.getSeccion(),
              usuario.getTelegramId(),
              usuario.getActivo()
      });
    }
  }

  // Método para llenar los campos con los datos de la fila seleccionada en la tabla
  private void llenarCamposConDatosSeleccionados() {
    int selectedRow = TableUsers.getSelectedRow();
    if (selectedRow >= 0) {
      textCarnet.setText(TableUsers.getValueAt(selectedRow, 1).toString());
      textName.setText(TableUsers.getValueAt(selectedRow, 2).toString());
      textMail.setText(TableUsers.getValueAt(selectedRow, 3).toString());
      textSection.setText(TableUsers.getValueAt(selectedRow, 4).toString());
      textTelegramId.setText(TableUsers.getValueAt(selectedRow, 5).toString());
      rtBtnActive.setSelected(TableUsers.getValueAt(selectedRow, 6).toString().equals("Y"));
    }
  }

  // Método para limpiar los campos después de agregar, actualizar o eliminar
  private void limpiarCampos() {
    textCarnet.setText("");
    textName.setText("");
    textMail.setText("");
    textSection.setText("");
    textTelegramId.setText("");
    rtBtnActive.setSelected(false);
  }
  // Método para validar el formato del correo
  private boolean validarFormatoCorreo(String correo) {
    String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    return !correo.matches(emailRegex);
  }
  private void buscarUsuarios() {
    try {
      String criterio = textSearch.getText();  // Obtener el texto de búsqueda

      if (criterio.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Por favor ingresa un término de búsqueda.");
        return;
      }

      // Obtener la lista de usuarios que coinciden con el criterio
      List<Usuario> usuarios = usuarioController.buscarUsuarios(criterio);

      if (usuarios.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No se encontraron usuarios.");
      }

      // Actualizar la tabla con los resultados de la búsqueda
      DefaultTableModel model = (DefaultTableModel) TableUsers.getModel();
      model.setRowCount(0); // Limpiar tabla
      for (Usuario usuario : usuarios) {
                textId.setText( String.valueOf(usuario.getIdUsuario()));
                textCarnet.setText(usuario.getCarne());
                textName.setText(usuario.getNombre());
                textMail.setText(usuario.getCorreo());
                textSection.setText(usuario.getSeccion());
                textTelegramId.setText(String.valueOf(usuario.getTelegramId()));
                rtBtnActive.setSelected(usuario.getActivo());
        model.addRow(new Object[]{
                usuario.getIdUsuario(),
                usuario.getCarne(),
                usuario.getNombre(),
                usuario.getCorreo(),
                usuario.getSeccion(),
                usuario.getTelegramId(),
                usuario.getActivo()
        });
      }
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(null, "Error al buscar usuarios: " + ex.getMessage());
    }
  }

  public JPanel CreatePanel(){
    return MainVerifyMails;
  }
}
