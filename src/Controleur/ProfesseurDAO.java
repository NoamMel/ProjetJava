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

public class ProfesseurDAO extends DAO<Professeur> 
{
  
    public ProfesseurDAO(Connexion conn) 
    {
      super(conn);
    }

    /** Méthode pour Classe*/
    @Override
    public void create(String nom, String niveau, int anneeScolaire){}
    
    /** Méthode create pour un trimestre*/
    @Override
    public void create(int numero, int debut, int fin, int anneeScolaire){}
    
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
    
    @Override
    public void create(String nom, String prenom) 
    {
      int id = 0;
      String requete = "INSERT INTO Personne (Nom, Prenom, Type) VALUES ('"+nom+"','"+prenom+"','Enseignant')";
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
      Personne e = new Etudiant(nom,prenom,id);
    }

    @Override
    public void delete(Professeur p) 
    {
      RecupBDD recup = new RecupBDD(conn);
      recup.recupEnseignements();
      ArrayList<Enseignement> data = recup.getStockage().getListeEnseignements();
      
      try {
            for(int i=0; i<data.size(); i++)
            {
              // Supprimer les DetailBulletin qui ont l'id du bulletin en clef étrangère
              if(data.get(i).getProfesseur().getID() == b.getID())
              {
                DAO enseignementDAO = new EnseignementDAO(conn);
                enseignementDAO.delete(data.get(i));
              }   
            }
              conn.getStmt().execute("DELETE FROM Personne WHERE ID_Personne = '"+p.getID()+"'");
          } 
      catch (SQLException ex) 
          {
            ex.printStackTrace();
          }
    }

    /** Méthode update de Evaluation
     * 
     * @param e
     * @param note 
     */
    @Override
    public void update(Evaluation e, int note){}
    
    /** Méthode update de Bulletin et DetailBulletin
     * 
     * @param p
     * @param appreciation 
     */
    @Override
    public void update(Professeur p, String appreciation){}
}