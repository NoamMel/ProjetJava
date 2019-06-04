/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Emma
 */
public class Trimestre {
    
    /** Attributs */
    private int id;
    private int numero;
    private Date debut;
    private Date fin;
    
    /** Constructeur par defaut */
    public Trimestre()
    {
        
    }
    
    /** Constructeur surchargé
     * @param numero
     * @param debut
     * @param fin */
    public Trimestre(int numero, Date debut, Date fin, int id)
    {
        this.numero = numero;
        this.debut = debut;
        this.fin = fin;
        this.id =id;
    }
    
    public int getID()
    {
        return id;
    }
}
