package single_responsibility.good_design;

import java.io.IOException;

public class UserController {
    private final UserPersistenceService persistenceService = new UserPersistenceService();

    public String createUser(String userJson) throws IOException {
        JsonToUserParser jsonToUserParser = new JsonToUserParser();
        User user = jsonToUserParser.parseJsonToUser(userJson);

        UserValidator validator = new UserValidator();
        boolean valid = validator.validateUser(user);
        if (!valid) {
            return "ERROR";
        }

        persistenceService.saveUser(user);

        return "SUCCESS";
    }
}
