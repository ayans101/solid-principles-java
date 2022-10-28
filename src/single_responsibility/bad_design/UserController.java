package single_responsibility.bad_design;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserController {
    private final Store store = new Store();

    public String createUser(String userJson) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(userJson, User.class);
        if (!isValidUser(user)) {
            return "ERROR";
        }
        store.store(user);
        return "SUCCESS";
    }

    private boolean isValidUser(User user) {
        if (!isPresent(user.getName())) {
            return false;
        }
        user.setName(user.getName().trim());
        if (!isValidAlphaNumeric(user.getName())) {
            return false;
        }
        if (!isPresent(user.getEmail())) {
            return false;
        }
        user.setEmail(user.getEmail().trim());
        return isValidEmail(user.getEmail());
    }

    private boolean isPresent(String name) {
        return name != null && name.trim().length() > 0;
    }

    private boolean isValidAlphaNumeric(String name) {
        //match a single character not present in the set [A-Za-z0-9]
        Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
        Matcher matcher = pattern.matcher(name);
        return !matcher.find();
    }

    private boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }
}
