package ksftaxispringback.service;

import ksftaxispringback.exception.AccountExistsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface PersonService extends UserDetailsService {
    
    Authentication authenticate(String username, String password) throws AuthenticationException;
    UserDetails save(String name, String firstName, String login, String password, String email, String phoneNumber ) throws AccountExistsException;

}
