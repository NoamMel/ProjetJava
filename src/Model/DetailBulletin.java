/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * Classe DetailBulletin
 * @author Emma
 */
public class DetailBulletin {
    
    /** Attributs */
    int id;
    private String appreciation;
    private Enseignement enseignement;
    private Bulletin bulletin;
    
    /** Constructeur par défaut */
    public DetailBulletin()
    {
        
    }
    
    /** Constructeur surchargé
     * @param appreciation
     * @param enseignement
     * @param bulletin
     * @param id 
     */
    public DetailBulletin(String appreciation, Enseignement enseignement, Bulletin bulletin, int id)
    {
        this.appreciation = appreciation;
        this.enseignement = enseignement;
        this.bulletin = bulletin;
        this.id = id;
    }
    
    /** Getter qui permet de récupérer l'id du DetailBulletin
     * 
     * @return 
     */
    public int getID()
    {
        return id;
    }
    
    /** Getter qui permet de récupérer le bulletin
     * 
     * @return 
     */
    public Bulletin getBulletin()
    {
        return bulletin;
    }
    
    /** Getter qui permet de récupérer l'enseignement
     * 
     * @return 
     */
    public Enseignement getEnseignement()
    {
        return enseignement;
    }
}
