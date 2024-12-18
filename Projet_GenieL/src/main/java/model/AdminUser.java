package model;

import java.util.List;

public class AdminUser implements User {
    private int idAdmin;
    private String nomAdmin;
    private String prenomAdmin;
    private List<Integer> codeProfesseurs; // List of professor codes

    public AdminUser(){}
    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getNomAdmin() {
        return nomAdmin;
    }

    public void setNomAdmin(String nomAdmin) {
        this.nomAdmin = nomAdmin;
    }

    public String getPrenomAdmin() {
        return prenomAdmin;
    }

    public void setPrenomAdmin(String prenomAdmin) {
        this.prenomAdmin = prenomAdmin;
    }

    public List<Integer> getCodeprof() {
        return codeProfesseurs;
    }

    public void setCodeprof(List<Integer> codeProfesseurs) {
        this.codeProfesseurs = codeProfesseurs;
    }

    public AdminUser(int idAdmin, String nomAdmin, String prenomAdmin, List<Integer> codeprof) {
        this.idAdmin = idAdmin;
        this.nomAdmin = nomAdmin;
        this.prenomAdmin = prenomAdmin;
        this.codeProfesseurs = codeprof;
    }

    // Méthode toString
    @Override
    public String toString() {
        return "Professeur{" +
                "id=" + idAdmin +
                ", nom='" + nomAdmin + '\'' +
                ", nom='" + prenomAdmin + '\'' +
                ", liste des professeurs='" + codeProfesseurs + '\'' +

                '}';
    }


}