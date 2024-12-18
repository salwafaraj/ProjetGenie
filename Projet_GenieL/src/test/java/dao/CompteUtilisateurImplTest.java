package dao;

import model.CompteUtilisateur;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CompteUtilisateurImplTest {

    private CompteUtilisateurImpl dao;

    @Before
    public void setUp() throws Exception {
        dao = new CompteUtilisateurImpl();
    }

    @After
    public void tearDown() throws Exception {
        // No cleanup needed since we're using existing users
    }

    @Test
    public void testFindByLogin() {
        String existingLogin = "wissal@gmail.com";
        CompteUtilisateur actualUtilisateur = dao.findByLogin(existingLogin);

        // Assert that the returned user is as expected
        assertNotNull(actualUtilisateur);
        assertEquals(existingLogin, actualUtilisateur.getLogin());
    }

    @Test
    public void testAuthenticate() {
        // Test with valid credentials
        String validLogin = "wissal@gmail.com";
        String validPassword = "1234";
        boolean isAuthenticated = dao.authenticate(validLogin, validPassword);
        assertTrue(isAuthenticated);

        // Test with an invalid password
        String invalidPassword = "0000";
        isAuthenticated = dao.authenticate(validLogin, invalidPassword);
        assertFalse(isAuthenticated);

        // Test with an invalid login
        String invalidLogin = "wrong@gmail.com";
        isAuthenticated = dao.authenticate(invalidLogin, validPassword);
        assertFalse(isAuthenticated);
    }
}
