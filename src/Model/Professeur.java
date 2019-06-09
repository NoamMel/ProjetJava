/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


/**
 * Classe Professeur qui hérite de la classe Personne
 * @author Emma
 */
public class Professeur extends Personne 
{
    /** Constructeur par defaut */
    public Professeur()
    {
        super();
    }
    
    /** Constructeur surchargé
     * @param Nom
     * @param Prenom
     * @param id */
    public Professeur(String Nom, String Prenom, int id)
    {
        super(Nom, Prenom, id);
    }
}
