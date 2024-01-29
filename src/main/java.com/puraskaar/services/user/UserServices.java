package puraskaar.services.user;

import puraskaar.entity.users.User;

import java.util.List;

public interface UserServices {

    public User saveUser(User user);

    public User getUserById(Long id);

    public User getUserByLoginId(String loginId);

    public List<User> getAllUsers();

    void deleteUser(User user);
}

