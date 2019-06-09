/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * Classe Personne
 * @author Emma
 */
public class Personne {
    
    /** Attributs */
    private String nom;
    private String prenom;  
    private int id;
    
    /** Constructeur par defaut */
    public Personne()
    {
        
    }
    
    /** Constructeur surchargé
    * @param nom
    * @param prenom */
    public Personne(String nom, String prenom, int id)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.id = id;
    }
    
    /** Getter qui permet de récupérer l'id d'une personne
     * 
     * @return 
     */
    public int getID()
    {
        return id;
    }
    
    /** Getter qui permet de récupérer le nom d'une personne
     * 
     * @return 
     */
    public String getNom()
    {
        return nom;
    }

    /** Getter qui permet de récupérer le prenom d'une personne
     * 
     * @return 
     */
    public String getPrenom()
    {
        return prenom;
    }
}
