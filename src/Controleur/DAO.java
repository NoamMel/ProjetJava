/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;
import Model.*;
import jdbcv2018.*;

/**
 * Source: openclassroom DAO
 * @author Emma
 * @param <T>
 */

public abstract class DAO<T> 
{
    protected Connexion conn = null;
   
    public DAO(Connexion conn)
    {
        this.conn = conn;
    }
   
  /**
  * Méthode de création
  */
  public abstract void create(String nom, String prenom);
  public abstract void create(String nom, String niveau, int anneeScolaire);
  public abstract void create(int numero, int debut, int fin, int anneeScolaire);
  public abstract void create(Etudiant etudiant, Classe classe);
  public abstract void create(String appreciation, Trimestre t, Inscription i);
  public abstract void create(String appreciation, Enseignement e, Bulletin b);

  /**
  * Méthode pour effacer
  * @param obj
  * @return boolean 
  */
  public abstract void delete(T obj);

  /**
  * Méthode de mise à jour
  * @param obj
  * @return boolean
  */
  public abstract void update(T obj);

  /**
  * Méthode de recherche des informations
  * @param id
  * @return T
  */
  //public abstract T find(int id);
}