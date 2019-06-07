/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author margo
 */
public class Stockage {
    
    /** Attributs */
    ArrayList<String> niveaux;
    ArrayList<Personne> personnes;
    ArrayList<Etudiant> etudiants;
    ArrayList<Professeur> professeurs;
    ArrayList<Classe> classes;
    
    
    /*public Stockage(ArrayList<String> niveauxMettre tous les ArrayList){
        this.niveaux = new ArrayList();
        this.niveaux = niveaux;
    } */   
    
    /** Constructeur surchargé 
     * 
     */
    public Stockage(){
        niveaux = new ArrayList();
        personnes = new ArrayList();
        etudiants = new ArrayList();
        professeurs = new ArrayList();
    }
    
    /** Setter qui permet de modifier la liste de classe du stockage
     * 
     * @return 
     */
    public void setClasses(ArrayList<Classe> classes){
        this.classes =classes;
    }
    
    /** Setter qui permet de modifier la liste de niveaux du stockage
     * 
     * @return 
     */
    public void setNiveaux(ArrayList<String> niveaux){
        this.niveaux = niveaux;
    }
    
    /*public void setPersonnes(ArrayList<Personne> personnes){
        this.personnes = personnes;
    }*/
    
    /** Setter qui permet de modifier la liste d'étudiants du stockage
     * 
     * @return 
     */
    public void setEtudiants(ArrayList<Etudiant> etudiants){
        this.etudiants = etudiants;
    }
    
    /** Setter qui permet de modifier la liste de professeur du stockage
     * 
     * @return 
     */
    public void setProfesseurs(ArrayList<Professeur> professeurs){
        this.professeurs = professeurs;
    }  
}
