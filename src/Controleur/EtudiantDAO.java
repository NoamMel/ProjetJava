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
/**
 * Source : https://coderanch.com/t/307373/databases/ID-INSERT-statement?fbclid=IwAR0cQA4Um8o9BLzXEe4nOTWy6Rim2DEbkWOrA9zdLxZcJ9o-BaefVM_hlvk
 * http://www.mysqltutorial.org/mysql-jdbc-insert/?fbclid=IwAR3SXqe3ACcS28iq9irutRPJvLRw3Mj9BYTFAtfMlQCD_42f04KwsA-k-A8
 * @author Emma
 */

public class EtudiantDAO extends DAO<Etudiant> 
{
  
    public EtudiantDAO(Connexion conn) 
    {
      super(conn);
    }

  @Override
  public void create() 
  {
    int id = 0;
    String Nom = "Ast";
    String Prenom = "Obe";
    String requete = "INSERT INTO Personne (Nom, Prenom, Type) VALUES ('"+Nom+"','"+Prenom+"','Etudiant')";
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
 
    // Creation d'un etudiant
    Personne e = new Etudiant(Nom,Prenom,id);
    System.out.println(e.getID());
  }

  @Override
  public void delete(Etudiant e) 
  {
    // Supression dans la BDD
    try {
            conn.getStmt().execute("DELETE FROM Personne WHERE ID_Personne = '"+e.getID()+"'");
        } 
    catch (SQLException ex) 
        {
          ex.printStackTrace();
        }
  }
   
  @Override
  public void update(Etudiant e) 
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