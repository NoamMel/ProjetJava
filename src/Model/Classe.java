/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.HashMap;

/**
 *
 * @author Emma
 */
public class Classe {
    
    /** Attributs */
    private String niveau;
    private HashMap<String, Etudiant> etudiants;
    private HashMap<String, Enseignement> enseignements;
    
    /** Constructeur par défaut */
    public Classe()
    {
        
    }

    /** Constructeur surchargé
     * @param niveau
     * @param etudiants
     * @param enseignements */
    public Classe(String niveau, HashMap<String, Etudiant> etudiants, HashMap<String, Enseignement> enseignements)
    {
        this.etudiants = new HashMap();
        this.enseignements = new HashMap();
        this.etudiants = etudiants;
        this.enseignements = enseignements;
    }
}
