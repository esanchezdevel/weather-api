package esanchez.devel.weather.configuration;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtService {
    
    @Autowired
    private AppConfiguration configuration;
	
    public String createJWT(JwtToken jwtToken, Credentials credentials) {
		  
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId(jwtToken.getId())
				.setSubject(credentials.getUsername())
				.setIssuer(jwtToken.getIssuer())
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + jwtToken.getTimeToLive()))
				.signWith(SignatureAlgorithm.HS512,
						configuration.getJwtSecretKey().getBytes()).compact();

		return "Bearer " + token;
	}
    
	public Claims decodeJWT(String jwt) {
	    //This line will throw an exception if it is not a signed JWS (as expected)
	    Claims claims = Jwts.parser()
	            .setSigningKey(DatatypeConverter.parseBase64Binary(configuration.getJwtSecretKey()))
	            .parseClaimsJws(jwt).getBody();
	    return claims;
	}
}
