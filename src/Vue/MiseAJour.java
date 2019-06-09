package Vue;

import java.awt.event.*;
import javax.swing.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MiseAJour extends JFrame{

  private JLabel jLabel1 = new JLabel();
  private JButton jButton1 = new JButton();
  private JButton button = new JButton();
  private JList jList1 = new JList<>();


  
  @SuppressWarnings("unchecked")
  public MiseAJour(){
    this.setTitle("Campus - Espace modifications");
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
        jLabel1.setText("Espace modifications");

        jButton1.setText("Retourner au Menu");

        jList1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Etudiants", "Professeurs", "Disciplines", "Evaluations", "Bulletins" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);


        button.setText("Modifier");

        /**Affichage de tous les éléments sur la page positionnés à l'endroit
         * indiqué avec la taille indiqué
         */
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());

        getContentPane().setLayout(layout);
        /**Positions et tailles à l'horizontale
         */
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
        /**Positions et tailles à la verticale
         */
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


        /**Methode qui agit sur les PREFERRED_SIZE pour affecter les valeurs
         * correspondantes
         */
        pack();


 }

    // @Override
    /**Methode pour acceder à la page demandée
   * @param ActionEvent qui détecte l'évènement d'appui
   */
  class BoutoncListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Modifier")) {
            int index = jList1.getSelectedIndex();
            System.out.println("Index Selected: " + index);
            String s = jList1.getSelectedValue().toString();
            System.out.println("Value Selected: " + s);
            if(s == "Etudiants"){setVisible(false); try {
                new MAJ_Eleves();
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(MiseAJour.class.getName()).log(Level.SEVERE, null, ex);
                }
}
            if(s == "Evaluations"){setVisible(false); try {
                new MAJ_Evaluations();
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(MiseAJour.class.getName()).log(Level.SEVERE, null, ex);
                }
}            
            if(s == "Professeurs"){setVisible(false); try {
                new MAJ_Professeurs();
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(MiseAJour.class.getName()).log(Level.SEVERE, null, ex);
                }
}            
            if(s == "Disciplines"){setVisible(false); try {
                new MAJ_Disciplines();
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(MiseAJour.class.getName()).log(Level.SEVERE, null, ex);
                }
}            
            if(s == "Bulletins"){setVisible(false); try {
                new MAJ_Bulletins();
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(MiseAJour.class.getName()).log(Level.SEVERE, null, ex);
                }
}            
        }
    }
  }


  /**Methode pour retrourner au menu
   * @param ActionEvent detecte l'appui
   */
  class BoutonListener implements ActionListener{
  public void actionPerformed(ActionEvent e) {
    jButton1.setEnabled(true);
    setVisible(false);
    new Menu();
  }
}



}
