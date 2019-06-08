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
public class Professeur extends Personne {
    
//    /** Attributs */
//    private ArrayList<Enseignement> enseignements; 
    
    /** Constructeur par defaut */
    public Professeur()
    {
        super();
    }
    
    /** Constructeur par defaut */
    public Professeur(String Nom, String Prenom, int id)
    {
        super(Nom, Prenom, id);
    }
    
//    /** Constructeur surchargé
//     * @param enseignements 
//     */
//    public Professeur(ArrayList<Enseignement> enseignements)
//    {
//        this.enseignements = new ArrayList();
//        this.enseignements = enseignements;
//    }
}
