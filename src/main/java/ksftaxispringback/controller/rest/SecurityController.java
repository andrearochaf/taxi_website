package ksftaxispringback.controller.rest;

import ksftaxispringback.entity.Person;
import ksftaxispringback.entity.dto.AuthRequest;
import ksftaxispringback.entity.dto.AuthResponse;
import ksftaxispringback.exception.AccountExistsException;
import ksftaxispringback.exception.UnauthorizedException;
import ksftaxispringback.service.JwtPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SecurityController {

	private JwtPersonService userService;

	@PostMapping("/authorize")
	public ResponseEntity<AuthResponse> authorize(@RequestBody AuthRequest requestDto) throws UnauthorizedException {
        Authentication authentication = null;
        try {
            authentication = userService.authenticate(requestDto.getUsername(), requestDto.getPassword());
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Token generation
            UserDetails user = (UserDetails) authentication.getPrincipal();
            String token = userService.generateJwtForUser(user);
            return ResponseEntity.ok(new AuthResponse(user, token));
        } catch(AuthenticationException e) {
            throw new UnauthorizedException();
        }
	}

	@PostMapping("/register")
	public ResponseEntity<AuthResponse> register(@RequestBody AuthRequest requestDto) throws AccountExistsException {
        UserDetails user = userService.save(requestDto.getName(), requestDto.getFirstName(),
                requestDto.getUsername(), requestDto.getPassword(), requestDto.getEmail(), requestDto.getPhone());
        String token = userService.generateJwtForUser(user);
		return ResponseEntity.ok(new AuthResponse(user, token));
	}

    @GetMapping("/persons/{username}")
    public UserDetails personByUsername(@PathVariable String username){
        return userService.loadUserByUsername(username) ;
    }

    @Autowired
    public void setUserService(JwtPersonService userService) {
        this.userService = userService;
    }
}
