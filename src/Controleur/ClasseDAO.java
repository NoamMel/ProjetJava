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
 * Classe ClasseDAO qui permet de créer, supprimer et update une classe, hérite de DAO
 * Source : https://coderanch.com/t/307373/databases/ID-INSERT-statement?fbclid=IwAR0cQA4Um8o9BLzXEe4nOTWy6Rim2DEbkWOrA9zdLxZcJ9o-BaefVM_hlvk
 * http://www.mysqltutorial.org/mysql-jdbc-insert/?fbclid=IwAR3SXqe3ACcS28iq9irutRPJvLRw3Mj9BYTFAtfMlQCD_42f04KwsA-k-A8
 * @author Emma
 */

public class ClasseDAO extends DAO<Classe> 
{
  
    /** Consctructeur
     * 
     * @param conn 
     */
    public ClasseDAO(Connexion conn) 
    {
      super(conn);
    }

    /** Méthode create pour un etudiant et un professeur*/
    @Override
    public void create(String nom, String prenom){}
    
    /** Méthode create pour un trimestre
     * @param numero
     * @param debut
     * @param fin
     * @param anneeScolaire*/
    @Override
    public void create(int numero, int debut, int fin, int anneeScolaire){}
    
    /** Méthode pour Inscription
     * @param e
     * @param c*/
    @Override
    public void create(Etudiant e, Classe c){}
    
    /** Méthode pour Bulletin
     * @param appreciation
     * @param t
     * @param i*/
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
     * @param d */
    @Override
    public void create(int note, String appreciation, DetailBulletin d){}
    
    /** Méthode pour Enseignement
     * @param discipline
     * @param c
     * @param p */
    @Override
    public void create(String discipline, Classe c, Professeur p){}
    
    /** Méthode qui permet d'ajouter une classe à la BDD
     * @param nom
     * @param niveau
     * @param anneeScolaire 
     */
    @Override
    public void create(String nom, String niveau, int anneeScolaire) 
    {
      int id = 0;

      String requete = "INSERT INTO Classe (Nom, Niveau, AnneeScolaire) VALUES ('"+nom+"','"+niveau+"','"+anneeScolaire+"')";

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

    /** Méthode qui permet de supprimer une classe dans la BDD
     * @param c 
     */
    @Override
    public void delete(Classe c) 
    {
      RecupBDD recup = new RecupBDD(conn);
      try{recup.updateArray();}
      catch(SQLException sql){}
      ArrayList<Enseignement> data1 = recup.getStock().getListeEnseignements();
      ArrayList<Inscription> data2 = recup.getStock().getListeInscriptions();
      
      try {
            if(!data1.isEmpty())
            {
                for(int i=0; i<data1.size(); i++)
                {
                  // Supprimer les DetailBulletin qui ont l'id du bulletin en clef étrangère
                  if(data1.get(i).getClasse().getID() == c.getID())
                  {
                    DAO enseignementDAO = new EnseignementDAO(conn);
                    enseignementDAO.delete(data1.get(i));
                  }   
                }
            }
            
            if(!data2.isEmpty())
            {
                for(int i=0; i<data2.size(); i++)
                {
                  // Supprimer les DetailBulletin qui ont l'id du bulletin en clef étrangère
                  if(data2.get(i).getClasse().getID() == c.getID())
                  {
                    DAO inscriptionDAO = new InscriptionDAO(conn);
                    inscriptionDAO.delete(data2.get(i));
                  }   
                }
            }
            
            conn.getStmt().execute("DELETE FROM Classe WHERE ID_Classe = '"+c.getID()+"'");
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
     * @param e
     * @param note 
     */
    @Override
    public void update(Evaluation e, int note){}
    
    /** Méthode update pour Bulletin et DetailBulletin
     * @param c
     * @param appreciation 
     */
    @Override
    public void update(Classe c, String appreciation){}          
}