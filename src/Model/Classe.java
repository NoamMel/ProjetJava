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
    private String niveau;
    private int anneeScolaire;
    private ArrayList<Etudiant> etudiants;
    //private HashMap<String, Enseignement> enseignements;
    
    /** Constructeur par défaut */
    public Classe()
    {
        
    }

        /** Constructeur surchargé
     * @param niveau
     * @param etudiants
     * @param enseignements */
    public Classe(String niveau, int anneeScolaire, int id)
    {
        this.etudiants = new ArrayList();
        this.niveau = niveau;
        this.anneeScolaire = anneeScolaire;
        this.id = id;
    }
    
    public void setEtudiants(ArrayList<Etudiant> etudiants)
    {
        this.etudiants = etudiants;
    }
    
    public int getID()
    {
        return id;
    }
//    /** Constructeur surchargé
//     * @param niveau
//     * @param etudiants
//     * @param enseignements */
//    public Classe(String niveau, HashMap<String, Etudiant> etudiants, HashMap<String, Enseignement> enseignements)
//    {
//        this.etudiants = new HashMap();
//        this.enseignements = new HashMap();
//        this.etudiants = etudiants;
//        this.enseignements = enseignements;
//    }
}
