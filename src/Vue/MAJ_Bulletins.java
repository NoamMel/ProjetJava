package Vue;

import Controleur.*;
import Model.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.ListSelectionModel;

import javax.swing.table.DefaultTableModel;
import jdbcv2018.Connexion;


public class MAJ_Bulletins extends JFrame {
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
  String selectedData = null;
  String selectedDataID = null;
  JTextField jTextField1 = new javax.swing.JTextField();
  JTextField jTextField2 = new javax.swing.JTextField();
  JTextField jTextField3 = new javax.swing.JTextField();





  /**Constructeur qui execute la JFrame affichant les bulletins
   * @throws SQLException Si erreur du serveur mySQL
   * @throws ClassNotFoundException Si manque de dépendances
   */
  @SuppressWarnings("unchecked")
  public MAJ_Bulletins() throws SQLException, ClassNotFoundException{
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

        Connexion conn = new Connexion("ece","root","");
        
        RecupBDD recup = new RecupBDD(conn);
        recup.updateArray();
        ArrayList<Bulletin> data = recup.getStockage().getListeBulletins();

       
        Object col[] = {"N° Bulletin", "Appreciation", "N° Trimestre", "Etudiant"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 4);
        model.setColumnIdentifiers(col); 
        jTable1.setModel(model);
        scroll = new JScrollPane(jTable1);
        
        
        for (int i = 0; i < (data.size() ); i++) {
          model.addRow(new Object[] { String.valueOf(data.get( i).getID()),
            String.valueOf(data.get( i ).getAppreciation()),
            String.valueOf(recup.getStockage().getTrimestre(data.get( i ).getTrimestre().getID()).getNumero()),
            String.valueOf(recup.getStockage().getInscription(data.get( i ).getInscription().getID()).getEtudiant().getNom() + " " + recup.getStockage().getInscription(data.get( i ).getInscription().getID()).getEtudiant().getPrenom())});
                  System.out.print(data.get(i));
        }

        button.setText("Modifier");

        jTextField1.setText("Appreciation");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        
        jTextField2.setText("ID Trimestre");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        
        jTextField3.setText("ID Inscription");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        

        jButton3.setText("Ajouter");

        jButton4.setText("Retirer l'element");

        jButton5.setText("Appliquer les modifications");

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
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5,5,5)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5,5,5)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5,5,5)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(100, Short.MAX_VALUE))
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
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65))
        );

        /**Methode qui agit sur les PREFERRED_SIZE pour affecter les valeurs
         * correspondantes
         */
        pack();
        
        
        ListSelectionModel cellSelectionModel = jTable1.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent e) {

        int selectedRow = jTable1.getSelectedRow();
        int selectedColumns = jTable1.getSelectedColumn();
        selectedData = (String) jTable1.getValueAt(selectedRow, selectedColumns);
        selectedDataID = (String) jTable1.getValueAt(selectedRow, 0);
        System.out.println("Selected: " + selectedData);
    }});
  }


    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
        }



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

/**Methode pour ajouter un élément à la BDD
* @param ActionEvent detecte l'appui
*/
class BoutonAddListener implements ActionListener{
public void actionPerformed(ActionEvent e) {
  jButton3.setEnabled(true);
  setVisible(false);
          System.out.println(jTextField1.getText());

    try {
        // ajouter l'element dans la BDD
        Connexion conn = null;
          try {
              conn = new Connexion("ece", "root", "");
          } catch (SQLException | ClassNotFoundException ex) {
              Logger.getLogger(MAJ_Bulletins.class.getName()).log(Level.SEVERE, null, ex);
          }
    RecupBDD recup = new RecupBDD(conn);
// Initialisation des variables dont on aura besoin
        String appreciation=null;
        int trimestre=0;
        int inscription=0;
        Trimestre tr = new Trimestre();
        Inscription in = new Inscription();
        DAO bulletinDAO = new BulletinDAO(conn);

        
        // on récupère les id que l'utilisateur entre
         appreciation = jTextField1.getText();
         trimestre = Integer.parseInt(jTextField2.getText());
         inscription = Integer.parseInt(jTextField3.getText());
        
       // on récupère les données
       recup.updateArray(); 
       ArrayList<Trimestre> listeDB1 = recup.getStock().getListeTrimestres();
       ArrayList<Inscription> listeDB2 = recup.getStock().getListeInscriptions();
       
       // on parcourt l a liste pour retrouver le detail bulletin choisi
        for(int i=0; i <listeDB1.size(); i++)
       {
           if(listeDB1.get(i).getID() == trimestre)
           {
               // on récupère l'objet
               tr = listeDB1.get(i);
           }
       }
        for(int i=0; i <listeDB2.size(); i++)
       {
           if(listeDB2.get(i).getID() == inscription)
           {
               // on récupère l'objet
               in = listeDB2.get(i);
           }
       }
        
       // on créé le nouvel objet
       bulletinDAO.create(appreciation, tr, in);
    
        new MAJ_Bulletins();
    } catch (SQLException ex) {
        Logger.getLogger(MAJ_Bulletins.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(MAJ_Bulletins.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    }

/**Methode pour retirer un élément de la BDD
* @param ActionEvent detecte l'appui
*/
class BoutonRemoveListener implements ActionListener{
public void actionPerformed(ActionEvent e) {
  jButton4.setEnabled(true);
        setVisible(false);
    try {
        // retirer l'element dans la BDD
        Connexion conn = null;
          try {
              conn = new Connexion("ece", "root", "");
          } catch (SQLException | ClassNotFoundException ex) {
              Logger.getLogger(MAJ_Bulletins.class.getName()).log(Level.SEVERE, null, ex);
          }
    DAO bulletinDAO = new BulletinDAO(conn);
    RecupBDD recup = new RecupBDD(conn);
    recup.updateArray();
    bulletinDAO.delete(recup.getStockage().getBulletin(Integer.parseInt(selectedData)));
    
        
        new MAJ_Bulletins();
    } catch (SQLException | ClassNotFoundException ex) {
        Logger.getLogger(MAJ_Bulletins.class.getName()).log(Level.SEVERE, null, ex);
    }
}}
    


/**Methode pour modifier un élément de la BDD
* @param ActionEvent detecte l'appui
*/
class BoutonRefreshListener implements ActionListener{
public void actionPerformed(ActionEvent e) {
  jButton5.setEnabled(true);
  setVisible(false);
    try {
        // modifier l'element dans la BDD
        Connexion conn = null;
          try {
              conn = new Connexion("ece", "root", "");
          } catch (SQLException | ClassNotFoundException ex) {
              Logger.getLogger(MAJ_Evaluations.class.getName()).log(Level.SEVERE, null, ex);
          }
    DAO bulletinDAO = new BulletinDAO(conn);
    RecupBDD recup = new RecupBDD(conn);
    recup.updateArray();
    bulletinDAO.update(recup.getStockage().getBulletin(Integer.parseInt(selectedDataID)), selectedData);

        
        new MAJ_Bulletins();
    } catch (SQLException | ClassNotFoundException ex) {
        Logger.getLogger(MAJ_Evaluations.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    }

}
