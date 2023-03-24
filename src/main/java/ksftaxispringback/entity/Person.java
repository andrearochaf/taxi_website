package ksftaxispringback.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//permet d'avoir une table person et une autre driver
public class Person implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Civility civility;
    private String name;
    private String firstname;
    @Column(unique = true, length = 32) // security : avoid conceptual duplicates to avoid unexpected behaviors
    private String login;
    @JsonIgnore
    private String password;
    private String phoneNumber;
    private String email;
    private LocalDate disableAccountDate;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles;

    public Person() {
    }

    public Person(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public Civility getCivility() {
        return civility;
    }
    public String getName() {
        return name;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getLogin() {
        return login;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public LocalDate getDisableAccountDate() {
        return disableAccountDate;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return login;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setCivility(Civility civility) {
        this.civility = civility;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setDisableAccountDate(LocalDate disableAccountDate) {
        this.disableAccountDate = disableAccountDate;
    }
    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
