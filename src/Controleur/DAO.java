/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;
import Model.*;

/**
 * Classe abstract qui permet d'implémenter les fonctions des classes qui héritent de DAO
 * Cette classe n'est jamais instanciée
 * Source: openclassroom DAO
 * @author Emma
 * @param <T>
 */

public abstract class DAO<T> 
{
    /** Attributs */
    protected Connexion conn = null;
   
    /** Constructeur
     * 
     * @param conn 
     */
    public DAO(Connexion conn)
    {
        this.conn = conn;
    }
   
  /**
  * Méthodes de création de toutes les classes qui héritent de DAO
  */
  public abstract void create(String nom, String prenom);
  public abstract void create(String nom, String niveau, int anneeScolaire);
  public abstract void create(int numero, int debut, int fin, int anneeScolaire);
  public abstract void create(Etudiant etudiant, Classe classe);
  public abstract void create(String appreciation, Trimestre t, Inscription i);
  public abstract void create(String appreciation, Enseignement e, Bulletin b);
  public abstract void create(int note, String appreciation, DetailBulletin d);
  public abstract void create(String discipline, Classe c, Professeur p);
  
  /**
  * Méthodes de supression pour toutes les classes qui héritent de DAO
  * @param obj
  * @return boolean 
  */
  public abstract void delete(T obj);

  /**
  * Méthode de mise à jour pour toutes les classes qui héritent de DAO
  * @param obj
  * @param note
  * @return boolean
  */
  public abstract void update(Evaluation e, int note);
  public abstract void update(T obj, String appreciation);
}