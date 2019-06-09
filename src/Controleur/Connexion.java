/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

/*
 * 
 * Librairies importées
 */
import Model.*;
import java.sql.*;
import java.util.ArrayList;

/**
 * 
 * Connexion a votre BDD locale ou à distance sur le serveur de l'ECE via le tunnel SSH
 * 
 * @author segado
 */
public class Connexion {

    /**
     * Attributs prives : connexion JDBC, statement, ordre requete et resultat
     * requete
     */
    private Connection conn;
    private Statement stmt;
    private ResultSet rset;
    private ResultSetMetaData rsetMeta;
    /**
     * ArrayList public pour les tables
     */
    public ArrayList<String> tables = new ArrayList<>();
    /**
     * ArrayList public pour les requêtes de sélection
     */
    public ArrayList<String> requetes = new ArrayList<>();
    /**
     * ArrayList public pour les requêtes de MAJ
     */
    public ArrayList<String> requetesMaj = new ArrayList<>();

    /**
     * Constructeur avec 3 paramètres : nom, login et password de la BDD locale
     *
     * @param nameDatabase
     * @param loginDatabase
     * @param passwordDatabase
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public Connexion(String nameDatabase, String loginDatabase, String passwordDatabase) throws SQLException, ClassNotFoundException {
        // chargement driver "com.mysql.jdbc.Driver"
        Class.forName("com.mysql.jdbc.Driver");

        // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
        String urlDatabase = "jdbc:mysql://localhost:8889/" + nameDatabase;

        //création d'une connexion JDBC à la base 
        conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);

        // création d'un ordre SQL (statement)
        stmt = conn.createStatement();
        
        System.out.println("Connexion ok");
    }

    /**
     * Méthode qui ajoute la table en parametre dans son ArrayList
     *
     * @param table
     */
    public void ajouterTable(String table) {
        tables.add(table);
    }

    /**
     * Méthode qui ajoute la requete de selection en parametre dans son
     * ArrayList
     *
     * @param requete
     */
    public void ajouterRequete(String requete) {
        requetes.add(requete);
    }

    /**
     * Méthode qui ajoute la requete de MAJ en parametre dans son
     * ArrayList
     *
     * @param requete
     */
    public void ajouterRequeteMaj(String requete) {
        requetesMaj.add(requete);
    }

    /**
     * Méthode qui retourne l'ArrayList des champs de la table en parametre
     *
     * @param table
     * @return
     * @throws java.sql.SQLException
     */
    public ArrayList remplirChampsTable(String table) throws SQLException {
        // récupération de l'ordre de la requete
        rset = stmt.executeQuery("select * from " + table);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();

        // creation d'une ArrayList de String
        ArrayList<String> liste;
        liste = new ArrayList<>();
        String champs = "";
        // Ajouter tous les champs du resultat dans l'ArrayList
        for (int i = 0; i < nbColonne; i++) {
            champs = champs + " " + rsetMeta.getColumnLabel(i + 1);
        }

        // ajouter un "\n" à la ligne des champs
        champs = champs + "\n";

        // ajouter les champs de la ligne dans l'ArrayList
        liste.add(champs);

        // Retourner l'ArrayList
        return liste;
    }

    /**
     * Methode qui retourne l'ArrayList des champs de la requete en parametre
     * @param requete
     * @return 
     * @throws java.sql.SQLException
     */
    public ArrayList remplirChampsRequete(String requete) throws SQLException {
        // récupération de l'ordre de la requete
        rset = stmt.executeQuery(requete);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();

        // creation d'une ArrayList de String
        ArrayList<String> liste;
        liste = new ArrayList<String>();

        // tant qu'il reste une ligne 
        while (rset.next()) {
            String champs;
            champs = rset.getString(1); // ajouter premier champ

            // Concatener les champs de la ligne separes par ,
            for (int i = 1; i < nbColonne; i++) {
                champs = champs + "," + rset.getString(i + 1);
            }

            // ajouter un "\n" à la ligne des champs
            champs = champs + "\n";

            // ajouter les champs de la ligne dans l'ArrayList
            liste.add(champs);
        }

        // Retourner l'ArrayList
        return liste;
    }

