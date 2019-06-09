/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Model.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe permettant de remplir des arraylist 
 * avec des donnees recupérées de la BDD
 * pour après les envoyer dans le model
 * @author margo
 */
public class RecupBDD {
    
    /**
     * Attributs
     */
    private Stockage stock;
    private Connexion conn = null;
    
    /**
     * Constructeur surchargé de RecupBDD
     * Instancie Stockage et la connexion
     * @param conn : Connexion
     */
    public RecupBDD(Connexion conn){
        stock = new Stockage();
        this.conn = conn;
    }
    
    /**
     * Methode permettant de creer et d'instancier les arraylists de niveaux 
     * et de les envoyer dans le stockage
     * @throws SQLException 
     */
    public void recupNiveaux() throws SQLException{
        ArrayList<String> niveaux = new ArrayList();
        String requete = "SELECT DISTINCT Niveau FROM Classe";
        niveaux = conn.remplirNiveaux(requete);
        stock.setNiveaux(niveaux); 
        
    }
    
    /**
     * Methode permettant de creer et d'instancier les arraylists de classes
     * et de les envoyer dans le stockage
     * @throws SQLException 
     */
    public void recupClasses() throws SQLException{
        ArrayList<Classe> classes = new ArrayList();
        String requete = "SELECT * FROM Classe";
        classes = conn.remplirClasse(requete);
        stock.setClasses(classes);

    }

    /**
     * Methode permettant de creer et d'instancier les arraylists d'etudiants 
     * et de les envoyer dans le stockage
     * @throws SQLException 
     */
    public void recupEtudiants() throws SQLException{
        ArrayList<Etudiant> etudiants = new ArrayList();
        String requete = "SELECT * FROM Personne WHERE Type='Etudiant'";
        etudiants = conn.remplirEtudiant(requete);
        stock.setEtudiants(etudiants);    

    }
    
    /**
     * Methode permettant de creer et d'instancier les arraylists de professeurs 
     * et de les envoyer dans le stockage
     * @throws SQLException 
     */
    public void recupProfesseurs() throws SQLException{
        ArrayList<Professeur> professeurs = new ArrayList();
        String requete = "SELECT * FROM personne WHERE Type='Enseignant'";
        professeurs = conn.remplirProfesseur(requete);
        stock.setProfesseurs(professeurs);
    }
    
    /**
     * Methode permettant de creer et d'instancier les arraylists d'inscriptions 
     * et de les envoyer dans le stockage
     * @throws SQLException 
     */
    public void recupInscriptions() throws SQLException{
        ArrayList<Inscription> inscriptions = new ArrayList();
        ArrayList<ArrayList<Integer>> infos = new ArrayList();
        String requete = "SELECT * FROM Inscription";
        infos = conn.remplirInscription(requete);
        
        for(int i=0; i<infos.size(); i++){
            int id = infos.get(i).get(0);
            //Chercher etudiant
            int etudiant = infos.get(i).get(1);
            Etudiant e = new Etudiant();
            e = stock.getEtudiant(etudiant);
            //Chercher classe
            int classe = infos.get(i).get(2);
            Classe c = new Classe();
            c = stock.getClasse(classe);
            Inscription inscrip = new Inscription(e,c,id);
            inscriptions.add(inscrip);
        }        
        stock.setInscriptions(inscriptions);

    }
    
    /**
     * Methode permettant de creer et d'instancier les arraylists de trimestres
     * et de les envoyer dans le stockage
     * @throws SQLException 
     */
    public void recupTrimestres() throws SQLException{
        ArrayList<Trimestre> trimestres = new ArrayList();
        ArrayList<ArrayList<Integer>> infos = new ArrayList();
        String requete = "SELECT * FROM Trimestre";
        infos = conn.remplirTrimestre(requete);
        for(int i=0; i<infos.size(); i++){
            int id = infos.get(i).get(0);
            int numero = infos.get(i).get(1);
            int debut = infos.get(i).get(2);
            int fin = infos.get(i).get(3);
            int anneeScolaire = infos.get(i).get(4);
            Trimestre trim = new Trimestre(numero,debut,fin,anneeScolaire,id);
            trimestres.add(trim);
        }  
        stock.setTrimestres(trimestres);

    }
    
    /**
     * Methode permettant de creer et d'instancier les arraylists de bulleins 
     * et de les envoyer dans le stockage
     * @throws SQLException 
     */
    public void recupBulletins() throws SQLException{
        ArrayList<Bulletin> bulletins = new ArrayList();
        ArrayList<String> appreciations = new ArrayList();
        String requete = "SELECT Appreciation FROM Bulletin";
        appreciations = conn.recupString(requete);

        ArrayList<ArrayList<Integer>> infos = new ArrayList();
        requete = "SELECT * FROM Bulletin";
        infos = conn.remplirBulletin(requete);

        for(int i = 0; i<appreciations.size(); i++){
            int id = infos.get(i).get(0);
            String app = appreciations.get(i);
            int trim = infos.get(i).get(1);
            Trimestre t = new Trimestre();
            t = stock.getTrimestre(trim);
            int inscript = infos.get(i).get(2);
            Inscription ins = new Inscription();
            ins = stock.getInscription(inscript);
            Bulletin bull = new Bulletin(app,t,ins,id);
            bulletins.add(bull);
        }
        stock.setBulletins(bulletins);

    }
    
