package puraskaar.services.user;

import jakarta.xml.bind.DatatypeConverter;
import puraskaar.entity.users.User;
import puraskaar.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        try {
            user.setPassword(encryptPassword(user.getPassword()));
        } catch (NoSuchAlgorithmException e) {
            System.out.println(new RuntimeException(e).getStackTrace());
        }
        return userRepository.save(user);
    }

    @Override
    public String encryptPassword(String pass) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(pass.getBytes());
        byte[] digest = md.digest();
        pass = DatatypeConverter.printHexBinary(digest).toUpperCase();
        return pass;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User getUserByLoginId(String loginId) {
        return userRepository.findByLoginId(loginId).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}