    /**
     * Méthode qui execute une requete de MAJ en parametre
     * @param requeteMaj
     * @throws java.sql.SQLException
     */
    public void executeUpdate(String requeteMaj) throws SQLException {
        stmt.executeUpdate(requeteMaj);
    }
    
    public Statement getStmt()
    {
        return stmt;
    }
    
    public Connection getConn()
    {
        return conn;
    }
    
    
    
    public ArrayList remplirEtudiant(String requete) throws SQLException {
        // récupération de l'ordre de la requete
        rset = stmt.executeQuery(requete);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();

        // creation d'une ArrayList de Etudiants
        ArrayList<Etudiant> liste;
        liste = new ArrayList();

        // tant qu'il reste une ligne 
        while (rset.next()) {
            
            int id = rset.getInt(1); // ajouter premier champ
            String nom;
            String prenom;
            Etudiant etudiant = null;

            // Concatener les champs de la ligne separes par ,
            for (int i = 2; i < nbColonne; i++) {
                //champs = champs + "," + rset.getString(i + 1);
                nom = rset.getString(i-1);
                prenom = rset.getString(i);
                etudiant = new Etudiant(nom,prenom,id);
                
            }

            // ajouter les champs de la ligne dans l'ArrayList
            liste.add(etudiant);
        }

        // Retourner l'ArrayList
        return liste;
    }
    
    public ArrayList remplirProfesseur(String requete) throws SQLException {
        // récupération de l'ordre de la requete
        rset = stmt.executeQuery(requete);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();

        // creation d'une ArrayList de Professeur
        ArrayList<Professeur> liste;
        liste = new ArrayList();

        // tant qu'il reste une ligne 
        while (rset.next()) {
            
            int id = rset.getInt(1); // ajouter premier champ
            String nom;
            String prenom;
            Professeur professeur = null;

            // Concatener les champs de la ligne separes par ,
            for (int i = 2; i < nbColonne; i++) {
                //champs = champs + "," + rset.getString(i + 1);
                nom = rset.getString(i-1);
                prenom = rset.getString(i);
                professeur = new Professeur(nom,prenom,id);
                
            }

            // ajouter les champs de la ligne dans l'ArrayList
            liste.add(professeur);
        }

        // Retourner l'ArrayList
        return liste;
    }
    
    
    public ArrayList remplirNiveaux(String requete) throws SQLException {
        // récupération de l'ordre de la requete
        rset = stmt.executeQuery(requete);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();

        // creation d'une ArrayList de String
        ArrayList<String> liste;
        liste = new ArrayList();

        // tant qu'il reste une ligne 
        while (rset.next()) {
            
            String niveaux = rset.getString(1);

            // ajouter les champs de la ligne dans l'ArrayList
            liste.add(niveaux);
        }

        // Retourner l'ArrayList
        return liste;
    }
    
    public ArrayList remplirClasse(String requete) throws SQLException {
        // récupération de l'ordre de la requete
        rset = stmt.executeQuery(requete);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();

        // creation d'une ArrayList de Classe
        ArrayList<Classe> liste;
        liste = new ArrayList();

        // tant qu'il reste une ligne 
        while (rset.next()) {
            
            int id; 
            String nom;
            String niveau;
            int annee;
            Classe classe = null;

            id = rset.getInt(1);
            nom = rset.getString(2);
            niveau = rset.getString(3);
            annee = rset.getInt(4);
            classe = new Classe(nom,niveau,annee, id);

            // ajouter les champs de la ligne dans l'ArrayList
            liste.add(classe);
        }

        // Retourner l'ArrayList
        return liste;
    }
    
    public ArrayList<ArrayList<Integer>> remplirInscription(String requete) throws SQLException {
        // récupération de l'ordre de la requete
        rset = stmt.executeQuery(requete);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();

        // creation d'une ArrayList d'arraylist de Int
        ArrayList<ArrayList<Integer>> liste;
        liste = new ArrayList();

        // tant qu'il reste une ligne 
        while (rset.next()) {
            
            ArrayList<Integer> l = new ArrayList();
            
            int id; 
            int etudiant;
            int classe;

            id = rset.getInt(1);
            etudiant = rset.getInt(2);
            classe = rset.getInt(3);
            
            l.add(id);
            l.add(etudiant);
            l.add(classe);
            

            // ajouter les champs de la ligne dans l'ArrayList
            liste.add(l);
        }

        // Retourner l'ArrayList
        return liste;
    }
    
