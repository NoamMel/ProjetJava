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

        Connexion conn = new Connexion("ECE","root","");

        //conn.ajouterTable("Personne");
        
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
  
//        Etudiant e = new Etudiant("Palfi","Emma",3);
//        Professeur p = new Professeur("r","r",4);
//        Classe c = new Classe("TD10","ING3",2019,4);
//        Inscription i = new Inscription(e,c,10);
//        Trimestre t = new Trimestre(5, 1203, 3028, 2019, 1);
//        String a = "Coucou";
//        String d = "anglais";
//        Bulletin b = new Bulletin(a, t, i, 2);
//        Enseignement en = new Enseignement(d, c, p, 1);
//        DetailBulletin db = new DetailBulletin(a,en,b,2);
//        Evaluation ev = new Evaluation(12,a,db,2);
//        
//        DAO DetailBulletinDAO = new DetailBulletinDAO(conn);
//        DetailBulletinDAO.update(db,"mouai");
//        dbulletinDAO.delete(db);
     
//        RecupBDD recup = new RecupBDD(conn);
//        recup.recupEtudiants();
//        ArrayList<Etudiant> data = recup.getStockage().getListeEtudiants();
        
    } 
}