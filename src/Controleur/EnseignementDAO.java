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

public class EnseignementDAO extends DAO<Enseignement> 
{
  
    public EnseignementDAO(Connexion conn) 
    {
      super(conn);
    }

    /** Méthode create pour un etudiant et un professeu
     * @param nom
     * @param prenom
     */
    @Override
    public void create(String nom, String prenom){}
    
    /** Méthode pour Class
     * @param nom
     * @param anneeScolaire
     * @param niveau
     */
    @Override
    public void create(String nom, String niveau, int anneeScolaire){}
    
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
    
    /** Méthode pour Trimestre
     * @param numero
     * @param debut
     * @param fin
     * @param anneeScolaire 
     */
    @Override
    public void create(int numero, int debut, int fin, int anneeScolaire){}
    
    /** Méthode qui permet d'ajouter un enseignement à la BDD
     * @param discipline
     * @param c
     * @param p 
     */
    @Override
    public void create(String discipline, Classe c, Professeur p) 
    {
      int id = 0;

      String requete = "INSERT INTO Enseignement (Discipline, ID_Classe, ID_Personne) VALUES ('"+discipline+"','"+c.getID()+"','"+p.getID()+"')";

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
      Enseignement e = new Enseignement(discipline, c, p, id);
    }

    /** Méthode qui permet de suupprimer un enseignmeent dans la BDD
     * @param e 
     */
    @Override
    public void delete(Enseignement e) 
    {
      // Supression dans la BDD
      try {
              conn.getStmt().execute("DELETE FROM Enseignement WHERE ID_Enseignement = '"+e.getID()+"'");
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
    
    /** Méthode update pour Bulletin et DetailBulletin
     * @param e
     * @param appreciation 
     */
    @Override
    public void update(Enseignement e, String appreciation){}
}