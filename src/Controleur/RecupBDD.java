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
    
    /*public void recupNiveaux(){
        //
    }*/
    
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
        /*for(int i=0; i<etudiants.size(); i++){
            System.out.println(etudiants.get(i).getID()+" "+etudiants.get(i).getNom()+" "+etudiants.get(i).getPrenom());
        }*/
        
    }
    
    /*public void recupProfesseurs() throws SQLException{
        ArrayList<Professeur> professeurs = new ArrayList();
        String requete = "personne WHERE Type='Enseignant'";
        professeurs = conn.remplirPersonne(requete);
    }*/
    
}
