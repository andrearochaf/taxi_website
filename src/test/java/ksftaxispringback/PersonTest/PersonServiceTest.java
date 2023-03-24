package ksftaxispringback.PersonTest;

import ksftaxispringback.entity.Person;
import ksftaxispringback.exception.AccountExistsException;
import ksftaxispringback.service.JwtPersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class PersonServiceTest {


   private JwtPersonService jwtPersonService;
   @Autowired
   private EntityManager entityManager;
   @Autowired
   private DataSource dataSource;
    private Person person = new Person();

   @Test
    public void contextLoads(){
        assertNotNull(entityManager);
        assertNotNull(dataSource);
    }


    @BeforeEach
    public void setup(){

        person.setName("a");
        person.setFirstname("Alain");
        person.setLogin("alain");
        person.setPassword("pw");
        person.setEmail("a@a");
        person.setPhoneNumber("0000000000");
    }
    @Test
    public void shouldSavePersonSuccessfully() throws AccountExistsException {
       UserDetails personToSave = jwtPersonService.save(person.getName(), person.getFirstname(),
               person.getLogin(), person.getPassword(), person.getEmail(), person.getPhoneNumber());

       assertNotNull(personToSave);
       assertEquals(personToSave.getUsername(), person.getUsername());
    }

    @Test
    public void shouldGenerateJWT (){
      String token = jwtPersonService.generateJwtForUser(person);
        assertNotNull(token);
    }
    @Autowired
    public void setJwtPersonService(JwtPersonService jwtPersonService) {
        this.jwtPersonService = jwtPersonService;
    }
}
