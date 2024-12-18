package model;

import model.ProfesseurUser;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProfesseurUserTest {

    private ProfesseurUser professeurUser;

    @Before
    public void setUp() {
        // Initialize a ProfesseurUser instance for testing
        professeurUser = new ProfesseurUser(1, "wissal", "ryad", "IT", "0633445566");
    }

    @Test
    public void testConstructorAndGetters() {
        // Test constructor and getters
        assertEquals(1, professeurUser.getCodeProf());
        assertEquals("wissal", professeurUser.getNom());
        assertEquals("ryad", professeurUser.getPrenom());
        assertEquals("IT", professeurUser.getSpecialite());
        assertEquals("0633445566", professeurUser.getTelephone());
    }

    @Test
    public void testSetters() {
        // Test setters
        professeurUser.setCodeProf(2);
        professeurUser.setNom("salma");
        professeurUser.setPrenom("faraj");
        professeurUser.setSpecialite("BI");
        professeurUser.setTelephone("0644556677");

        assertEquals(2, professeurUser.getCodeProf());
        assertEquals("salma", professeurUser.getNom());
        assertEquals("faraj", professeurUser.getPrenom());
        assertEquals("BI", professeurUser.getSpecialite());
        assertEquals("0644556677", professeurUser.getTelephone());
    }
}
