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
    ArrayList<Trimestre> trimestres;
    ArrayList<Enseignement> enseignements;
    ArrayList<DetailBulletin> details;
    ArrayList<Evaluation> evaluations;
    ArrayList<String> disciplines;
    
    
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
        bulletins = new ArrayList();
        trimestres = new ArrayList();
        evaluations = new ArrayList();
        details = new ArrayList();
        enseignements = new ArrayList();
        disciplines = new ArrayList();
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
    
    public void setBulletins(ArrayList<Bulletin> bulletins){
        this.bulletins=bulletins;
    }
    
    public void setTrimestres(ArrayList<Trimestre> trimestres){
        this.trimestres=trimestres;
    }
    
    public void setEvaluations(ArrayList<Evaluation> evaluations){
        this.evaluations = evaluations;
    }
    
    public void setDetails(ArrayList<DetailBulletin> details){
        this.details=details;
    }
    
    public void setEnseignements(ArrayList<Enseignement> enseignements){
        this.enseignements=enseignements;
    }
    
    public void setDisciplines(ArrayList<String> disciplines){
        this.disciplines=disciplines;
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
    
    public Professeur getProfesseur(int id){
        Professeur p = new Professeur();
        for(int i = 0; i<professeurs.size(); i++){
            if(professeurs.get(i).getID()==id){
                p = professeurs.get(i);
            }
        }
        return p;

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
    
    public Trimestre getTrimestre(int id){
        Trimestre t = new Trimestre();
        for(int i = 0; i<trimestres.size(); i++){
            if(trimestres.get(i).getID()==id){
                t = trimestres.get(i);
            }
        }
        return t;
    }
    
    public Inscription getInscription(int id){
        Inscription i = new Inscription();
        for(int j = 0; j<inscriptions.size(); j++){
            if(inscriptions.get(j).getID()==id){
                i = inscriptions.get(j);
            }
        }
        return i;
    }
    
    public Enseignement getEnseignement(int id){
        Enseignement e = new Enseignement();
        for(int i = 0; i<enseignements.size(); i++){
            if(enseignements.get(i).getID()==id){
                e = enseignements.get(i);
            }
        }
        return e;
    }
    
    public Bulletin getBulletin(int id){
        Bulletin b = new Bulletin();
        for(int i = 0; i<bulletins.size(); i++){
            if(bulletins.get(i).getID()==id){
                b = bulletins.get(i);
            }
        }
        return b;
    }
    
    public DetailBulletin getDetailBulletin(int id){
        DetailBulletin d = new DetailBulletin();
        for(int i = 0; i<details.size(); i++){
            if(details.get(i).getID()==id){
                d = details.get(i);
            }
        }
        return d;
    }
    
    public Evaluation getEvaluation(int id){
        Evaluation d = new Evaluation();
        for(int i = 0; i<evaluations.size(); i++){
            if(evaluations.get(i).getID()==id){
                d = evaluations.get(i);
            }
        }
        return d;
    }
    
    public ArrayList<Etudiant> getListeEtudiants(){
        return etudiants;
    }
    
    public ArrayList<Classe> getListeClasses(){
        return classes;
    }
    
    public ArrayList<String> getListeNiveaux(){
        return niveaux;
    }
    
    public ArrayList<Professeur> getListeProfesseurs(){
        return professeurs;
    }
    
    public ArrayList<Inscription> getListeInscriptions(){
        return inscriptions;
    }
    
    public ArrayList<Bulletin> getListeBulletins(){
        return bulletins;
    }
    
    public ArrayList<Trimestre> getListeTrimestres(){
        return trimestres;
    }
    
    public ArrayList<Evaluation> getListeEvaluations(){
        return evaluations;
    }
    
    public ArrayList<DetailBulletin> getListeDetails(){
        return details;
    }
    
    public ArrayList<Enseignement> getListeEnseignements(){
        return enseignements;
    }
    
    public ArrayList<String> getListeDisciplines(){
        return disciplines;
    }
      
}
