/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 * Classe stockage qu contient tous les arraylists
 * des différents objets qui vont être utilisés après
 * @author margo
 */
public class Stockage {
    
    /**
     * Attributs de la classe stockage
     */
    ArrayList<String> niveaux;
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
    
    
    /**
     * Constructeur par défaut qui instancie tous les arraylists
     */
    public Stockage(){
        niveaux = new ArrayList();
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
    
    /**
     * Setter pour l'arraylist de classes
     * @param classes 
     */
    public void setClasses(ArrayList<Classe> classes){
        this.classes =classes;
    }
    
    /**
     * Setter pour l'arraylist de niveaux (strings)
     * @param niveaux 
     */
    public void setNiveaux(ArrayList<String> niveaux){
        this.niveaux = niveaux;
    }
    
    /**
     * Setter pour l'arraylist d'etudiants
     * @param etudiants 
     */
    public void setEtudiants(ArrayList<Etudiant> etudiants){
        this.etudiants = etudiants;
    }
    
    /**
     * Setter pour l'arraylist de professeurs
     * @param professeurs 
     */
    public void setProfesseurs(ArrayList<Professeur> professeurs){
        this.professeurs = professeurs;
    }
    
    /**
     * Setter pour l'arraylist d'inscriptions
     * @param inscriptions 
     */
    public void setInscriptions(ArrayList<Inscription> inscriptions){
        this.inscriptions = inscriptions;
    }
    
    /**
     * Setter pour l'arraylist de bulletins
     * @param bulletins 
     */
    public void setBulletins(ArrayList<Bulletin> bulletins){
        this.bulletins=bulletins;
    }
    
    /**
     * Setter pour l'arraylist de trimestres
     * @param trimestres 
     */
    public void setTrimestres(ArrayList<Trimestre> trimestres){
        this.trimestres=trimestres;
    }
    
    /**
     * Setter pour l'arraylist d'evaluations
     * @param evaluations 
     */
    public void setEvaluations(ArrayList<Evaluation> evaluations){
        this.evaluations = evaluations;
    }
    
    /**
     * Setter pour l'arraylist de details
     * @param details 
     */
    public void setDetails(ArrayList<DetailBulletin> details){
        this.details=details;
    }
    
    /**
     * Setter pour l'arraylist d'enseignements
     * @param enseignements 
     */
    public void setEnseignements(ArrayList<Enseignement> enseignements){
        this.enseignements=enseignements;
    }
    
    /**
     * Setter pour l'arraylist de disciplines (strings)
     * @param disciplines 
     */
    public void setDisciplines(ArrayList<String> disciplines){
        this.disciplines=disciplines;
    }
    
    /**
     * Methode permettant de retrouver grâce à un id un etudiant
     * @param id
     * @return 
     */
    public Etudiant getEtudiant(int id){
        Etudiant e = new Etudiant();
        for(int i = 0; i<etudiants.size(); i++){
            if(etudiants.get(i).getID()==id){
                e = etudiants.get(i);
            }
        }
        return e;
    }
    
    /**
     * Methode permettant de retrouver grâce à un id un professeur
     * @param id
     * @return 
     */
    public Professeur getProfesseur(int id){
        Professeur p = new Professeur();
        for(int i = 0; i<professeurs.size(); i++){
            if(professeurs.get(i).getID()==id){
                p = professeurs.get(i);
            }
        }
        return p;

    }
    
    /**
     * Methode permettant de retrouver grâce à un id une classe
     * @param id
     * @return 
     */
    public Classe getClasse(int id){
        Classe c = new Classe();
        for(int i = 0; i<classes.size(); i++){
            if(classes.get(i).getID()==id){
                c = classes.get(i);
            }
        }
        return c;
    }
    
    /**
     * Methode permettant de retrouver grâce à un id un trimestre
     * @param id
     * @return 
     */
    public Trimestre getTrimestre(int id){
        Trimestre t = new Trimestre();
        for(int i = 0; i<trimestres.size(); i++){
            if(trimestres.get(i).getID()==id){
                t = trimestres.get(i);
            }
        }
        return t;
    }
    
    /**
     * Methode permettant de retrouver grâce à un id une inscription
     * @param id
     * @return 
     */
    public Inscription getInscription(int id){
        Inscription i = new Inscription();
        for(int j = 0; j<inscriptions.size(); j++){
            if(inscriptions.get(j).getID()==id){
                i = inscriptions.get(j);
            }
        }
        return i;
    }
    
    /**
     * Methode permettant de retrouver grâce à un id un enseignement
     * @param id
     * @return 
     */
    public Enseignement getEnseignement(int id){
        Enseignement e = new Enseignement();
        for(int i = 0; i<enseignements.size(); i++){
            if(enseignements.get(i).getID()==id){
                e = enseignements.get(i);
            }
        }
        return e;
    }
    
    /**
     * Methode permettant de retrouver grâce à un id un bulletin
     * @param id
     * @return 
     */
    public Bulletin getBulletin(int id){
        Bulletin b = new Bulletin();
        for(int i = 0; i<bulletins.size(); i++){
            if(bulletins.get(i).getID()==id){
                b = bulletins.get(i);
            }
        }
        return b;
    }
    
    /**
     * Methode permettant de retrouver grâce à un id un detail bulletin
     * @param id
     * @return 
     */
    public DetailBulletin getDetailBulletin(int id){
        DetailBulletin d = new DetailBulletin();
        for(int i = 0; i<details.size(); i++){
            if(details.get(i).getID()==id){
                d = details.get(i);
            }
        }
        return d;
    }
    
    /**
     * Methode permettant de retrouver grâce à un id une evaluation
     * @param id
     * @return 
     */
    public Evaluation getEvaluation(int id){
        Evaluation d = new Evaluation();
        for(int i = 0; i<evaluations.size(); i++){
            if(evaluations.get(i).getID()==id){
                d = evaluations.get(i);
            }
        }
        return d;
    }
    
    /**
     * Getter retournant l'arraylist d'etudiants
     * @return 
     */
    public ArrayList<Etudiant> getListeEtudiants(){
        return etudiants;
    }
    
    /**
     * Getter retournant l'arraylist de classes
     * @return 
     */
    public ArrayList<Classe> getListeClasses(){
        return classes;
    }
    
    /**
     * Getter retournant l'arraylist de niveaux
     * @return 
     */
    public ArrayList<String> getListeNiveaux(){
        return niveaux;
    }
    
    /**
     * Getter retournant l'arraylist de professeurs
     * @return 
     */
    public ArrayList<Professeur> getListeProfesseurs(){
        return professeurs;
    }
    
    /**
     * Getter retournant l'arraylist d'inscriptions
     * @return 
     */
    public ArrayList<Inscription> getListeInscriptions(){
        return inscriptions;
    }
    
    /**
     * Getter retournant l'arraylist de bulletins
     * @return 
     */
    public ArrayList<Bulletin> getListeBulletins(){
        return bulletins;
    }
    
    /**
     * Getter retournant l'arraylist de trimestres
     * @return 
     */
    public ArrayList<Trimestre> getListeTrimestres(){
        return trimestres;
    }
    
    /**
     * Getter retournant l'arraylist d'evaluations
     * @return 
     */
    public ArrayList<Evaluation> getListeEvaluations(){
        return evaluations;
    }
    
    /**
     * Getter retournant l'arraylist de details bulletin
     * @return 
     */
    public ArrayList<DetailBulletin> getListeDetails(){
        return details;
    }
    
    /**
     * Getter retournant l'arraylist d'enseignements
     * @return 
     */
    public ArrayList<Enseignement> getListeEnseignements(){
        return enseignements;
    }
    
    /**
     * Getter retournant l'arraylist de disciplines
     * @return 
     */
    public ArrayList<String> getListeDisciplines(){
        return disciplines;
    }
      
}
