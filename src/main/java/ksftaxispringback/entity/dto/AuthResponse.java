package ksftaxispringback.entity.dto;

import org.springframework.security.core.userdetails.UserDetails;

public class AuthResponse {
	private String token;
	private UserDetails person;

    public AuthResponse(UserDetails person, String token) {
        this.person = person;
        this.token = token;
    }
	
	public String getToken() {
		return token;
	}
	public UserDetails getPerson() {
		return person;
	}
	
}
