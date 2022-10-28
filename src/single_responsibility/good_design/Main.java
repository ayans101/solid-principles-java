package single_responsibility.good_design;

import java.io.IOException;

public class Main {
    //A valid USER JSON String
    private static final String VALID_USER_JSON = "{\"name\": \"Ayan\", \"email\": \"ayan@email.com\", \"address\": \"Kolkata\"}";

    //Invalid USER JSON String - email format wrong
    private static final String INVALID_USER_JSON = "{\"name\": \"Aryan\", \"email\": \"aryan@email\", \"address\": \"Kolkata\"}";

    public static void main(String[] args) throws IOException {
        UserController controller = new UserController();
        String response = controller.createUser(VALID_USER_JSON);
        if (!response.equalsIgnoreCase("SUCCESS")) {
            System.err.println("Failed");
        }
        System.out.println("Valid JSON received response: " + response);

        response = controller.createUser(INVALID_USER_JSON);
        if (!response.equalsIgnoreCase("ERROR")) {
            System.err.println("Failed");
        }
        System.out.println("Invalid JSON received response: " + response);


    }
}
