/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Vue.*;
import java.sql.SQLException;

/**
 *
 * @author margo
 */
public class Main
{
    public static void main(String args[]) throws SQLException, ClassNotFoundException
    {
        // Connexion
        Connexion conn = new Connexion("ece","root","");
        RecupBDD recup = new RecupBDD(conn);
        recup.updateArray();
        
        // Menu
        Menu menu = new Menu();     
    }
}