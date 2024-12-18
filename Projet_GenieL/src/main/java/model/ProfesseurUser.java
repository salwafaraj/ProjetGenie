package model;

public class ProfesseurUser implements User {


    private int codeProf;
    private String nom;
    private String prenom;
    private String specialite;
    private String telephone;


    public ProfesseurUser() {
    }

    public ProfesseurUser(int codeProf, String nom, String prenom, String specialite, String telephone) {
        this.codeProf = codeProf;
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
        this.telephone = telephone;
    }

    public int getCodeProf() {
        return codeProf;
    }

    public void setCodeProf(int codeProf) {
        this.codeProf = codeProf;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    // Méthode toString
    @Override
    public String toString() {
        return "Professeur{" +
                "id=" + codeProf +
                ", nom='" + nom + '\'' +
                ", nom='" + prenom + '\'' +
                ", specialite='" + specialite + '\'' +
                ", telephone='" + telephone + '\'' +

                '}';
    }

}

