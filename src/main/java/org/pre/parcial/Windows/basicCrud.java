package org.pre.parcial.Windows;

import org.pre.parcial.entitys.controller.TbDatosController;
import org.pre.parcial.entitys.model.TbDatos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class basicCrud {
  public JPanel MainBasicCrudPanel;
  private JTextField SearchParam;
  private JButton btnSearch;
  private JTextField textName;
  private JTextField textDateBorn;
  private JTextField textDepartament;
  private JTextField textLastname;
  private JButton actualizarButton;
  private JButton eliminarButton;
  private JButton ingresarButton;
  private JTable Table;
  private JTextField textId;

  public basicCrud(TbDatosController controller) {
    initUI();
  }

  private void initUI() {
    // Listener para el botón de Ingresar
    assert ingresarButton != null;
    ingresarButton.addActionListener(e -> ingresarDatos());

    // Listener para el botón de Eliminar
    assert eliminarButton != null;
    eliminarButton.addActionListener(e -> eliminarDatos());

    // Listener para el botón de Actualizar
    assert actualizarButton != null;
    actualizarButton.addActionListener(e -> actualizarDatos());

    // Listener para el botón de Buscar
    assert btnSearch != null;
    btnSearch.addActionListener(e -> buscarDatos());

    // Inicializar la tabla con columnas
    String[] columnNames = {"Código", "Nombre", "Apellido", "Departamento", "Fecha de Nacimiento"};
    DefaultTableModel model = new DefaultTableModel(null, columnNames);
    assert Table != null;
    Table.setModel(model);

    // Cargar los datos en la tabla
    cargarDatosEnTabla();
  }
  private void limpiarDatos(){
    textId.setText("");
    textName.setText("");
      textDateBorn.setText("");
      textDepartament.setText("");
      textLastname.setText("");
  }
  private void cargarDatosEnTabla() {
    // Obtener todos los datos
    List<TbDatos> datosList = TbDatosController.obtenerTodosLosDatos();

    // Limpiar la tabla
    DefaultTableModel model = (DefaultTableModel) Table.getModel();
    model.setRowCount(0);

    // Llenar la tabla con los datos recuperados
    for (TbDatos datos : datosList) {
      model.addRow(new Object[]{
              datos.getCodigo(),
              datos.getNombre(),
              datos.getApellido(),
              datos.getDepartamento(),
              datos.getFechaNacimiento()
      });
    }
  }

  private void ingresarDatos() {
    try {
      TbDatos datos = new TbDatos();
      datos.setNombre(textName.getText());
      datos.setApellido(textLastname.getText());
      datos.setDepartamento(textDepartament.getText());
      datos.setFechaNacimiento(java.sql.Date.valueOf(textDateBorn.getText())); // Validar formato de fecha
      TbDatosController.crearDatos(datos);
      JOptionPane.showMessageDialog(null, "Datos ingresados correctamente.");
      cargarDatosEnTabla(); // Actualizar la tabla después de ingresar datos
      limpiarDatos();
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(null, "Error al ingresar datos: " + ex.getMessage());
    }
  }

  private void eliminarDatos() {
    try {
      int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código del usuario a eliminar"));
      TbDatosController.eliminarDatos(codigo);
      JOptionPane.showMessageDialog(null, "Datos eliminados correctamente.");
      cargarDatosEnTabla(); // Actualizar la tabla después de eliminar datos
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(null, "Error al eliminar datos: " + ex.getMessage());
    }
  }

  private void actualizarDatos() {
    try {
      int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código del usuario a actualizar"));
      TbDatos datos = TbDatosController.obtenerDatosPorId(codigo);

      if (datos != null) {
        datos.setNombre(textName.getText());
        datos.setApellido(textLastname.getText());
        datos.setDepartamento(textDepartament.getText());
        datos.setFechaNacimiento(java.sql.Date.valueOf(textDateBorn.getText())); // Validar formato de fecha

        TbDatosController.actualizarDatos(datos);
        JOptionPane.showMessageDialog(null, "Datos actualizados correctamente.");
        cargarDatosEnTabla(); // Actualizar la tabla después de actualizar datos
        limpiarDatos();
      } else {
        JOptionPane.showMessageDialog(null, "No se encontraron datos con ese código.");
        limpiarDatos();
      }
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(null, "Error al actualizar datos: " + ex.getMessage());
      limpiarDatos();
    }
  }

  private void buscarDatos() {
    try {
      int codigo = Integer.parseInt(SearchParam.getText());
      TbDatos datos = TbDatosController.obtenerDatosPorId(codigo); // Asegúrate de usar el método del controlador

      if (datos != null) {
        // Rellenar los campos de texto con los datos encontrados
        textId.setText(String.valueOf(datos.getCodigo()));
        textName.setText(datos.getNombre());
        textLastname.setText(datos.getApellido());
        textDepartament.setText(datos.getDepartamento());
        textDateBorn.setText(datos.getFechaNacimiento().toString()); // Asegúrate de que el formato sea correcto
      } else {
        JOptionPane.showMessageDialog(null, "No se encontraron datos.");
        cargarDatosEnTabla();
      }
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(null, "Error al buscar datos: " + ex.getMessage());
    }
  }


  public JPanel CreatePanel() {
    return MainBasicCrudPanel;
  }
}
