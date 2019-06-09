/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * Classe Evaluation
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
     * @return id : entier de l'id
     */
    public int getID()
    {
        return id;
    }
    
    /** Getter qui permet de récupérer le detail bulletin de l'evaluation
     * 
     * @return detailBulletin : detail bulletin de l'evaluation
     */
    public DetailBulletin getDetailBulletin()
    {
        return detailBulletin;
    }
    
    /** Getter qui permet de récupérer la note
     * 
     * @return note : entier de la note
     */
    public int getNote(){
        return note;
    }
    
    /** Getter qui permet de récupérer l'appréciation
     * 
     * @return appreciation : chaine de caractères de l'appréciation
     */
    public String getAppreciation(){
        return appreciation;
    }
}
