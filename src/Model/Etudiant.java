/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * Classe Etudiant qui hérite de la classe Personne
 * @author Emma
 */
public class Etudiant extends Personne{
        
    /** Constructeur par défaut */
    public Etudiant()
    {
        super();
    }
    
    /** Constructeur surchargé
     * @param Nom
     * @param Prenom
     * @param id */
    public Etudiant(String Nom, String Prenom, int id)
    {
        super(Nom, Prenom, id);
    }
}
