package factory;

import model.AdminUser;
import model.ProfesseurUser;
import model.User;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserFactoryTest {

    @Test
    public void testGetUser_AdminUser() {
        User user = UserFactory.getUser("administrateur");
        assertNotNull(user);
        assertTrue(user instanceof AdminUser);
    }

    @Test
    public void testGetUser_ProfesseurUser() {
        User user = UserFactory.getUser("professeur");
        assertNotNull(user);
        assertTrue(user instanceof ProfesseurUser);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetUser_InvalidType() {
        UserFactory.getUser("unknownType");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetUser_NullType() {
        UserFactory.getUser(null);
    }
}
