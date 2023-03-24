package ksftaxispringback.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtPersonService extends PersonService {

    String generateJwtForUser(UserDetails user);
    UserDetails getUserFromJwt(String jwt);

}
