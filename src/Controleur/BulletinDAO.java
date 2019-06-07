/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;
import Model.*;
import java.sql.SQLException;
import jdbcv2018.*;
import java.sql.*;
import Model.*;
/**
 * Source : https://coderanch.com/t/307373/databases/ID-INSERT-statement?fbclid=IwAR0cQA4Um8o9BLzXEe4nOTWy6Rim2DEbkWOrA9zdLxZcJ9o-BaefVM_hlvk
 * http://www.mysqltutorial.org/mysql-jdbc-insert/?fbclid=IwAR3SXqe3ACcS28iq9irutRPJvLRw3Mj9BYTFAtfMlQCD_42f04KwsA-k-A8
 * @author Emma
 */

public class BulletinDAO extends DAO<Bulletin> 
{
  
    public BulletinDAO(Connexion conn) 
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
    
    /** Méthode pour DetailBulletin
     * @param appreciation
     * @param e
     * @param b
     */
    @Override
    public void create(String appreciation, Enseignement e, Bulletin b){}
    
    /** Méthode pour Evaluation
     * @param discipline
     * @param c
     * @param p */
    @Override
    public void create(String discipline, Classe c, Professeur p){}
    
    /** Méthode pour Enseignement
     * @param note
     * @param appreciation
     * @param d */
    @Override
    public void create(int note, String appreciation, DetailBulletin d){}
    
    /** Méthode qui permet d'ajouter un Bulletin à la BDD
     * @param appreciation
     * @param t
     * @param i 
     */
    @Override
    public void create(String appreciation, Trimestre t, Inscription i) 
    {
      int id = 0;

      String requete = "INSERT INTO Bulletin (Appreciation, ID_Trimestre, ID_Inscription) VALUES ('"+appreciation+"','"+t.getID()+"','"+i.getID()+"')";

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

      // Creation d'une classe
      Bulletin b = new Bulletin(appreciation,t,i,id);
    }

    /** Méthode qui permet de supprimer un bulletin dans la BDD
     * @param b 
     */
    @Override
    public void delete(Bulletin b) 
    {
      try {
              conn.getStmt().execute("DELETE FROM Bulletin WHERE ID_Bulletin = '"+b.getID()+"'");
          } 
      catch (SQLException ex) 
          {
            ex.printStackTrace();
          }
    }

    /** Méthode update pour Evaluation
     * @param e
     * @param note 
     */
    @Override
    public void update(Evaluation e, int note){}
    
    /** Méthode qui permet de modifier l'apprcaitaion d'un bulletin
     * @param b
     * @param appreciation 
     */
    @Override
    public void update(Bulletin b, String appreciation) 
    {
        // Update dans la BDD
        try {
                conn.getStmt().execute("UPDATE Bulletin SET Appreciation = '"+appreciation+"' WHERE ID_Bulletin = '"+b.getID()+"'");
            } 
        catch (SQLException ex) 
            {
              ex.printStackTrace();
            }
    }
}