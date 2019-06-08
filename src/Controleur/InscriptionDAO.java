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

public class InscriptionDAO extends DAO<Inscription> 
{
  
    public InscriptionDAO(Connexion conn) 
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
    
    /** Méthode qui permet d'ajouter une inscription dans la BDD
     * 
     * @param e
     * @param c 
     */
    @Override
    public void create(Etudiant e, Classe c) 
    {
      int id = 0;

      String requete = "INSERT INTO Inscription (ID_Personne, ID_Classe) VALUES ('"+e.getID()+"','"+c.getID()+"')";

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
      Inscription i = new Inscription(e,c,id);
    }

    /** Méthode qui permet de supprimer une inscription dans la BDD
     * 
     * @param i 
     */
    @Override
    public void delete(Inscription i) 
    {
      RecupBDD recup = new RecupBDD(conn);
      recup.recupBulletins();
      ArrayList<Bulletin> data = recup.getStockage().getListeBulletins();
      
      try {
            for(int j=0; j<data.size(); j++)
            {
              // Supprimer les DetailBulletin qui ont l'id du bulletin en clef étrangère
              if(data.get(j).getInscription().getID() == i.getID())
              {
                DAO bulletinDAO = new BulletinDAO(conn);
                bulletinDAO.delete(data.get(j));
              }   
            }
              conn.getStmt().execute("DELETE FROM Inscription WHERE ID_Inscription = '"+i.getID()+"'");
          } 
      catch (SQLException ex) 
          {
            ex.printStackTrace();
          }
    }

    /** Méthode update pour Evaluation
     * 
     * @param e
     * @param note 
     */
    @Override
    public void update(Evaluation e, int note){}
    
    /** Méthode update pour Bulletin et DetailBulletin
     * 
     * @param i
     * @param appreciation 
     */
    @Override
    public void update(Inscription i, String appreciation){}
}