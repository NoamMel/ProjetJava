/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;
import java.sql.Connection;
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
  * @param obj
  * @return boolean 
  */
  public abstract void create();

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