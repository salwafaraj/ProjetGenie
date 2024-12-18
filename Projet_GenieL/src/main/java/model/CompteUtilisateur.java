package model;

public class CompteUtilisateur {

    private int idCompte;
    private String typeutilisateur;
    private String login;
    private String motPasse;
    private int idProf;
    private int idAdmin;

    public CompteUtilisateur(){

    }
    public CompteUtilisateur(int idCompte, String typeutilisateur, String login, String motPasse, int idProf, int idAdmin) {
        this.idCompte = idCompte;
        this.typeutilisateur = typeutilisateur;
        this.login = login;
        this.motPasse = motPasse;
        this.idProf = idProf;
        this.idAdmin = idAdmin;
    }

    public int getIdCompte() {
        return idCompte;
    }
    public void setIdCompte(int idCompte) {
        this.idCompte = idCompte;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getMotPasse() {
        return motPasse;
    }
    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }
    public int getIdProf() {
        return idProf;
    }
    public void setIdProf(int idProf) {
        this.idProf = idProf;
    }
    public int getIdAdmin() {
        return idAdmin;
    }
    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }
    public String getTypeutilisateur() {
        return typeutilisateur;
    }
    public void setTypeutilisateur(String typeutilisateur) {
        this.typeutilisateur = typeutilisateur;
    }
}
