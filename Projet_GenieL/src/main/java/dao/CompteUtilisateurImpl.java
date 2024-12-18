package dao;

import model.CompteUtilisateur;
import utils.dbutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class CompteUtilisateurImpl implements ICompteUtilisateur {

    // Regex pattern to validate email format
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@gmail\\.com$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    @Override
    public CompteUtilisateur findByLogin(String login) {
        CompteUtilisateur utilisateur = null;
        String sql = "SELECT * FROM compteutilisateur WHERE login = ?";

        try (Connection conn = dbutil.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, login);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                utilisateur = new CompteUtilisateur();
                utilisateur.setIdCompte(rs.getInt("idCompte"));
                utilisateur.setTypeutilisateur(rs.getString("type_utilisateur"));
                utilisateur.setLogin(rs.getString("login"));
                utilisateur.setMotPasse(rs.getString("motPasse"));
                utilisateur.setIdProf(rs.getInt("codeProf"));
                utilisateur.setIdProf(rs.getInt("idAdmin"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateur;
    }

    @Override
    public boolean authenticate(String login, String password) {
        // Validate the email format
        if (!isValidEmail(login)) {
            System.out.println("Invalid email format. Please enter a valid email (e.g., nom@gmail.com).");
            return false; // Return false if the email format is invalid
        }

        String sql = "SELECT * FROM compteutilisateur WHERE login = ? AND motPasse = ?";
        try (Connection conn = dbutil.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, login);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // If a result is found, the credentials are correct
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Return false in case of an exception or if no result is found
    }

    // Method to validate email format
    public boolean isValidEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }
}
