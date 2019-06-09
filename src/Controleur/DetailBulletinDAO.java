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
 * Classe DetailBulletinDAO qui permet de créer, supprimer et update un detailbulletin, hérite de DAO
 * Source : https://coderanch.com/t/307373/databases/ID-INSERT-statement?fbclid=IwAR0cQA4Um8o9BLzXEe4nOTWy6Rim2DEbkWOrA9zdLxZcJ9o-BaefVM_hlvk
 * http://www.mysqltutorial.org/mysql-jdbc-insert/?fbclid=IwAR3SXqe3ACcS28iq9irutRPJvLRw3Mj9BYTFAtfMlQCD_42f04KwsA-k-A8
 * @author Emma
 */

public class DetailBulletinDAO extends DAO<DetailBulletin> 
{
  
    /** Constructeur
     * 
     * @param conn 
     */
    public DetailBulletinDAO(Connexion conn) 
    {
      super(conn);
    }

    /** Méthode create pour un etudiant et un professeur
     * @param nom
     * @param prenom*/
    @Override
    public void create(String nom, String prenom){}
    
    /** Méthode pour Classe
     * @param nom
     * @param anneeScolaire
     * @param niveau*/
    @Override
    public void create(String nom, String niveau, int anneeScolaire){}
    
    /** Méthode pour Trimestre
     * @param numero
     * @param debut
     * @param fin
     * @param anneeScolaire */
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
    
    /** Méthode qui permet d'ajouter un DetailBulletin à la BDD
     * 
     * @param appreciation
     * @param e
     * @param b 
     */
    @Override
    public void create(String appreciation, Enseignement e, Bulletin b) 
    {
      int id = 0;

      String requete = "INSERT INTO DetailBulletin (Appreciation, ID_Enseignement, ID_Bulletin) VALUES ('"+appreciation+"','"+e.getID()+"','"+b.getID()+"')";

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

    /** Méthode qui permet de supprimer un DetailBulletin dans la BDD
     * 
     * @param d 
     */
    @Override
    public void delete(DetailBulletin d) 
    {
      RecupBDD recup = new RecupBDD(conn);
      try{recup.updateArray();}
      catch(SQLException sql){}
      ArrayList<Evaluation> data = recup.getStock().getListeEvaluations();
      
      try {
            if(!data.isEmpty())
            {
                for(int i=0; i<data.size(); i++)
                {
                  // Supprimer les evaluations qui ont l'id du Detailbulletin en clef étrangère
                  if(data.get(i).getDetailBulletin().getID() == d.getID())
                  {
                    DAO evaluationDAO = new EvaluationDAO(conn);
                    evaluationDAO.delete(data.get(i));
                  }   
                }
            }
            
            conn.getStmt().execute("DELETE FROM DetailBulletin WHERE ID_DetailBulletin = '"+d.getID()+"'");
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
    
    /** Méthode qui permet de modifier l'appréciation du Detailbulletin
     * 
     * @param d
     * @param appreciation 
     */
    @Override
    public void update(DetailBulletin d, String appreciation)
    {
        // Update dans la BDD
        try {
                conn.getStmt().execute("UPDATE DetailBulletin SET Appreciation = '"+appreciation+"' WHERE ID_DetailBulletin = '"+d.getID()+"'");
                System.out.println("Ok3");
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
}