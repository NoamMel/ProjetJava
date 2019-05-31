/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.sql.SQLException;
import java.util.ArrayList;
import jdbcv2018.*;

/**
 *
 * @author margo
 */
public class TestConnexion{
    
    public static void main(String args[]) throws SQLException, ClassNotFoundException{
        Connexion conn = new Connexion("ECE","root","root");
        conn.ajouterTable("Personne");
        
        ArrayList<String> req = new ArrayList<>();
        req = conn.remplirChampsTable("Personne");
        for(int i = 0; i<req.size();i++){
            System.out.println(req.get(i));
        }
        
        req = conn.remplirChampsRequete("SELECT * FROM Personne WHERE Type = 'Etudiant'");
        for(int i = 0; i<req.size();i++){
            System.out.println(req.get(i));
        }    
    }
    
}