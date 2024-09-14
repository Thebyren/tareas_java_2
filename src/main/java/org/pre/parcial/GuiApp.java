package org.pre.parcial;

//windows
import org.pre.parcial.Windows.basicCrud;
import org.pre.parcial.Windows.ListChampions;
import org.pre.parcial.Windows.verifyMails;


//swing
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Map;

public class GuiApp {
  private JPanel MainPanel;
  public static JFrame frame;
  private JButton btnWindow1;
  private JButton btnWindow2;
  private JButton btnWindow3;
  private static final Map<String, JPanel> WindowsList = Map.of(
          "basic crud",new basicCrud().CreatePanel(),
          "Verificacion de correos", new verifyMails().CreatePanel(),
          "Catalogo Champions", new ListChampions().CreatePanel()
  );

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
