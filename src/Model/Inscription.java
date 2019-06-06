/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Emma
 */
public class Inscription {
    
     /** Attributs */
    private Etudiant etudiant;
    private Classe classe;  
    private int id;
    
    /** Constructeur par defaut */
    public Inscription()
    {
        
    }
    
    /** Constructeur surchargé
    */
    public Inscription(Etudiant etudiant, Classe classe, int id)
    {
        this.etudiant = etudiant;
        this.classe = classe;
        this.id = id;
    }
    
    public int getID()
    {
        return id;
    }
    
}
