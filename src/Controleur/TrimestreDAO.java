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
import java.util.Date;
/**
 * Source : https://coderanch.com/t/307373/databases/ID-INSERT-statement?fbclid=IwAR0cQA4Um8o9BLzXEe4nOTWy6Rim2DEbkWOrA9zdLxZcJ9o-BaefVM_hlvk
 * http://www.mysqltutorial.org/mysql-jdbc-insert/?fbclid=IwAR3SXqe3ACcS28iq9irutRPJvLRw3Mj9BYTFAtfMlQCD_42f04KwsA-k-A8
 * @author Emma
 */

public class TrimestreDAO extends DAO<Trimestre> 
{
  
    public TrimestreDAO(Connexion conn) 
    {
      super(conn);
    }

    /** Méthode create pour un etudiant et un professeu
     * @param nom
     * @param prenom*/
    @Override
    public void create(String nom, String prenom){}
    
    /** Méthode pour Class
     * @param nom
     * @param anneeScolaire
     * @param niveau*/
    @Override
    public void create(String nom, String niveau, int anneeScolaire){}
    
    /** Méthode pour Isncription
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
    
    @Override
    public void create(int numero, int debut, int fin, int anneeScolaire) 
    {
      int id = 0;

      String requete = "INSERT INTO Trimestre (Numero, Debut, Fin, AnneeScolaire) VALUES ('"+numero+"','"+debut+"','"+fin+"','"+anneeScolaire+"')";

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
      Trimestre t = new Trimestre(numero,debut,fin,anneeScolaire,id);
    }

    @Override
    public void delete(Trimestre t) 
    {
      // Supression dans la BDD
      try {
              conn.getStmt().execute("DELETE FROM Trimestre WHERE ID_Trimestre = '"+t.getID()+"'");
          } 
      catch (SQLException ex) 
          {
            ex.printStackTrace();
          }
    }

    @Override
    public void update(Trimestre t) 
    {
  //    // Update dans la BDD
  //    try {
  //            conn.getStmt().execute("UPDATE FROM Personne WHERE ID_Personne = '"+e.getID()+"'");
  //        } 
  //    catch (SQLException ex) 
  //        {
  //          ex.printStackTrace();
  //        }
    }
}