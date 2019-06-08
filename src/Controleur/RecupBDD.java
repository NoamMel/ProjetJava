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
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

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
    
    public Stockage getStockage()
    {
        return stock;
    }
}
