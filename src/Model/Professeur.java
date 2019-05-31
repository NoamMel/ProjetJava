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
public class Professeur {
    
    /** Attributs */
    private ArrayList<Enseignement> enseignements; 
    
    /** Constructeur par defaut */
    public Professeur()
    {
        
    }
    
    /** Constructeur surchargé
     * @param enseignements */
    public Professeur(ArrayList<Enseignement> enseignements)
    {
        this.enseignements = new ArrayList();
        this.enseignements = enseignements;
    }
}
