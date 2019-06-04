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
public class DetailBulletin {
    
    /** Attributs */
    int id;
    private String appreciation;
    private Enseignement enseignement;
    
    /** Constructeur par défaut */
    public DetailBulletin()
    {
        
    }
    
    /** Constructeur surchargé
     * @param appreciation
     * @param enseignement */
    public DetailBulletin(String appreciation, Enseignement enseignement, int id)
    {
        this.appreciation = appreciation;
        this.enseignement = enseignement;
        this.id = id;
    }
    
    public int getID()
    {
        return id;
    }
}
