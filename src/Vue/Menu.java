package Vue;

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
















        // JLabel jLabel1 = new javax.swing.JLabel();
        // JButton jButton1 = new javax.swing.JButton();
        // JButton jButton2 = new javax.swing.JButton();
        // JButton jButton3 = new javax.swing.JButton();

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















  // public void paint(Graphics g){
  //   g.setColor(Color.red);
  //   g.fillRect(80, 100, 150, 75);
  // }

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

    // if(jr1.isSelected()){
    //   System.out.println("11111111");
    // }
    // if(jr2.isSelected()){
    //   System.out.println("222222");
    // }
    // if(jr3.isSelected()){
    //   System.out.println("3333333");
    // }

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

  class StateListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
      // System.out.println("source : " + jr1.getText() + " - état : " + jr1.isSelected());
      // System.out.println("source : " + jr2.getText() + " - état : " + jr2.isSelected());
      // System.out.println("source : " + jr3.getText() + " - état : " + jr3.isSelected());
      // if(jr1.isSelected() || jr2.isSelected() || jr3.isSelected()){
      //   NextPage();
      // }
  }
}

// public void mouseClicked(MouseEvent event) {
//    //Inutile d'utiliser cette méthode ici
//  }
//
//  public void mouseEntered(MouseEvent event) {
//    //Nous changeons le fond de notre image pour le jaune lors du survol, avec le fichier fondBoutonHover.png
//    try {
//      img = ImageIO.read(new File("fondBoutonHover.png"));
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//  }
//
//  public void mouseExited(MouseEvent event) {
//  //Nous changeons le fond de notre image pour le vert lorsque nous quittons le bouton, avec le fichier fondBouton.png
//    try {
//      img = ImageIO.read(new File("fondBouton.png"));
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//  }
//
//  public void mousePressed(MouseEvent event) {
//    //Nous changeons le fond de notre image pour le jaune lors du clic gauche, avec le fichier fondBoutonClic.png
//    try {
//      img = ImageIO.read(new File("fondBoutonClic.png"));
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//  }
//
//  public void mouseReleased(MouseEvent event) {
//    //Nous changeons le fond de notre image pour le orange lorsque nous relâchons le clic, avec le fichier fondBoutonHover.png
//    try {
//      img = ImageIO.read(new File("fondBoutonHover.png"));
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//  }

// public static void setBestLookAndFeelAvailable(){
//    String system_lf = UIManager.getSystemLookAndFeelClassName().toLowerCase();
//    if(system_lf.contains("metal")){
//        try {
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
//        }catch (Exception e) {}
//    }else{
//        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        }catch (Exception e) {}
//    }
//  }

  public static void main(String[] args) {

    new Menu();
  }

}
