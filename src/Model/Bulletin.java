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
public class Bulletin {
    
    /** Attributs */
    private int id;
    private String appreciation;
    private ArrayList<DetailBulletin> detailBulletins;
    private Trimestre trimestre;
    
    /** Constructeur par défaut */
    public Bulletin()
    {
        
    }
    
    /** Constructeur surchargé
     * @param appreciation
     * @param detailBulletins
     * @param trimestre */
    public Bulletin(String appreciation, ArrayList<DetailBulletin> detailBulletins, Trimestre trimestre, int id)
    {
        this.detailBulletins = new ArrayList();
        this.detailBulletins = detailBulletins;
        this.appreciation = appreciation;
        this.trimestre = trimestre;
        this.id = id;
    }  
    
    public int getID()
    {
        return id;
    }
}
