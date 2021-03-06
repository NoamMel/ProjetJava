/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;
import Model.*;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
/**
 * Classe EtudiantDAO qui permet de créer, supprimer et update un etudiant, hérite de DAO
 * Source : https://coderanch.com/t/307373/databases/ID-INSERT-statement?fbclid=IwAR0cQA4Um8o9BLzXEe4nOTWy6Rim2DEbkWOrA9zdLxZcJ9o-BaefVM_hlvk
 * http://www.mysqltutorial.org/mysql-jdbc-insert/?fbclid=IwAR3SXqe3ACcS28iq9irutRPJvLRw3Mj9BYTFAtfMlQCD_42f04KwsA-k-A8
 * @author Emma
 */

public class EtudiantDAO extends DAO<Etudiant> 
{
  
    /** Constructeur
     * 
     * @param conn 
     */
    public EtudiantDAO(Connexion conn) 
    {
      super(conn);
    }

    /** Méthode pour Class
     * @param nom
     * @param niveau
     * @param anneeScolaire
     */
    @Override
    public void create(String nom, String niveau, int anneeScolaire){}
    
    /** Méthode create pour un trimestr
     * @param numero
     * @param debut
     * @param fin
     * @param anneeScolaire
     */
    @Override
    public void create(int numero, int debut, int fin, int anneeScolaire){}
    
    /** Méthode pour Isncription
     * @param e
     * @param c
     */
    @Override
    public void create(Etudiant e, Classe c){}
    
    /** Méthode pour Bulletin
     * @param appreciation
     * @param t
     * @param i
     */
    @Override
    public void create(String appreciation, Trimestre t, Inscription i){}

    /** Méthode pour DetailBulletin
     * @param appreciation
     * @param e
     * @param b
     */
    @Override
    public void create(String appreciation, Enseignement e, Bulletin b){}
    
    /** Méthode pour Evaluation
     * @param note
     * @param appreciation
     * @param d 
     */
    @Override
    public void create(int note, String appreciation, DetailBulletin d){}
    
    /** Méthode pour Enseignement
     * @param discipline
     * @param c
     * @param p 
     */
    @Override
    public void create(String discipline, Classe c, Professeur p){}
    
    /** Méthode qui permet d'ajouter un professeur à la BDD
     * 
     * @param nom
     * @param prenom 
     */
    @Override
    public void create(String nom, String prenom) 
    {
      int id = 0;
      String requete = "INSERT INTO Personne (Nom, Prenom, Type) VALUES ('"+nom+"','"+prenom+"','Etudiant')";
      // Ajout dans la BDD
      try {
              PreparedStatement pstmt = conn.getConn().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
              pstmt.executeUpdate();
              ResultSet keys = pstmt.getGeneratedKeys();
              if(keys.next())
                  id = keys.getInt(1);
      } 
      catch (SQLException ex) 
          {
            ex.printStackTrace();
          }

        // MAJ des données 
        RecupBDD recup = new RecupBDD(conn);
        try{recup.updateArray();}
        catch(SQLException sql){}
    }

    /** Méthode qui permet de supprimer une personne dans la BDD
     * 
     * @param e 
     */
    @Override
    public void delete(Etudiant e) 
    {
      RecupBDD recup = new RecupBDD(conn);
      try{recup.updateArray();}
      catch(SQLException sql){}
      ArrayList<Inscription> data = recup.getStock().getListeInscriptions();
      
      try {
            if(!data.isEmpty())
            {
                for(int i=0; i<data.size(); i++)
                {
                  // Supprimer les Inscription qui ont l'id de l'étudiant en clef étrangère
                  if(data.get(i).getEtudiant().getID() == e.getID())
                  {
                    DAO inscriptionDAO = new InscriptionDAO(conn);
                    inscriptionDAO.delete(data.get(i));
                  }   
                }
            }
 
            conn.getStmt().execute("DELETE FROM Personne WHERE ID_Personne = '"+e.getID()+"'");
          } 
      catch (SQLException ex) 
          {
            ex.printStackTrace();
          }
      
      // MAJ des données 
      try{recup.updateArray();}
      catch(SQLException sql){}
    }

    /** Méthode update pour Evaluation
     * 
     * @param e
     * @param note 
     */
    @Override
    public void update(Evaluation e, int note){}
    
    /** Méthode updtade pour Bulletin et DetailBulletin
     * 
     * @param e
     * @param appreciation 
     */
    @Override
    public void update(Etudiant e, String appreciation){}
}