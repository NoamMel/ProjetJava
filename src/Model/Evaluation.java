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
    
    /** Constructeur par defaut */
    public Evaluation()
    {
        
    }
    
    /** Constructeur surchargé
     * @param note
     * @param appreciation */
    public Evaluation(int note, String appreciation, int id)
    {
        this.note = note;
        this.appreciation = appreciation;
        this.id = id;
    }
    
    public int getID()
    {
        return id;
    }
}
