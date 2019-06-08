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
public class Evaluation {
    
    /** Attributs */
    private int id;
    private int note;
    private String appreciation;
    private DetailBulletin detailBulletin;
    
    /** Constructeur par defaut */
    public Evaluation()
    {
        
    }
    
    /** Constructeur surchargé
     * @param note
     * @param appreciation
     * @param detailBulletin
     * @param id */
    public Evaluation(int note, String appreciation, DetailBulletin detailBulletin, int id)
    {
        this.note = note;
        this.appreciation = appreciation;
        this.detailBulletin = detailBulletin;
        this.id = id;
    }
    
    /** Getter qui permet de récupérer l'id de l'évaluation
     * 
     * @return 
     */
    public int getID()
    {
        return id;
    }
    
    public int getNote(){
        return note;
    }
    
    public String getAppreciation(){
        return appreciation;
    }
    
    public DetailBulletin getDetailBulletin(){
        return detailBulletin;
    }
}