    /**
     * Methode permettant de creer et d'instancier les arraylists d'enseignements 
     * et de les envoyer dans le stockage
     * @throws SQLException 
     */
    public void recupEnseignements() throws SQLException{
        ArrayList<Enseignement> enseignements = new ArrayList();
        ArrayList<String> disciplines = new ArrayList();
        String requete = "SELECT Discipline FROM Enseignement";
        disciplines = conn.recupString(requete);
        requete = "SELECT * FROM Enseignement";
        ArrayList<ArrayList<Integer>> infos = new ArrayList();
        infos = conn.remplirEnseignement(requete);
        
        for(int i = 0; i<disciplines.size(); i++){
            int id = infos.get(i).get(0);
            String app = disciplines.get(i);
            int cl = infos.get(i).get(1);
            Classe c = new Classe();
            c = stock.getClasse(cl);
            int prof = infos.get(i).get(2);
            Professeur p = new Professeur();
            p = stock.getProfesseur(prof);
            Enseignement e = new Enseignement(app,c,p,id);
            enseignements.add(e);
        }        
        stock.setEnseignements(enseignements);

        
    }
    
    /**
     * Methode permettant de creer et d'instancier les arraylists de details bulletins
     * et de les envoyer dans le stockage
     * @throws SQLException 
     */
    public void recupDetails() throws SQLException{
        ArrayList<DetailBulletin> details = new ArrayList();
        ArrayList<String> appreciations = new ArrayList();
        String requete = "SELECT Appreciation FROM Detailbulletin";
        appreciations = conn.recupString(requete);
        ArrayList<ArrayList<Integer>> infos = new ArrayList();
        requete = "SELECT * FROM Detailbulletin";
        infos = conn.remplirBulletin(requete);
        for(int i = 0; i<appreciations.size(); i++){
            int id = infos.get(i).get(0);
            String app = appreciations.get(i);
            int ens = infos.get(i).get(1);
            Enseignement e = new Enseignement();
            e = stock.getEnseignement(ens);
            int b = infos.get(i).get(2);
            Bulletin bull = new Bulletin();
            bull = stock.getBulletin(b);
            DetailBulletin dbull = new DetailBulletin(app,e,bull,id);
            details.add(dbull);
        }
        stock.setDetails(details);
    }
    
    /**
     * Methode permettant de creer et d'instancier les arraylists d'evaluations 
     * et de les envoyer dans le stockage
     * @throws SQLException 
     */
    public void recupEvaluations() throws SQLException{
        ArrayList<Evaluation> evaluations = new ArrayList();
        ArrayList<String> appreciations = new ArrayList();
        String requete = "SELECT Appreciation FROM Evaluation";
        appreciations = conn.recupString(requete);
        requete = "SELECT * FROM Evaluation";
        ArrayList<ArrayList<Integer>> infos = new ArrayList();
        infos = conn.remplirEvaluation(requete);
        for(int i = 0; i<appreciations.size(); i++){
            int id = infos.get(i).get(0);
            String app = appreciations.get(i);
            int note = infos.get(i).get(1);
            int b = infos.get(i).get(2);
            DetailBulletin db = new DetailBulletin();
            db = stock.getDetailBulletin(b);
            Evaluation e = new Evaluation(note,app,db,id);
            evaluations.add(e);
        }
        stock.setEvaluations(evaluations);
    }
    
    /**
     * Methode permettant de creer et d'instancier les arraylists de disciplines
     * et de les envoyer dans le stockage
     * @throws SQLException 
     */
    public void recupDisciplines() throws SQLException{
        ArrayList<String> disciplines = new ArrayList();
        String requete = "SELECT Discipline FROM Enseignement";
        disciplines = conn.recupString(requete);

        stock.setDisciplines(disciplines);
    }
    
    /**
     * Methode appelant toutes les methodes du dessus pour pouvoir mettre à jour
     * tous les arraylist
     * @throws SQLException 
     */
    public void updateArray() throws SQLException{
        recupProfesseurs();
        recupEtudiants();
        recupClasses();
        recupNiveaux();
        recupTrimestres();
        recupInscriptions();
        recupBulletins();
        recupEnseignements();
        recupDetails();
        recupEvaluations();
        recupDisciplines();
    }
    
    /**
     * Getter pour le stockage
     * @return stock : Stockage
     */
    public Stockage getStock(){
        return stock;
    }
    
    /**
     * Getter pour le stockage
     * @return stock : Stockage
     */
    public Stockage getStockage()
    {
        return stock;
    }
}
