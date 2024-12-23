package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.User;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    public User login(String username, String password) {
        // Validate credentials and return a User object
        if ("admin".equals(username) && "admin".equals(password)) {
            return new User("admin", "ADMIN");
        } else if ("user".equals(username) && "user".equals(password)) {
            return new User("user", "USER");
        } else {
            throw new RuntimeException("Invalid username or password!");
        }
    }
}
