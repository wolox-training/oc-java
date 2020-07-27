package wolox.training.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncoderService {

    private static PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static String encode(String password) {
        String encoded = getPasswordEncoder().encode(password);
        return encoded;
    }

    public static boolean passwordMatch(String password, String encoded) {
        return getPasswordEncoder().matches(password, encoded);
    }
}
