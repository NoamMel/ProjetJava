import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

public class Interface extends JPanel{

  public void paintComponent(Graphics g){

    Font font = new Font("Courier", Font.BOLD, 20);
    g.setFont(font);
    g.setColor(Color.red);
    g.drawString("Et voila !!!", 10, 20);
  }
}
