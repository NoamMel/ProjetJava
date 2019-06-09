/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * Classe Enseignement
 * @author Emma
 */
public class Enseignement {
    
    /** Attributs */
    private int id;
    private String discipline;
    private Classe classe;
    private Professeur professeur;  
    
    /** Constructeur par défaut*/
    public Enseignement()
    {
    
    }
    
    /** Constructeur surchargé
     * @param discipline
     * @param classe
     * @param professeur
     * @param id */
    public Enseignement(String discipline, Classe classe, Professeur professeur, int id)
    {
        this.discipline = discipline;
        this.classe= classe;
        this.professeur = professeur;
        this.id = id;
    }
    
    /** Getter qui permet de récupérer l'id de l'enseignement
     * 
     * @return 
     */
    public int getID()
    {
        return id;
    }
    
    /** Getter qui permet de récupérer la discipline
     * 
     * @return 
     */
    public String getDiscipline(){
        return discipline;
    }
    
    /** Getter qui permet de récupérer la classe
     * 
     * @return 
     */
    public Classe getClasse(){
        return classe;
    }
    
    /** Getter qui permet de récupérer le professeur
     * 
     * @return 
     */
    public Professeur getProfesseur(){
        return professeur;
    }
}
