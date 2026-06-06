package in.ac.nitw.placement_portal.dto;

import in.ac.nitw.placement_portal.constants.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AuthResponse {

    private String token;

    private String email;

    private String name;

    private UserRole role;
}
