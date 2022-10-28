package single_responsibility.good_design;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonToUserParser {
    public User parseJsonToUser(String userJson) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(userJson, User.class);
        return user;
    }
}
