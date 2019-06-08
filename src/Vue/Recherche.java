package Vue;

import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Recherche extends JFrame /*implements MouseListener*/{

  private JLabel jLabel1 = new JLabel();
  private JButton jButton1 = new JButton();
  private JButton button = new JButton();
  private JList jList1 = new JList<>();
  private JList jList2 = new JList<>();


  @SuppressWarnings("unchecked")
  public Recherche(){
    this.setTitle("Campus - Recherche d'informations");
    this.setSize(800, 600);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setVisible(true);
    this.setResizable(false);





    button.addActionListener(new BoutoncListener());


        JSeparator jSeparator1 = new javax.swing.JSeparator();
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        JScrollPane jScrollPane2 = new javax.swing.JScrollPane();


        jButton1.addActionListener(new BoutonListener());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Recherche d'informations");

        jButton1.setText("Retourner au Menu");

        jList1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Niveaux", "Classes", "Disciplines", "Enseignants", "Eleves", "Bulletins", "Evaluations" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        button.setText("Rechercher");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());

        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
           .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
               .addContainerGap(331, Short.MAX_VALUE)
               .addComponent(jLabel1)
               .addGap(173, 173, 173)
               .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addContainerGap())
           .addGroup(layout.createSequentialGroup()
           .addGap(54, 54, 54)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
            // .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            // .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(261, 261, 261))
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
                .addGap(121, 121, 121)
                // .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    // .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)));


        pack();


 }

    // @Override
    class BoutoncListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Rechercher")) {
            int index = jList1.getSelectedIndex();
            System.out.println("Index Selected: " + index);
            String s = jList1.getSelectedValue().toString();
            System.out.println("Value Selected: " + s);
            if(s == "Niveaux"){setVisible(false); try {
                new NiveauxAffichage();
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
                }
}
            if(s == "Enseignants"){setVisible(false); try {
                new ProfesseursAffichage();
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
                }
}
            if(s == "Classes"){setVisible(false); try {
                new ClassesAffichage();
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
                }
}
            if(s == "Eleves"){setVisible(false); try {
                new ElevesAffichage();
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
                }
}
            if(s == "Bulletins"){setVisible(false); try {
                new BulletinsAffichage();
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
                }
}
            if(s == "Disciplines"){setVisible(false); try {
                new DisciplinesAffichage();
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
                }
}
            if(s == "Evaluations"){setVisible(false); try {
                new EvaluationsAffichage();
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
                }
}
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



}
