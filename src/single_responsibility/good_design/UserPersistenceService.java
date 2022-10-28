package single_responsibility.good_design;

public class UserPersistenceService {
    private final Store store = new Store();

    public void saveUser(User user) {
        store.store(user);
    }
}
