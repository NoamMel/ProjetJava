/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.SQLException;
import java.util.ArrayList;
import jdbcv2018.*;
import Controleur.*;
import java.util.Date;

/**
 *
 * @author margo
 */
public class TestConnexion{
    
    public static void main(String args[]) throws SQLException, ClassNotFoundException{
        Connexion conn = new Connexion("ECE","root","root");
        conn.ajouterTable("Personne");
        
//        ArrayList<String> req = new ArrayList<>();
//        req = conn.remplirChampsTable("Personne");
//        for(int i = 0; i<req.size();i++){
//            System.out.println(req.get(i));
//        }
        
//        req = conn.remplirChampsRequete("SELECT * FROM Personne WHERE Type = 'Etudiant'");
//        for(int i = 0; i<req.size();i++){
//            System.out.println(req.get(i));
//        }  
//        
        DAO inscriptionDAO = new InscriptionDAO(conn);
        Etudiant e = new Etudiant("Palfi","Emma",3);
        Classe c = new Classe("TD10","ING3",2019,4);
        //inscriptionDAO.create(e,c);
        Inscription i = new Inscription(e,c,17);
        inscriptionDAO.delete(i);
    }
    
}