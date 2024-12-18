package model;

import model.CompteUtilisateur;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CompteUtilisateurTest {

    private CompteUtilisateur compteUtilisateur;

    @Before
    public void setUp() {
        // Initialize a CompteUtilisateur instance for testing
        compteUtilisateur = new CompteUtilisateur(1, "administrateur", "admin@example.com", "password123", 101, 1);
    }

    @Test
    public void testConstructorAndGetters() {
        // Test constructor and getters
        assertEquals(1, compteUtilisateur.getIdCompte());
        assertEquals("administrateur", compteUtilisateur.getTypeutilisateur());
        assertEquals("admin@example.com", compteUtilisateur.getLogin());
        assertEquals("password123", compteUtilisateur.getMotPasse());
        assertEquals(101, compteUtilisateur.getIdProf());
        assertEquals(1, compteUtilisateur.getIdAdmin());
    }

    @Test
    public void testSetters() {
        // Test setters
        compteUtilisateur.setIdCompte(2);
        compteUtilisateur.setTypeutilisateur("professeur");
        compteUtilisateur.setLogin("prof@example.com");
        compteUtilisateur.setMotPasse("newpassword456");
        compteUtilisateur.setIdProf(102);
        compteUtilisateur.setIdAdmin(2);

        assertEquals(2, compteUtilisateur.getIdCompte());
        assertEquals("professeur", compteUtilisateur.getTypeutilisateur());
        assertEquals("prof@example.com", compteUtilisateur.getLogin());
        assertEquals("newpassword456", compteUtilisateur.getMotPasse());
        assertEquals(102, compteUtilisateur.getIdProf());
        assertEquals(2, compteUtilisateur.getIdAdmin());
    }
}
