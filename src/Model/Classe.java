/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Emma
 */
public class Classe {
    
    /** Attributs */
    private int id;
    private String nom;
    private String niveau;
    private int anneeScolaire;
    private ArrayList<Etudiant> etudiants;
    
    /** Constructeur par défaut */
    public Classe()
    {
        
    }

    /** Constructeur surchargé
     * @param niveau */
    public Classe(String nom, String niveau, int anneeScolaire, int id)
    {
        this.nom = nom;
        this.etudiants = new ArrayList();
        this.niveau = niveau;
        this.anneeScolaire = anneeScolaire;
        this.id = id;
    }
    
    /** Setter qui permet de modifier la liste d'étudiants de la classe
     * 
     * @param etudiants
     */
    public void setEtudiants(ArrayList<Etudiant> etudiants)
    {
        this.etudiants = etudiants;
    }
    
    /** Getter qui permet de récupérer l'id de la classe
     * 
     * @return 
     */
    public int getID()
    {
        return id;
    }
    
    /** Getter qui permet de récupérer le nom de la classe
     * 
     * @return 
     */
    public String getNom(){
        return nom;
    }

    /** Getter qui permet de récupérer le niveau de la classe
     * 
     * @return 
     */
    public String getNiveau(){
        return niveau;
    }
    
    /** Getter qui permet de récupérer l'annee scolaire de la classe
     * 
     * @return 
     */
    public int getAnneeScolaire(){
        return anneeScolaire;
    }
}
