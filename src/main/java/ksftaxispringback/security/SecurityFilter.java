package ksftaxispringback.security;

import ksftaxispringback.service.JwtPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class SecurityFilter extends OncePerRequestFilter {
    //Ce qui va s'actionner à chaque requête, car a chaque requete on oublie le client vu que c'est stateless
	//le middleware = une chaine de filter, il est avant le controller. Il est constitué de filtre
	//plusieurs filters = à chaque filter, un control de qqc puis ça passe au suivant




	private JwtPersonService userService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {  //regarde si le token est valide
        try {
            String token = extractTokenFromHeader(request);
            UserDetails user = userService.getUserFromJwt(token);
            setPrincipalInSecurityContext(user);
        } catch (Exception e) {
            logger.info("Trying parse token but failed");
        }
        filterChain.doFilter(request, response);
	}

	private String extractTokenFromHeader(HttpServletRequest request) {
		//dans le header il y a la requete entre autre et son token et d'autres trucs (il y a le username et password dans le payload)
		String bearerToken = request.getHeader("Authorization"); //rechercher dans le header la variable authorisation, sa valeur étant le token
		if (bearerToken != null) {
			return bearerToken.substring(7, bearerToken.length()); //le token commence à partir du 7ᵉ caratere de authorization
		}
		return null;
	}

	private void setPrincipalInSecurityContext(UserDetails user) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities()); //on recupere les roles du principal
		SecurityContextHolder.getContext().setAuthentication(token); //on distribue le role à chaque "service" de l'application
	}

	@Autowired
	public void setUserService(JwtPersonService userService) {
		this.userService = userService;
	}
}