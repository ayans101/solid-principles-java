package single_responsibility.good_design;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {
    public boolean validateUser(User user) {
        return isValidUser(user);
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
