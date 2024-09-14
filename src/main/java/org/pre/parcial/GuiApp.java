package org.pre.parcial;

//windows
import org.pre.parcial.Windows.basicCrud;
import org.pre.parcial.Windows.ListChampions;
import org.pre.parcial.Windows.verifyMails;
import org.pre.parcial.db.DatabaseConnection;
import org.pre.parcial.entitys.controller.EquipoChampionsController;
import org.pre.parcial.entitys.controller.TbDatosController;
import org.pre.parcial.entitys.controller.UsuarioController;
import org.pre.parcial.entitys.dao.EquipoChampionsDAOImpl;
import org.pre.parcial.entitys.dao.TbDatosDAOImpl;
import org.pre.parcial.entitys.dao.UsuarioDAOImpl;
import org.pre.parcial.entitys.service.EquipoChampionsService;
import org.pre.parcial.entitys.service.TbDatosService;
import org.pre.parcial.entitys.service.UsuarioService;


//swing
import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Map;

public class GuiApp {
  private JPanel MainPanel;
  public static JFrame frame;
  private JButton btnWindow1;
  private JButton btnWindow2;
  private JButton btnWindow3;

  private static final Map<String, JPanel> WindowsList;

  static {
    try {
      WindowsList = Map.of(
              "basic crud",new basicCrud(new TbDatosController(new TbDatosService(new TbDatosDAOImpl(DatabaseConnection.getConnection())))).CreatePanel(),
              "Verificacion de correos", new verifyMails(new UsuarioController(new UsuarioService(new UsuarioDAOImpl(DatabaseConnection.getConnection())))).CreatePanel(),
              "Catalogo Champions", new ListChampions(new EquipoChampionsController(new EquipoChampionsService( new EquipoChampionsDAOImpl(DatabaseConnection.getConnection())))).CreatePanel()
      );
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public GuiApp() {
    ActionListener listener = e -> {
      if(WindowsList.containsKey(e.getActionCommand())){
      final JDialog emergent = new JDialog(frame, e.getActionCommand(), true);
        emergent.setContentPane(WindowsList.get(e.getActionCommand()));
        emergent.pack();
        emergent.setVisible(true);
      }
    };
    btnWindow1.addActionListener(listener);
    btnWindow2.addActionListener(listener);
    btnWindow3.addActionListener(listener);
  }

  public static void main(String[] args) {
    frame = new JFrame("GuiApp");
    frame.setContentPane(new GuiApp().MainPanel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);

  }
}
