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
    
    //ArrayList<String> niveaux;
    ArrayList<Personne> personnes;
    ArrayList<Etudiant> etudiants;
    ArrayList<Professeur> professeurs;
    
    
    /*public Stockage(ArrayList<String> niveauxMettre tous les ArrayList){
        this.niveaux = new ArrayList();
        this.niveaux = niveaux;
    } */   
    
    public Stockage(){
        //niveaux = new ArrayList();
        personnes = new ArrayList();
        etudiants = new ArrayList();
        professeurs = new ArrayList();
    }
    
    /*public void setNiveaux(ArrayList<String> niveaux){
        this.niveaux = niveaux;
    }*/
    
    public void setPersonnes(ArrayList<Personne> personnes){
        this.personnes = personnes;
    }
    
    public void setEtudiants(ArrayList<Etudiant> etudiants){
        this.etudiants = etudiants;
    }
    
    public void setProfesseurs(ArrayList<Professeur> professeurs){
        this.professeurs = professeurs;
    }
    
    
    
}
