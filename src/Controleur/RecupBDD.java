/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import jdbcv2018.*;
import Model.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author margo
 */
public class RecupBDD {
    
    private Stockage stock;
    private Connexion conn = null;
    
    public RecupBDD(Connexion conn){
        stock = new Stockage();
        this.conn = conn;
    }
    
    public void recupNiveaux() throws SQLException{
        ArrayList<String> niveaux = new ArrayList();
        String requete = "SELECT DISTINCT Niveau FROM Classe";
        niveaux = conn.remplirNiveaux(requete);
        stock.setNiveaux(niveaux); 
        
    }
    
    public void recupClasses() throws SQLException{
        ArrayList<Classe> classes = new ArrayList();
        String requete = "SELECT * FROM Classe";
        classes = conn.remplirClasse(requete);
        stock.setClasses(classes);
        
        /*for(int i =0; i<classes.size(); i++){
            System.out.println(classes.get(i).getID()+" "+classes.get(i).getNom()+" "+classes.get(i).getNiveau()+" "+classes.get(i).getAnneeScolaire());
        }*/
    }
    
    /*public void recupPersonnes() throws SQLException{
        //Appeler les méthodes pour etudiants et profs
        ArrayList<Personne> personnes = new ArrayList();
        String requete = "SELECT * FROM personne";
        conn.remplirChampsRequete(requete);
        //Appeler create
        
    }*/
    
    public void recupEtudiants() throws SQLException{
        ArrayList<Etudiant> etudiants = new ArrayList();
        String requete = "SELECT * FROM Personne WHERE Type='Etudiant'";
        etudiants = conn.remplirEtudiant(requete);
        stock.setEtudiants(etudiants);    

    }
    
    public void recupProfesseurs() throws SQLException{
        ArrayList<Professeur> professeurs = new ArrayList();
        String requete = "SELECT * FROM personne WHERE Type='Enseignant'";
        professeurs = conn.remplirProfesseur(requete);
        stock.setProfesseurs(professeurs);
    }
    
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
        
        /*for(int i = 0; i<inscriptions.size(); i++){
            System.out.println(inscriptions.get(i).getID()+" "+inscriptions.get(i).getEtudiant().getNom()+" "+inscriptions.get(i).getClasse().getNom());
        }*/
    }
<<<<<<< HEAD
    
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
        
        /*for(int i = 0; i<trimestres.size(); i++){
            System.out.println(trimestres.get(i).getID()+" "+trimestres.get(i).getNumero()+" "+trimestres.get(i).getDebut()+" "+trimestres.get(i).getFin()+" "+trimestres.get(i).getAnneeScolaire());
        }*/
    }
    
    public void recupBulletins() throws SQLException{
        ArrayList<Bulletin> bulletins = new ArrayList();
        ArrayList<String> appreciations = new ArrayList();
        String requete = "SELECT Appreciation FROM Bulletin";
        appreciations = conn.recupString(requete);
        /*for(int i =0; i<appreciations.size(); i++){
            System.out.println(appreciations.get(i));
        }*/
        ArrayList<ArrayList<Integer>> infos = new ArrayList();
        requete = "SELECT * FROM Bulletin";
        infos = conn.remplirBulletin(requete);
        /*for(int i =0; i<infos.size(); i++){
            System.out.println(infos.get(i).get(0)+" "+infos.get(i).get(1)+" "+infos.get(i).get(2));
        }*/
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
        
        /*for(int i=0; i<bulletins.size(); i++){
            System.out.println(bulletins.get(i).getID()+" "+bulletins.get(i).getAppreciation()+" "+bulletins.get(i).getTrimestre().getDebut()+" "+bulletins.get(i).getInscription().getEtudiant().getNom());
        }*/
    }
    
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
        
        /*for(int i=0; i<enseignements.size(); i++){
            System.out.println(enseignements.get(i).getID()+" "+enseignements.get(i).getDiscipline()+" "+enseignements.get(i).getClasse().getNom()+" "+enseignements.get(i).getProfesseur().getNom());
        }*/
        
    }
    
    
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
    
    
    public void recupDisciplines() throws SQLException{
        ArrayList<String> disciplines = new ArrayList();
        String requete = "SELECT Discipline FROM Enseignement";
        disciplines = conn.recupString(requete);
        /*for(int i = 0; i<disciplines.size(); i++){
            System.out.println(disciplines.get(i));
        }*/
        stock.setDisciplines(disciplines);
    }
    
    
    
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
    
    public Stockage getStock(){
        return stock;
    }
=======
>>>>>>> Noam
    
    public Stockage getStockage()
    {
        return stock;
    }
}
