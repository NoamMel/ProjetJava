package Vue;

import Controleur.RecupBDD;
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import jdbcv2018.Connexion;


public class MAJ_Niveaux extends JFrame /*implements MouseListener*/{
  private JLabel jLabel1 = new JLabel();
  private JButton jButton1 = new JButton();
  private JButton button = new JButton();
  private JList jList1 = new JList<>();
  private JList jList2 = new JList<>();
  private JButton jButton3 = new javax.swing.JButton();
  private JButton jButton4 = new javax.swing.JButton();
  private JButton jButton5 = new javax.swing.JButton();
  private JTable jTable1 = new JTable();
  private DefaultTableModel model = new DefaultTableModel();
  JScrollPane scroll;



  @SuppressWarnings("unchecked")
  public MAJ_Niveaux() throws SQLException, ClassNotFoundException{
    this.setTitle("Campus - Espace modifications");
    this.setSize(800, 600);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setVisible(true);
    this.setResizable(false);












    jButton1.addActionListener(new BoutonListener());
    button.addActionListener(new BoutoncListener());
    jButton3.addActionListener(new BoutonAddListener());
    jButton4.addActionListener(new BoutonRemoveListener());
    jButton5.addActionListener(new BoutonRefreshListener());


        JSeparator jSeparator1 = new javax.swing.JSeparator();
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
        JTextField jTextField1 = new javax.swing.JTextField();



        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Espace modifications");

        jButton1.setText("Retourner au Menu");

        jList1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Niveaux", "Disciplines", "Evaluations" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        Connexion conn = new Connexion("ece","root","");
        
        RecupBDD recup = new RecupBDD(conn);
        recup.recupNiveaux();
        ArrayList<String> data = recup.getStockage().getListeNiveaux();

       
        Object col[] = {"Niveaux"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 1);
        model.setColumnIdentifiers(col); 
        jTable1.setModel(model);
        scroll = new JScrollPane(jTable1);
        
        
        for (int i = 0; i < (data.size() ); i++) {
          model.addRow(new Object[] { String.valueOf(data.get(i))});
                  System.out.print(data.get(i));
        }

        button.setText("Modifier");

        jTextField1.setText("Nouvel element");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton3.setText("Ajouter");

        jButton4.setText("Retirer l'element");

        jButton5.setText("Appliquer les modifications");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(108, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(173, 173, 173)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65))
        );

        pack();
    }


    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
        }



    // @Override
    class BoutoncListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Modifier")) {
            int index = jList1.getSelectedIndex();
            System.out.println("Index Selected: " + index);
            String s = jList1.getSelectedValue().toString();
            System.out.println("Value Selected: " + s);
        }
    }
  }





  class BoutonListener implements ActionListener{
  public void actionPerformed(ActionEvent e) {
    jButton1.setEnabled(true);
    setVisible(false);
    new Menu();
  }
}


class BoutonAddListener implements ActionListener{
public void actionPerformed(ActionEvent e) {
  jButton3.setEnabled(true);
  setVisible(false);
    try {
        // ajouter l'element dans la BDD
        new MAJ_Niveaux();
    } catch (SQLException ex) {
        Logger.getLogger(MAJ_Niveaux.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(MAJ_Niveaux.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}


class BoutonRemoveListener implements ActionListener{
public void actionPerformed(ActionEvent e) {
  jButton4.setEnabled(true);
  setVisible(false);
    try {
        // retirer l'element dans la BDD
        new MAJ_Niveaux();
    } catch (SQLException ex) {
        Logger.getLogger(MAJ_Niveaux.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(MAJ_Niveaux.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}


class BoutonRefreshListener implements ActionListener{
public void actionPerformed(ActionEvent e) {
  jButton5.setEnabled(true);
  setVisible(false);
    try {
        // rafraichir/modifier l'element dans la BDD
        // peut-etre afficher les valeurs en jtextfield dans un for
        new MAJ_Niveaux();
    } catch (SQLException ex) {
        Logger.getLogger(MAJ_Niveaux.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(MAJ_Niveaux.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}

}
