package ksftaxispringback.repository;

import ksftaxispringback.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonDao extends JpaRepository<Person, Long> {

    Person findById(long id);

    // Adding for retrieving user from login - security
    Person findByLogin(String login);

    @Query("SELECT p FROM Person p WHERE p.login = :login AND p.password = :password")
    Person findByLoginAndPassword(@Param("login") String login, @Param("password") String password);
}
