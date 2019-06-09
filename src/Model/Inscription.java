/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * Classe Inscription
 * @author Emma
 */
public class Inscription {
    
     /** Attributs */
    private Etudiant etudiant;
    private Classe classe;  
    private int id;
    
    /** Constructeur par defaut */
    public Inscription()
    {
        
    }
    
    /** Constructeur surchargé
     * @param etudiant
     * @param classe
     * @param id
     */
    public Inscription(Etudiant etudiant, Classe classe, int id)
    {
        this.etudiant = etudiant;
        this.classe = classe;
        this.id = id;
    }
    
    /** Getter qui permet de récupérer l'id de l'inscription
     * 
     * @return id : entier de l'id
     */
    public int getID()
    {
        return id;
    }   
    
    /** Getter qui pemret de récupérer l'étudiant
     * 
     * @return etudiant : etudiant de l'inscription
     */
    public Etudiant getEtudiant(){
        return etudiant;
    }
    
    /** Getter qui permet de récupérer la classe
     * 
     * @return classe : classe dans l'etudiant est inscrit
     */
    public Classe getClasse(){
        return classe;
    }
}
