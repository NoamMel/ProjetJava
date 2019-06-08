/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import java.sql.SQLException;
import java.util.ArrayList;
import jdbcv2018.*;
import Model.*;
import Model.Stockage;

import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.*;
import java.util.Arrays;
import javax.swing.table.*;


import java.sql.SQLException;
import java.util.ArrayList;
import jdbcv2018.*;
import Controleur.*;
import java.util.Date;

/**
 *
 * @author margo
 */
public class TestConnexion extends JFrame{
    
    public static void main(String args[]) throws SQLException, ClassNotFoundException{
        Connexion conn = new Connexion("ece","root","");
        //conn.ajouterTable("Personne");
        
//        ArrayList<String> req = new ArrayList<>();
//        req = conn.remplirChampsTable("Personne");
//        for(int i = 0; i<req.size();i++){
//            System.out.println(req.get(i));
//        }
        
//        req = conn.remplirChampsRequete("SELECT * FROM Personne WHERE Type = 'Etudiant'");
//        for(int i = 0; i<req.size();i++){
//            System.out.println(req.get(i));
//        }  
//        

//        DAO inscriptionDAO = new InscriptionDAO(conn);
//        Etudiant e = new Etudiant("Palfi","Emma",3);
//        Classe c = new Classe("TD10","ING3",2019,4);
//        //inscriptionDAO.create(e,c);
//        Inscription i = new Inscription(e,c,17);
//        inscriptionDAO.delete(i);

           RecupBDD recup = new RecupBDD(conn);
           recup.recupEtudiants();
           recup.recupProfesseurs();
           recup.recupNiveaux();
           recup.recupClasses();
           recup.recupInscriptions();
           
           new TestConnexion();

    }
    
      private JLabel jLabel1 = new JLabel();
  private JButton jButton1 = new JButton();
  private JButton button = new JButton();
  private JList jList1 = new JList<>();
  private JList jList2 = new JList<>();
  private JTable jTable1 = new JTable();
  private DefaultTableModel model = new DefaultTableModel();
  JScrollPane scroll;
 




  @SuppressWarnings("unchecked")
  public TestConnexion() throws SQLException, ClassNotFoundException{
                    
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

//        Connexion conn2 = new Connexion("ece","root","");
//            conn2.ajouterTable("Personne");
//            ArrayList<String> req2 = new ArrayList<>();
//            req2 = conn2.remplirChampsTable("Personne");
//            req2 = conn2.remplirChampsRequete("SELECT Nom, Prenom FROM Personne");
            String[] strings = {"","","","","","","","","","","","","","","","","",""};
////            for(int i = 0; i<req2.size(); i++){
////                strings[i] = req2.get(i);
////            }
//            
////        jList2.setModel(new javax.swing.AbstractListModel<String>() {
////            
////            public int getSize() { return strings.length; }
////            public String getElementAt(int i) { return strings[i]; }
////        
        Connexion conn = new Connexion("ece","root","");
//                RecupBDD recup = new RecupBDD(conn);
//
//                Stockage stockage = new Stockage();
//        ArrayList<Etudiant> data = stockage.getListeEtudiants();
//        
//        recup.recupEtudiants();

RecupBDD recup = new RecupBDD(conn);
        recup.recupEtudiants();
        ArrayList<Etudiant> data = recup.getStockage().getListeEtudiants();

       
        Object col[] = {"Nom", "Prenom"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 2);
        model.setColumnIdentifiers(col); 
//        jTable1 = new JTable(req2, col);
        jTable1.setModel(model);
        scroll = new JScrollPane(jTable1);
        
//        ArrayList<String> ar = new ArrayList<String>();
//        for(int i = 0; i<data.size(); i++){
//                strings[i] = data.get(i);
//         }
//        for (int i = 0; i < strings.length; i++) {
//          ar.add(strings[i]);
//        }
//        System.out.println(ar);
        for (int i = 0; i < (data.size() ); i++) {
          model.addRow(new Object[] { String.valueOf(data.get( i).getNom()),
              String.valueOf(data.get( i ).getPrenom()) });
                  System.out.print(data.get(i));
        }
        System.out.println("----------------------------------");
        for(int i=0; i<data.size(); i++){
        System.out.println(data.get(i).getNom());
        }
//        for(int i)


//        String[][] res = new String[req2.size()][];
//        req2.toArray(res);

//        jTable1 = new JTable(res, col);      
        

        
        
        jList2 = new JList<>(data.toArray());
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
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(150, 150, 150))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
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