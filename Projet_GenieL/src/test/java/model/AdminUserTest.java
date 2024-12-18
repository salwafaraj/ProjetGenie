package model;

import model.AdminUser;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

public class AdminUserTest {

    private AdminUser adminUser;

    @Before
    public void setUp() {
        // Initialize an AdminUser instance for testing with a list of professor codes
        List<Integer> codesProfesseurs = Arrays.asList(101, 102, 103);
        adminUser = new AdminUser(1, "wissal", "ryad", codesProfesseurs);
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals(1, adminUser.getIdAdmin());
        assertEquals("wissal", adminUser.getNomAdmin());
        assertEquals("ryad", adminUser.getPrenomAdmin());

        // Verify the list of professor codes
        List<Integer> expectedCodes = Arrays.asList(101, 102, 103);
        assertEquals(expectedCodes, adminUser.getCodeprof());
    }

    @Test
    public void testSetters() {
        adminUser.setIdAdmin(2);
        adminUser.setNomAdmin("wissal");
        adminUser.setPrenomAdmin("ryad");
        adminUser.setCodeprof(Arrays.asList(201, 202)); // Update the list of professor codes

        assertEquals(2, adminUser.getIdAdmin());
        assertEquals("wissal", adminUser.getNomAdmin());
        assertEquals("ryad", adminUser.getPrenomAdmin());

        // Verify the updated list of professor codes
        List<Integer> expectedUpdatedCodes = Arrays.asList(201, 202);
        assertEquals(expectedUpdatedCodes, adminUser.getCodeprof());
    }
}
