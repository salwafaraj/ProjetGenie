package dao;

import model.CompteUtilisateur;

public interface ICompteUtilisateur {
    CompteUtilisateur findByLogin(String login);
    boolean authenticate(String login, String password);

}
