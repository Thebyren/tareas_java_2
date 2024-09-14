package org.pre.parcial.Windows;

import org.pre.parcial.entitys.controller.EquipoChampionsController;
import org.pre.parcial.entitys.model.EquipoChampions;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ListChampions {
  private JPanel MainListChampions;
  private JTable Table;
  private JTextField textSearch;
  private JButton buscarButton;
  private JTextField textId;
  private JTextField textCreatedDate;
  private JTextField textSponsor;
  private JTextField textCity;
  private JTextField textInsta;
  private JTextField textTwitter;
  private JTextField textFacebook;
  private JTextField textWeb;
  private JTextField textCoach;
  private JTextField textFund;
  private JTextField textStadio;
  private JTextField textNation;
  private JTextField textName;
  private JButton agregarButton;
  private JButton actualizarButton;
  private JButton eliminarButton;

  private final EquipoChampionsController equipoChampionsController;

  public ListChampions(EquipoChampionsController equipoChampionsController) {
    this.equipoChampionsController = equipoChampionsController;

    // Configurar el modelo de la tabla con columnas específicas
    String[] columnNames = {"ID", "Nombre", "País", "Ciudad", "Estadio", "Fundación", "Entrenador", "Web Oficial", "Facebook", "Twitter", "Instagram", "Patrocinador", "Creado En"};
    DefaultTableModel model = new DefaultTableModel(null, columnNames);
    Table.setModel(model);

    // Cargar los datos iniciales en la tabla
    cargarEquiposEnTabla();

    // Definir los listeners para los botones
    agregarButton.addActionListener(e -> agregarEquipo());
    actualizarButton.addActionListener(e -> actualizarEquipo());
    eliminarButton.addActionListener(e -> eliminarEquipo());
    buscarButton.addActionListener(e -> buscarEquipo());

    // Listener para cargar datos en los campos al seleccionar una fila
    Table.getSelectionModel().addListSelectionListener(e -> llenarCamposConDatosSeleccionados());
  }

  public JPanel CreatePanel() {
    return MainListChampions;
  }

  // Método para cargar equipos en la tabla
  private void cargarEquiposEnTabla() {
    List<EquipoChampions> equipos = equipoChampionsController.obtenerTodosLosEquipos();
    DefaultTableModel model = (DefaultTableModel) Table.getModel();
    model.setRowCount(0); // Limpiar tabla
    for (EquipoChampions equipo : equipos) {
      model.addRow(new Object[]{
              equipo.getIdEquipo(),
              equipo.getNombre(),
              equipo.getPais(),
              equipo.getCiudad(),
              equipo.getEstadio(),
              equipo.getFundacion(),
              equipo.getEntrenador(),
              equipo.getWebOficial(),
              equipo.getFacebook(),
              equipo.getTwitter(),
              equipo.getInstagram(),
              equipo.getPatrocinadorPrincipal(),
              equipo.getCreadoEn()
      });
    }
  }

  // Método para agregar un nuevo equipo
  private void agregarEquipo() {
    try {
      String nombre = textName.getText();
      String pais = textNation.getText();
      String ciudad = textCity.getText();
      String estadio = textStadio.getText();
      int fundacion = Integer.parseInt(textFund.getText());
      String entrenador = textCoach.getText();
      String webOficial = textWeb.getText();
      String facebook = textFacebook.getText();
      String twitter = textTwitter.getText();
      String instagram = textInsta.getText();
      String patrocinadorPrincipal = textSponsor.getText();

      equipoChampionsController.agregarEquipo(nombre, pais, ciudad, estadio, fundacion, entrenador, webOficial, facebook, twitter, instagram, patrocinadorPrincipal);
      JOptionPane.showMessageDialog(null, "Equipo agregado exitosamente.");
      cargarEquiposEnTabla();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Error al agregar equipo: " + e.getMessage());
    }
  }

  // Método para actualizar un equipo existente
  private void actualizarEquipo() {
    try {
      int id = Integer.parseInt(textId.getText());
      String nombre = textName.getText();
      String pais = textNation.getText();
      String ciudad = textCity.getText();
      String estadio = textStadio.getText();
      int fundacion = Integer.parseInt(textFund.getText());
      String entrenador = textCoach.getText();
      String webOficial = textWeb.getText();
      String facebook = textFacebook.getText();
      String twitter = textTwitter.getText();
      String instagram = textInsta.getText();
      String patrocinadorPrincipal = textSponsor.getText();

      equipoChampionsController.actualizarEquipo(id, nombre, pais, ciudad, estadio, fundacion, entrenador, webOficial, facebook, twitter, instagram, patrocinadorPrincipal);
      JOptionPane.showMessageDialog(null, "Equipo actualizado exitosamente.");
      cargarEquiposEnTabla();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Error al actualizar equipo: " + e.getMessage());
    }
  }

  // Método para eliminar un equipo
  private void eliminarEquipo() {
    try {
      int id = Integer.parseInt(textId.getText());
      equipoChampionsController.eliminarEquipo(id);
      JOptionPane.showMessageDialog(null, "Equipo eliminado exitosamente.");
      cargarEquiposEnTabla();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Error al eliminar equipo: " + e.getMessage());
    }
  }

  // Método para buscar un equipo por nombre o ID
  private void buscarEquipo() {
    try {
      String criterio = textSearch.getText();
      if (criterio.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Por favor ingresa un término de búsqueda.");
        return;
      }

      // Suponiendo que puedes buscar por nombre o por ID (número)
      List<EquipoChampions> equipos = equipoChampionsController.obtenerTodosLosEquipos();  // Obtener todos para buscar

      DefaultTableModel model = (DefaultTableModel) Table.getModel();
      model.setRowCount(0); // Limpiar tabla

      for (EquipoChampions equipo : equipos) {
        if (equipo.getNombre().contains(criterio) || String.valueOf(equipo.getIdEquipo()).equals(criterio)) {
          textId.setText(String.valueOf(equipo.getIdEquipo()));
          textName.setText( equipo.getNombre());
          textNation.setText(equipo.getPais());
          textCity.setText(equipo.getCiudad());
          textStadio.setText(equipo.getEstadio());
          textFund.setText(String.valueOf(equipo.getFundacion()));
          textCoach.setText(equipo.getEntrenador());
          textWeb.setText(equipo.getWebOficial());
          textFacebook.setText(equipo.getFacebook());
          textTwitter.setText(equipo.getTwitter());
          textInsta.setText(equipo.getInstagram());
          textSponsor.setText(equipo.getPatrocinadorPrincipal());
          textCreatedDate.setText(String.valueOf(equipo.getCreadoEn()));
          model.addRow(new Object[]{
                  equipo.getIdEquipo(),
                  equipo.getNombre(),
                  equipo.getPais(),
                  equipo.getCiudad(),
                  equipo.getEstadio(),
                  equipo.getFundacion(),
                  equipo.getEntrenador(),
                  equipo.getWebOficial(),
                  equipo.getFacebook(),
                  equipo.getTwitter(),
                  equipo.getInstagram(),
                  equipo.getPatrocinadorPrincipal(),
                  equipo.getCreadoEn()
          });
        }
      }

      if (model.getRowCount() == 0) {
        JOptionPane.showMessageDialog(null, "No se encontraron equipos.");
      }
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Error al buscar equipo: " + e.getMessage());
    }
  }

  // Método para llenar los campos de texto cuando se selecciona una fila en la tabla
  private void llenarCamposConDatosSeleccionados() {
    int selectedRow = Table.getSelectedRow();
    if (selectedRow >= 0) {
      textId.setText(Table.getValueAt(selectedRow, 0).toString());
      textName.setText(Table.getValueAt(selectedRow, 1).toString());
      textNation.setText(Table.getValueAt(selectedRow, 2).toString());
      textCity.setText(Table.getValueAt(selectedRow, 3).toString());
      textStadio.setText(Table.getValueAt(selectedRow, 4).toString());
      textFund.setText(Table.getValueAt(selectedRow, 5).toString());
      textCoach.setText(Table.getValueAt(selectedRow, 6).toString());
      textWeb.setText(Table.getValueAt(selectedRow, 7).toString());
      textFacebook.setText(Table.getValueAt(selectedRow, 8).toString());
      textTwitter.setText(Table.getValueAt(selectedRow, 9).toString());
      textInsta.setText(Table.getValueAt(selectedRow, 10).toString());
      textSponsor.setText(Table.getValueAt(selectedRow, 11).toString());
      textCreatedDate.setText(Table.getValueAt(selectedRow, 12).toString());
    }
  }
}
