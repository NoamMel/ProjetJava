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
public class Trimestre {
    
    /** Attributs */
    private int id;
    private int numero;
    private int debut;
    private int fin;
    private int anneeScolaire;
    
    /** Constructeur par defaut */
    public Trimestre()
    {
        
    }
    
    /** Constructeur surchargé
     * @param numero
     * @param debut
     * @param fin 
     * @param anneeScolaire 
     * @param id 
     */
    public Trimestre(int numero, int debut, int fin, int anneeScolaire, int id)
    {
        this.anneeScolaire = anneeScolaire;
        this.numero = numero;
        this.debut = debut;
        this.fin = fin;
        this.anneeScolaire = anneeScolaire;
        this.id =id;
    }
    
    /** Getter qui permet de récupérer l'id de trimestre
     * 
     * @return 
     */
    public int getID()
    {
        return id;
    }
    
    public int getNumero(){
        return numero;
    }
    
    public int getDebut(){
        return debut;
    }
    
    public int getFin(){
        return fin;
    }
    
    public int getAnneeScolaire(){
        return anneeScolaire;
    }
}
