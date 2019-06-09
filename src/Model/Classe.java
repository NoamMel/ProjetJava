/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * Classe Classe
 * @author Emma
 */
public class Classe {
    
    /** Attributs */
    private int id;
    private String nom;
    private String niveau;
    private int anneeScolaire;
    
    /** Constructeur par défaut */
    public Classe()
    {
        
    }

    /** Constructeur surchargé
     * @param niveau */
    public Classe(String nom, String niveau, int anneeScolaire, int id)
    {
        this.nom = nom;
        this.niveau = niveau;
        this.anneeScolaire = anneeScolaire;
        this.id = id;
    }
    
    /** Getter qui permet de récupérer l'id de la classe
     * 
     * @return id : entier de l'id
     */
    public int getID()
    {
        return id;
    }
    
    /** Getter qui permet de récupérer le nom de la classe
     * 
     * @return nom : chaine de caractères du nom de la classe
     */
    public String getNom(){
        return nom;
    }

    /** Getter qui permet de récupérer le niveau de la classe
     * 
     * @return niveau : chaine de caractère du niveau
     */
    public String getNiveau(){
        return niveau;
    }
    
    /** Getter qui permet de récupérer l'annee scolaire de la classe
     * 
     * @return anneeScolaire : entier de l'annee scolaire
     */
    public int getAnneeScolaire(){
        return anneeScolaire;
    }
}
