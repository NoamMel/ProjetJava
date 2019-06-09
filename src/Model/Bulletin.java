/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * Classe Bulletin 
 * @author Emma
 */
public class Bulletin {
    
    /** Attributs */
    private int id;
    private String appreciation;
    private Trimestre trimestre;
    private Inscription inscription;
    
    /** Constructeur par défaut */
    public Bulletin()
    {
        
    }
    
    /** Constructeur surchargé
     * @param appreciation
     * @param trimestre
     * @param inscription
     * @param id */
    public Bulletin(String appreciation, Trimestre trimestre, Inscription inscription, int id)
    {
        this.appreciation = appreciation;
        this.trimestre = trimestre;
        this.inscription = inscription;
        this.id = id;
    }  
    
    /** Getter qui permet de récupérer l'id du Bulletin
     * 
     * @return 
     */
    public int getID()
    {
        return id;
    }
    
    /** Getter qui permet de récupérer l'appréciation
     * 
     * @return 
     */
    public String getAppreciation(){
        return appreciation;
    }
    
    /** Getter qui permet de récupérer le trimestre
     * 
     * @return 
     */
    public Trimestre getTrimestre(){
        return trimestre;
    }
    
    /** Getter qui permet de récupérer l'inscription
     * 
     * @return 
     */
    public Inscription getInscription(){
        return inscription;
    }
    
}
