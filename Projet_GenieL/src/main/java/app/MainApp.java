package app;

import dao.CompteUtilisateurImpl;
import model.CompteUtilisateur;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CompteUtilisateurImpl dao = new CompteUtilisateurImpl();

        System.out.println("=== Connexion ===");
        System.out.print("Login : ");
        String login = scanner.nextLine();

        // Validate email format
        boolean isValideEmail = dao.isValidEmail(login);
        if (!isValideEmail) {
            System.out.println("Entrer un email valide");
            // Close the scanner and exit the application if the email is invalid
            scanner.close();
            return; // Exit the main method
        }

        System.out.print("Mot de passe : ");
        String password = scanner.nextLine();

        // Authenticate the user
        boolean isAuthenticated = dao.authenticate(login, password);

        if (isAuthenticated) {
            CompteUtilisateur utilisateur = dao.findByLogin(login);
            System.out.println("Connexion réussie !");
            System.out.println("Bienvenue " + utilisateur.getLogin());
            System.out.println("Type d'utilisateur : " + utilisateur.getTypeutilisateur());
        } else {
            System.out.println("Identifiants incorrects.");
        }

        scanner.close();
    }
}
