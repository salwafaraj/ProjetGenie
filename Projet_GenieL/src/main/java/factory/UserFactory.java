package factory;

import model.AdminUser;
import model.ProfesseurUser;
import model.User;

public class UserFactory {

    private UserFactory(){}

    public static User getUser(String userType) {

        if (userType == null) {
            throw new IllegalArgumentException("Type d'utilisateur ne peut pas être null.");
        }

        switch (userType) {
            case "administrateur":
                return new AdminUser();
            case "professeur":
                return new ProfesseurUser();
            default:
                throw new IllegalArgumentException("Type d'utilisateur non reconnu: " + userType);
        }
    }
}
