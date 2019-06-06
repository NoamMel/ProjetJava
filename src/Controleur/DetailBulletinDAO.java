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

public class DetailBulletinDAO extends DAO<DetailBulletin> 
{
  
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
    
    @Override
    public void create(String appreciation, Enseignement e, Bulletin b) 
    {
      int id = 0;

      String requete = "INSERT INTO DetailBulletin (Appreciation, ID_Endeignement, ID_Bulletin) VALUES ('appreciation',"+e.getID()+"','"+b.getID()+"')";

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
      DetailBulletin d = new DetailBulletin(appreciation,e,b,id);
    }

    @Override
    public void delete(DetailBulletin d) 
    {
      // Supression dans la BDD
      try {
              conn.getStmt().execute("DELETE FROM DetailBulletin WHERE ID_DetailBulletin = '"+d.getID()+"'");
          } 
      catch (SQLException ex) 
          {
            ex.printStackTrace();
          }
    }

    @Override
    public void update(DetailBulletin d) 
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