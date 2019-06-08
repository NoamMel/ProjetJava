/* s'ouvre mais ne ferme pas la page precedente */
package Vue;



import jdbcv2018.*;
import Model.*;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;


import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.sql.SQLException;
import java.util.ArrayList;
import Controleur.*;


public class ElevesAffichage extends JFrame /*implements MouseListener*/{
  private JLabel jLabel1 = new JLabel();
  private JButton jButton1 = new JButton();
  private JButton button = new JButton();
  private JList jList1 = new JList<>();
  private JList jList2 = new JList<>();
  private JTable jTable1 = new JTable();
  private DefaultTableModel model = new DefaultTableModel();
  JScrollPane scroll;


  
  
  
  @SuppressWarnings("unchecked")
  public ElevesAffichage() throws SQLException, ClassNotFoundException{
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

        
            
        Connexion conn = new Connexion("ece","root","");
        
        RecupBDD recup = new RecupBDD(conn);
        recup.recupEtudiants();
        ArrayList<Etudiant> data = recup.getStockage().getListeEtudiants();

       
        Object col[] = {"Nom", "Prenom"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 2);
        model.setColumnIdentifiers(col); 
        jTable1.setModel(model);
        scroll = new JScrollPane(jTable1);
        
        
        for (int i = 0; i < (data.size() ); i++) {
          model.addRow(new Object[] { String.valueOf(data.get( i).getNom()),
              String.valueOf(data.get( i ).getPrenom()) });
                  System.out.print(data.get(i));
        }
      
    
        
        
        
        
        ListSelectionModel cellSelectionModel = jTable1.getSelectionModel();
    cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent e) {
        String selectedData = null;

        int selectedRow = jTable1.getSelectedRow();
        int selectedColumns = jTable1.getSelectedColumn();
        selectedData = (String) jTable1.getValueAt(selectedRow, selectedColumns);

//        for (int i = 0; i < selectedRow.length; i++) {
//          for (int j = 0; j < selectedColumns.length; j++) {
//            selectedData = (String) jTable1.getValueAt(selectedRow[i], selectedColumns[j]);
//          }
//        }
        System.out.println("Selected: " + selectedData);
      }
    }
)
;
    
    
        
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
//            int index = jList1.getSelectedIndex();
//            System.out.println("Index Selected: " + index);
//            String s = jList1.getSelectedValue().toString();
//            System.out.println("Value Selected: " + s);
        }
        
       
        
    }
    }
    
//    public void modif(){
//    ListSelectionModel cellSelectionModel = jTable1.getSelectionModel();
//    cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//    cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
//      public void valueChanged(ListSelectionEvent e) {
//        String selectedData = null;
//
//        int[] selectedRow = jTable1.getSelectedRows();
//        int[] selectedColumns = jTable1.getSelectedColumns();
//
//        for (int i = 0; i < selectedRow.length; i++) {
//          for (int j = 0; j < selectedColumns.length; j++) {
//            selectedData = (String) jTable1.getValueAt(selectedRow[i], selectedColumns[j]);
//          }
//        }
//        System.out.println("Selected: " + selectedData);
//      }
//    }
//)
//;
//  
//            }





  class BoutonListener implements ActionListener{
  public void actionPerformed(ActionEvent e) {
    jButton1.setEnabled(true);
    setVisible(false);
    new Menu();
  }
}



}