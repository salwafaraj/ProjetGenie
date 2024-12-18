package model;

public class Module {
    private int id_module;       
    private String nom;         
    private int id_filiere;      
    private int id_semestre;     

    // Constructeur
    public Module(int id_module, String nom, int id_filiere, int id_semestre) {
        this.id_module = id_module;
        this.nom = nom;
        this.id_filiere = id_filiere;
        this.id_semestre = id_semestre;
    }

    // Getters et Setters
    public int getIdModule() {
        return id_module;
    }

    public void setIdModule(int id_module) {
        this.id_module = id_module;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getIdFiliere() {
        return id_filiere;
    }

    public void setIdFiliere(int id_filiere) {
        this.id_filiere = id_filiere;
    }

    public int getIdSemestre() {
        return id_semestre;
    }

    public void setIdSemestre(int id_semestre) {
        this.id_semestre = id_semestre;
    }

    // Méthode toString
    @Override
    public String toString() {
        return "Module{" +
               "id_module=" + id_module +
               ", nom='" + nom + '\'' +
               ", id_filiere=" + id_filiere +
               ", id_semestre=" + id_semestre +
               '}';
    }
}
