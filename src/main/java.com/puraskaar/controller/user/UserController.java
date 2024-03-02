package puraskaar.controller.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import puraskaar.entity.users.User;
import puraskaar.exceptionhandler.UserNotFoundException;
import puraskaar.services.user.UserServices;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    UserServices userServices;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userServices.saveUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userServices.getUserById(id);
        if(user==null)  throw new UserNotFoundException("User not Found, id: " + id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping("/login/{loginId}")
    public ResponseEntity<User> getUserByLoginId(@PathVariable String loginId) {
        User user = userServices.getUserByLoginId(loginId);
        if(user==null)  throw new UserNotFoundException("User not Found, id: " + loginId);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        System.out.println("I am here");
        List<User> users = userServices.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        User user = userServices.getUserById(id);
        if(user==null)  throw new UserNotFoundException("User not Found, id: " + id);
        else userServices.deleteUser(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