    public ArrayList<ArrayList<Integer>> remplirTrimestre(String requete) throws SQLException {
        // récupération de l'ordre de la requete
        rset = stmt.executeQuery(requete);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();

        // creation d'une ArrayList d'arraylist de Int
        ArrayList<ArrayList<Integer>> liste;
        liste = new ArrayList();

        // tant qu'il reste une ligne 
        while (rset.next()) {
            
            ArrayList<Integer> l = new ArrayList();
            
            int id; 
            int numero;
            int debut;
            int fin;
            int anneeScolaire;

            id = rset.getInt(1);
            numero = rset.getInt(2);
            debut = rset.getInt(3);
            fin = rset.getInt(4);
            anneeScolaire = rset.getInt(5);
            
            l.add(id);
            l.add(numero);
            l.add(debut);
            l.add(fin);
            l.add(anneeScolaire);
            

            // ajouter les champs de la ligne dans l'ArrayList
            liste.add(l);
        }

        // Retourner l'ArrayList
        return liste;
    }
    
    public ArrayList<String> recupString(String requete) throws SQLException{
        // récupération de l'ordre de la requete
        rset = stmt.executeQuery(requete);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();
        
        ArrayList<String> liste = new ArrayList();
        
        while (rset.next()) {
            String phrase = rset.getString(1);
            liste.add(phrase);
        }
        
        return liste;
    }
    
    public ArrayList<ArrayList<Integer>> remplirBulletin(String requete) throws SQLException {
        // récupération de l'ordre de la requete
        rset = stmt.executeQuery(requete);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();

        // creation d'une ArrayList d'arraylist de Int
        ArrayList<ArrayList<Integer>> liste;
        liste = new ArrayList();

        // tant qu'il reste une ligne 
        while (rset.next()) {
            
            ArrayList<Integer> l = new ArrayList();
            
            int id; 
            int trimestre;
            int inscription;
            
            id = rset.getInt(1);
            trimestre = rset.getInt(3);
            inscription = rset.getInt(4);
            
            l.add(id);
            l.add(trimestre);
            l.add(inscription);
            

            // ajouter les champs de la ligne dans l'ArrayList
            liste.add(l);
        }

        // Retourner l'ArrayList
        return liste;
    }
    
    public ArrayList<ArrayList<Integer>> remplirEnseignement(String requete) throws SQLException {
        // récupération de l'ordre de la requete
        rset = stmt.executeQuery(requete);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();

        // creation d'une ArrayList d'arraylist de Int
        ArrayList<ArrayList<Integer>> liste;
        liste = new ArrayList();

        // tant qu'il reste une ligne 
        while (rset.next()) {
            
            ArrayList<Integer> l = new ArrayList();
            
            int id; 
            int classe;
            int prof;
            
            id = rset.getInt(1);
            classe = rset.getInt(3);
            prof = rset.getInt(4);
            
            l.add(id);
            l.add(classe);
            l.add(prof);
            

            // ajouter les champs de la ligne dans l'ArrayList
            liste.add(l);
        }

        // Retourner l'ArrayList
        return liste;
    }
    
    public ArrayList<ArrayList<Integer>> remplirEvaluation(String requete) throws SQLException {
        // récupération de l'ordre de la requete
        rset = stmt.executeQuery(requete);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();

        // creation d'une ArrayList d'arraylist de Int
        ArrayList<ArrayList<Integer>> liste;
        liste = new ArrayList();

        // tant qu'il reste une ligne 
        while (rset.next()) {
            
            ArrayList<Integer> l = new ArrayList();
            
            int id; 
            int note;
            int bulletin;
            
            id = rset.getInt(1);
            note = rset.getInt(2);
            bulletin = rset.getInt(4);
            
            l.add(id);
            l.add(note);
            l.add(bulletin);
            

            // ajouter les champs de la ligne dans l'ArrayList
            liste.add(l);
        }

        // Retourner l'ArrayList
        return liste;
    }
    
}
