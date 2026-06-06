package in.ac.nitw.placement_portal.usecase;

import in.ac.nitw.placement_portal.api.UserApi;
import in.ac.nitw.placement_portal.constants.UserRole;
import in.ac.nitw.placement_portal.dto.AuthResponse;
import in.ac.nitw.placement_portal.dto.LoginForm;
import in.ac.nitw.placement_portal.dto.RegisterForm;
import in.ac.nitw.placement_portal.pojo.UserPojo;
import in.ac.nitw.placement_portal.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthUseCase {

    @Autowired
    private UserApi userApi;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public AuthResponse register(RegisterForm form) {
        if (userApi.getByEmail(form.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already registered");
        }

        UserPojo user = new UserPojo();
        user.setEmail(form.getEmail());
        user.setPasswordHash(passwordEncoder.encode(form.getPassword()));
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setRole(resolveRole(form.getEmail()));
        userApi.saveUser(user);

        String token = jwtUtil.generateToken(user.getEmail(), user.getRole());
        return new AuthResponse(token, user.getEmail(), fullName(user), user.getRole());
    }

    public AuthResponse login(LoginForm form) {
        UserPojo user = userApi.getByEmail(form.getEmail())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid email or password"));

        if (!passwordEncoder.matches(form.getPassword(), user.getPasswordHash())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid email or password");
        }

        String token = jwtUtil.generateToken(user.getEmail(), user.getRole());
        return new AuthResponse(token, user.getEmail(), fullName(user), user.getRole());
    }

    // mirrors the routing logic in the RAS login page:
    // taps@nitw.ac.in -> placement office, @student.nitw.ac.in -> student
    private UserRole resolveRole(String email) {
        if (email.endsWith("taps@nitw.ac.in")) {
            return UserRole.HEAD_OFFICER;
        }
        if (email.endsWith("@student.nitw.ac.in")) {
            return UserRole.STUDENT;
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Register with your institute email-ID");
    }

    private String fullName(UserPojo user) {
        return user.getLastName() == null ? user.getFirstName()
                : user.getFirstName() + " " + user.getLastName();
    }
}
