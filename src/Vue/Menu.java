import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.*;


public class Menu extends JFrame /*implements MouseListener*/{
  private JButton bouton = new JButton("Retourner au menu");
  private JButton boutoni = new JButton("Recherche d'informations");
  private JButton boutonm = new JButton("Mise \u00e0 jour des donn\u00e9es");
  private JButton boutonr = new JButton("Reporting");
  private JPanel container = new JPanel();
  private JPanel container2 = new JPanel();

  public Menu(){
    this.setTitle("Campus - Menu");
    this.setSize(800, 600);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    container.setBackground(Color.white);
    container.setLayout(new BorderLayout());
    JPanel top = new JPanel();
    boutoni.addActionListener(new BoutoniListener());
    boutonm.addActionListener(new BoutonmListener());
    boutonr.addActionListener(new BoutonrListener());

    JLabel label = new JLabel("O\u00f9 souhaitez-vous aller ?");
    this.setVisible(true);
    this.setResizable(false);













        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.WHITE);

        label.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setText("Quelle action souhaitez-vous effectuer ?");
        label.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        boutoni.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        boutoni.setText("Recherche d'informations");

        boutonm.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        boutonm.setText("Mise \u00e0 jour des donn\u00e9es");

        boutonr.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        boutonr.setText("Reporting");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(getWidth()/2 - 102, getWidth()/2 - 102, getWidth()/2 - 102)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(label)
                    .addComponent(boutoni)
                    .addComponent(boutonm)
                    .addComponent(boutonr))
                .addContainerGap(getWidth()/2 - 102, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(label)
                .addGap(102, 102, 102)
                .addComponent(boutoni, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(boutonm, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(boutonr, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(234, Short.MAX_VALUE))
        );

        pack();
    }










  public void NextPage(){
    this.setTitle("Campus - Page suivante");
    this.setSize(800, 600);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    container2.setBackground(Color.WHITE);
    container2.setLayout(new BorderLayout());
    JPanel top2 = new JPanel();
    JPanel retour = new JPanel();
    JLabel label2 = new JLabel("affichage...");
    top2.add(label2);
    top2.setBackground(Color.WHITE);
    retour.setBackground(Color.WHITE);

    bouton.addActionListener(new BoutonListener());
    retour.add(bouton);

    container2.add(top2, BorderLayout.CENTER);
    container2.add(retour, BorderLayout.EAST);
    this.setContentPane(container2);
    this.setVisible(true);


  }

  class BoutonListener implements ActionListener{
  public void actionPerformed(ActionEvent e) {
    bouton.setEnabled(true);
    setVisible(false);
    new Menu();
  }
}

class BoutoniListener implements ActionListener{
public void actionPerformed(ActionEvent e) {
  boutoni.setEnabled(true);
  setVisible(false);
  new Recherche();  // A modifier
}
}

class BoutonmListener implements ActionListener{
public void actionPerformed(ActionEvent e) {
  boutonm.setEnabled(true);
  setVisible(false);
  new MiseAJour();  // A modifier
}
}

class BoutonrListener implements ActionListener{
public void actionPerformed(ActionEvent e) {
  boutonr.setEnabled(true);
  setVisible(false);
  new Menu();  // A modifier
}
}


  public static void main(String[] args) {

    new Menu();
  }

}
