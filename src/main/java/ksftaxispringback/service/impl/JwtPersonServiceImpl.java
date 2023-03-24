package ksftaxispringback.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import ksftaxispringback.entity.Person;
import ksftaxispringback.exception.AccountExistsException;
import ksftaxispringback.repository.PersonDao;
import ksftaxispringback.repository.RoleDao;
import ksftaxispringback.service.JwtPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;

@Configuration
@Service
public class JwtPersonServiceImpl implements JwtPersonService {


    private PersonDao personDao;
    private AuthenticationManager authenticationManager;
    private final String signingKey;
    private RoleDao roleDao;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  //pour hacher le mot de passe, impossible de dé-hasher
    }

    public JwtPersonServiceImpl(@Value("${jwt.signing.key}") String signingKey) {  //signature du token
        this.signingKey = signingKey;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { //recuperer qqn a partir d'un login
        Person person = personDao.findByLogin(username);
        if (person == null) {
            throw new UsernameNotFoundException("The person could not be found");
        }
        return person;
    }

    // Used for registration
    public UserDetails save(String name, String firstName,String username,
                            String password, String email, String phone ) throws AccountExistsException {
        if (personDao.findByLogin(username) != null) {
            throw new AccountExistsException();
        }
        Person person = new Person();
        person.setLogin(username);
        person.setPassword(passwordEncoder().encode(password));
        person.setEmail(email);
        person.setName(name);
        person.setFirstname(firstName);
        person.setPhoneNumber(phone);
        person.setRoles(Arrays.asList(roleDao.findByName("client")));
        personDao.save(person);
        return person;
    }

    public String generateJwtForUser(UserDetails user) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + 3600 * 2);  //c'est la date d'expiration du token,
        // 2h apres la now. par default ily en a pas attention
        return Jwts.builder().setSubject(user.getUsername()).setIssuedAt(now).setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, signingKey)
                .compact(); //Ticket non stoqué dans le projet. Tocket date now jusqu'à expiration avec signature
    }

    // Used for authentication
    public UserDetails getUserFromJwt(String jwt) {
        String username = getUsernameFromToken(jwt);
        return loadUserByUsername(username);
    }

    private String getUsernameFromToken(String token) { //recupere la partie 2 du token qui correspond au nom de l'utilisateur
        System.out.println(signingKey);
        Claims claims = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }



    public Authentication authenticate(String username, String password) throws AuthenticationException {
        Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);
        return authenticationManager.authenticate(authentication);
    }

    @Autowired
    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
@Autowired
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
}
