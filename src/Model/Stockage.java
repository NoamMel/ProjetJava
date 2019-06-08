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
    
    ArrayList<String> niveaux;
    //ArrayList<Personne> personnes;
    ArrayList<Etudiant> etudiants;
    ArrayList<Professeur> professeurs;
    ArrayList<Classe> classes;
    ArrayList<Inscription> inscriptions;
    ArrayList<Bulletin> bulletins;
    
    
    /*public Stockage(ArrayList<String> niveauxMettre tous les ArrayList){
        this.niveaux = new ArrayList();
        this.niveaux = niveaux;
    } */   
    
    public Stockage(){
        niveaux = new ArrayList();
        //personnes = new ArrayList();
        etudiants = new ArrayList();
        professeurs = new ArrayList();
        classes = new ArrayList();
    }
    
    public void setClasses(ArrayList<Classe> classes){
        this.classes =classes;
    }
    
    public void setNiveaux(ArrayList<String> niveaux){
        this.niveaux = niveaux;
    }
    
    /*public void setPersonnes(ArrayList<Personne> personnes){
        this.personnes = personnes;
    }*/
    
    public void setEtudiants(ArrayList<Etudiant> etudiants){
        this.etudiants = etudiants;
    }
    
    public void setProfesseurs(ArrayList<Professeur> professeurs){
        this.professeurs = professeurs;
    }
    
    public void setInscriptions(ArrayList<Inscription> inscriptions){
        this.inscriptions = inscriptions;
    }
    
    public Etudiant getEtudiant(int id){
        Etudiant e = new Etudiant();
        for(int i = 0; i<etudiants.size(); i++){
            if(etudiants.get(i).getID()==id){
                e = etudiants.get(i);
            }
        }
        return e;
    }
    
    public Classe getClasse(int id){
        Classe c = new Classe();
        for(int i = 0; i<classes.size(); i++){
            if(classes.get(i).getID()==id){
                c = classes.get(i);
            }
        }
        return c;
    }
    
    public ArrayList<Etudiant> getListeEtudiants(){
        return etudiants;
    }
    
    public ArrayList<Professeur> getListeProfesseurs(){
        return professeurs;
    }

    public ArrayList<String> getListeNiveaux(){
        return niveaux;
    }

    public ArrayList<Classe> getListeClasses(){
        return classes;
    }

    public ArrayList<Inscription> getListeInscriptions(){
        return inscriptions;
    }  
    
    public ArrayList<Bulletin> getListeBulletins(){
        return bulletins;
    }
}
