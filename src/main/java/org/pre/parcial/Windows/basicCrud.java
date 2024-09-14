package org.pre.parcial.Windows;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class basicCrud {
  public JPanel MainBasicCrudPanel;
  private JTextField SearchParam;
  private JButton btnSearch;
  private JTextField textField1;
  private JTextField textField2;
  private JTextField textField3;
  private JTextField textField4;
  private JButton button1;
  private JButton button2;
  private JButton button3;
  private JButton button4;
  private JTable Table;
  public basicCrud(){
    String[] columnNames = {"Código", "Nombre", "Apellido", "Departamento", "Fecha de Nacimiento"};

    Object[][] data = {
            {1, "Juan", "Pérez", "Ventas", "1985-05-20"},
            {2, "Ana", "Gómez", "Marketing", "1990-09-15"},
            {3, "Luis", "Martínez", "IT", "1982-12-01"}
    };
    DefaultTableModel model = new DefaultTableModel(data,columnNames);

    Table = new JTable(model);


  }

  public JPanel CreatePanel(){
    return MainBasicCrudPanel;
  }
}
