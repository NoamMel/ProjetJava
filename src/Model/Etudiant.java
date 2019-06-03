/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Emma
 */
public class Etudiant extends Personne{
    
    /** Attributs */
    private ArrayList<Bulletin> bulletins; 
    
    /** Constructeur par défaut */
    public Etudiant()
    {
        super();
    }
    
    
    
    /** Constructeur surchargé
     * @param bulletins */
    public Etudiant(String Nom, String Prenom, int id)
    {
        super(Nom, Prenom, id);
        this.bulletins = new ArrayList();
    }
}
